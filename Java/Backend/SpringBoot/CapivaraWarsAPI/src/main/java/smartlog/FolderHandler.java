package smartlog;

// <editor-fold defaultstate="collapsed" desc="imports...">
import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 *
 * Description: ...
 *
 * @version 1.0.0
 * @author tiago, 1 de jun de 2019, 18:47:52
 */// </editor-fold>
public class FolderHandler {
    
    //    <editor-fold defaultstate="collapsed" desc="static attributes...">
    public static String USER_PATH = System.getProperty("user.home");
    //    </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="methods...">
    
    //    <editor-fold defaultstate="collapsed" desc="auxiliary methods...">
    private static String getFullUrlClean(String url, String folderName) {
        url = url.trim();
        folderName = folderName.trim();

        if (url.charAt(url.length() - 1) != '/' && url.charAt(url.length() - 1) != '\\') {
            url += "/" + folderName;
        } else {
            url += folderName;
        }

        return url;
    }

    private static void recursivelyRemoveSubfoldersAndFiles(File folder) {
        if (folder != null && folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (int count = 0; count < files.length; count++) {
                    recursivelyRemoveSubfoldersAndFiles(files[count]);
                }
            }
        }

        folder.delete();
    }
    //    </editor-fold>

    //    <editor-fold defaultstate="collapsed" desc="static methods...">
    public static boolean folderExists(String url, String folderName) {
        url = getFullUrlClean(url, folderName);
        File folder = new File(url);
        if (folder.exists() && folder.isDirectory()) {
            return true;
        }
        return false;
    }

    public static String[] getListOfFiles(String url, String folderName) {
        url = getFullUrlClean(url, folderName);
        File folder = new File(url);
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                List<String> fileNames = new ArrayList<>();
                for (int count = 0; count < files.length; count++) {
                    if (files[count].isFile()) {
                        fileNames.add(files[count].getName());
                    }
                }
                return fileNames.toArray(new String[0]);
            }
        }
        return null;
    }
    
    public static String[] getListOfFilesAndSubfolders(String url, String folderName) {
        url = getFullUrlClean(url, folderName);
        File folder = new File(url);
        if (folder.exists() && folder.isDirectory()) {
            return folder.list();
        }
        return null;
    }

    public static boolean createFolder(String url, String newFolderName) {
        if (folderExists(url, "")) {
            url = getFullUrlClean(url, newFolderName);
            File folder = new File(url);

            if (!folder.exists()) {
                folder.mkdir();
                return true;
            }
        }

        return false;
    }

    public static boolean createFolderWithSubfolders(String url, String newFolderName) {
        if (folderExists(url, "")) {
            url = getFullUrlClean(url, newFolderName);
            File folder = new File(url);

            if (!folder.exists()) {
                folder.mkdir();
                return true;
            }
        } else {
            url = getFullUrlClean(url, newFolderName);
            File folder = new File(url);

            if (!folder.exists()) {
                folder.mkdirs();
                return true;
            }

            return false;
        }

        return false;
    }

    public static boolean removeFolderAndSubContents(String url, String folderName) {
        url = getFullUrlClean(url, folderName);
        File folder = new File(url);
        if (folder.exists() && folder.isDirectory()) {
            if (folder.list().length == 0) {
                folder.delete();
                return true;
            }

            if (folder.list().length > 0) {
                recursivelyRemoveSubfoldersAndFiles(folder);

                if (folder.list() != null && folder.list().length > 0) {
                    return false;
                }

                return true;
            }
        }

        return false;
    }
    
    public static boolean renameFolder(String url, String folderName, String newFolderName){
        if (folderExists(url, "")) {
            url = getFullUrlClean(url, folderName);
            File folder = new File(url);

            if (!folder.exists()) {                
                try {
                    Files.move(folder.toPath(), folder.toPath().resolveSibling(newFolderName));
                    return true;
                } catch (Exception ex) {
                    return false;
                }
            }
        }

        return false;
    }
    //    </editor-fold>

    //</editor-fold>
    
}//class
