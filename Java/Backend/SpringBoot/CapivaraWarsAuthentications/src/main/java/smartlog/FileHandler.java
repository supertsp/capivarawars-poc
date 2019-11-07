package smartlog;

// <editor-fold defaultstate="collapsed" desc="imports...">
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 *
 * Description: ...
 *
 * @version 1.0.0
 * @author tiago, 1 de jun de 2019, 22:07:13
 */// </editor-fold>
public class FileHandler {

    //<editor-fold defaultstate="collapsed" desc="attributes...">
    //    <editor-fold defaultstate="collapsed" desc="main attributes...">    
    private String url;
    private String fileName;
    private String extension;
    private String fullUrl;
    private boolean opened;
    private List<String> lines;
    private String dateTimeOfLastSave;
    //    </editor-fold>

    //    <editor-fold defaultstate="collapsed" desc="constants attributes...">
    //
    //    </editor-fold>
    
    //    <editor-fold defaultstate="collapsed" desc="static attributes...">
    //
    //    </editor-fold>
    
    //    <editor-fold defaultstate="collapsed" desc="auxiliary attributes...">
    private boolean forceCreate;
    private File file;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private List<String> linesWhitoutBlankSpaces = new ArrayList<>();
    private int count;
    private int countBlankSpace;
    private String tempLine = "";
    private char[] tempCharLine;
    private StringBuffer tempBuffered = new StringBuffer();
    private boolean tempValidation;
    //    </editor-fold>

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constructors...">
    public FileHandler(boolean forceCreate, String url, String fileName, String extension) {
        url = url.trim();
        fileName = fileName.trim();
        extension = extension.trim();

        this.forceCreate = forceCreate;
        this.url = url;
        this.fileName = fileName;
        this.extension = extension;
        this.fullUrl = getFullUrlClean(this.url, this.fileName, this.extension);
        
        file = new File(this.fullUrl);

        lines = new ArrayList<>();
        
        boolean fileExists = exists();
        
        if (forceCreate && !fileExists) {
            try {
                file.createNewFile();
            } catch (Exception ex) {                
            }
        } 
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="methods...">
    
    //    <editor-fold defaultstate="collapsed" desc="getter and setter methods...">
    public String getUrl() {
        return url;
    }

    public String getFileName() {
        return fileName;
    }

    public String getExtension() {
        return extension;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public boolean isOpened() {
        return opened;
    }

    public List<String> getLines() {
        return lines;
    }

    public String getDateTimeOfLastSave() {
        return dateTimeOfLastSave;
    }    
    
    //    </editor-fold>

    //    <editor-fold defaultstate="collapsed" desc="override methods...">
    @Override
    public String toString() {
        return 
                fileName + 
                "{ Opened: " + isOpened() + 
                "  |  Empty: " + isEmpty() + 
                "  |  Count Lines: " + countLines() + 
                "  |  Last Save: " + getDateTimeOfLastSave() + 
                "  |  Full URL: " + getFullUrl() + 
                " }";
    }

    //    </editor-fold>
    
    //    <editor-fold defaultstate="collapsed" desc="auxiliary methods...">
    private static String getFullUrlClean(String url, String fileName, String extension) {
        url = url.trim();
        fileName = fileName.trim();
        extension = extension.trim();

        if (url.charAt(url.length() - 1) != '/' && url.charAt(url.length() - 1) != '\\') {
            url += "/" + fileName + "." + extension;
        } else {
            url += fileName + "." + extension;
        }

        return url;
    }
    
//    private void saveContentOnBufferedWriter() {
//        if (isOpened()) {
//            try {
//                bufferedWriter.append(getLinesAsString());
//            } catch (Exception e) {
//            }
//        }
//    }
    
    private boolean openOperations() {
        opened = false;
        boolean fileExists = exists();

        try {
            //esse objeto gera um novo arquivo
            bufferedReader = new BufferedReader(new FileReader(file));
            
            opened = true; //habilita o preenchimento
            fillLines();
            opened = false; //volta ao normal
            
        } catch (Exception ex) {
//            System.out.println("Could not enable READ operation for file \"" + fullUrl + "\"");
            return false;
        }

        if (!forceCreate && !fileExists) {
            closeOperations();
            file.delete();
            return false;
        } else {
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(file)); //reset all lines
//                bufferedWriter = new BufferedWriter(new FileWriter(file, true)); //increment line
                opened = true;
                return true;
            } catch (Exception ex) {
//                System.out.println("Could not enable WRITE operation for file \"" + fullUrl + "\"");
                return false;
            }
        }
    }

    private boolean closeOperations() {
        try {
            bufferedReader.close();

            bufferedWriter.flush();
            bufferedWriter.close();

            opened = false;

            return true;
        } catch (Exception ex) {

        }

        return false;
    }

    private void fillLines() {
        lines.clear();
        linesWhitoutBlankSpaces.clear();

        try {
            do {
                tempLine = bufferedReader.readLine();
                if (tempLine != null) {
                    addLine(tempLine); //só adciona se "opened" = true
                }
            } while (tempLine != null);
        } catch (Exception ex) {
        }
    }

    private String convertNormalLineToLineWithoutBlankSpaces(String newLine) {
        tempCharLine = newLine.trim().replaceAll("\t", " ").toCharArray();
        tempBuffered.delete(0, tempBuffered.length());
        countBlankSpace = 0;
        for (int countChar = 0; countChar < tempCharLine.length; countChar++) {
            if (tempCharLine[countChar] != ' ') {
                tempBuffered.append(tempCharLine[countChar]);

                if (countBlankSpace >= 2) {
                    countBlankSpace = 0;
                }
            } else {
                countBlankSpace++;

                if (countBlankSpace < 2) {
                    tempBuffered.append(' ');
                }
            }
        }

        return tempBuffered.toString();
    }
    //    </editor-fold>

    //    <editor-fold defaultstate="collapsed" desc="static methods...">
    public static boolean fileExists(String url, String fileName, String extension) {
        url = getFullUrlClean(url, fileName, extension);
        File file = new File(url);
        if (file.exists() && file.isFile()) {
            return true;
        }
        return false;
    }
    
    public static String getCurrentDate(){
        return
                Calendar.getInstance().get(Calendar.YEAR) + "-" +
                (Calendar.getInstance().get(Calendar.MONTH) + 1) + "-" +
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    }
    
    public static String getCurrentDateTime(){
        return
                Calendar.getInstance().get(Calendar.YEAR) + "-" +
                (Calendar.getInstance().get(Calendar.MONTH) + 1) + "-" +
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + " " +
                Calendar.getInstance().get(Calendar.HOUR_OF_DAY) + ":" +
                Calendar.getInstance().get(Calendar.MINUTE);
    }
    
    public static String getCurrentDateTimeMilliseconds(){
        return
                Calendar.getInstance().get(Calendar.YEAR) + "-" +
                (Calendar.getInstance().get(Calendar.MONTH) + 1) + "-" +
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + " " +
                Calendar.getInstance().get(Calendar.HOUR_OF_DAY) + ":" +
                Calendar.getInstance().get(Calendar.MINUTE) + ":" +
                Calendar.getInstance().get(Calendar.SECOND) + "." +
                Calendar.getInstance().get(Calendar.MILLISECOND);
    }
    
    //    </editor-fold>

    //    <editor-fold defaultstate="collapsed" desc="main methods...">     
    public boolean isEmpty() {
        return lines.size() == 0;
    }

    public boolean exists() {
        if (file.exists() && file.isFile()) {
            return true;
        }
        return false;
    }

    public int countLines() {
        return lines.size();
    }

    public String getLine(int indexOfLine) {
        if (indexOfLine >= 0 && indexOfLine < lines.size()) {
            return lines.get(indexOfLine);
        }
        return null;
    }

    public int getIndexOfLine(String lineContent) {
        return lines.indexOf(lineContent);
    }

    public String getLinesAsString() {
        tempBuffered.delete(0, tempBuffered.length());
        for (count = 0; count < lines.size(); count++) {
            tempBuffered.append(lines.get(count));

            if (count + 1 < lines.size()) {
                tempBuffered.append("\n");
            }
        }
        return tempBuffered.toString();
    }

    public String getLineWithoutBlankSpaces(int indexOfLine) {
        if (indexOfLine >= 0 && indexOfLine < lines.size()) {
            return linesWhitoutBlankSpaces.get(indexOfLine);
        }
        return null;
    }

    public List<String> getLinesWhithoutBlankSpaces() {
        return linesWhitoutBlankSpaces;
    }

    public String getLinesWhithoutBlankSpacesAsString() {
        tempBuffered.delete(0, tempBuffered.length());
        for (count = 0; count < linesWhitoutBlankSpaces.size(); count++) {
            tempBuffered.append(linesWhitoutBlankSpaces.get(count));

            if (count + 1 < linesWhitoutBlankSpaces.size()) {
                tempBuffered.append("\n");
            }
        }
        return tempBuffered.toString();
    }

    public boolean open() {
        if (!isOpened()) {
            return openOperations();
        }

        return false;
    }

    public boolean save() {
        if (isOpened()) {
            try {
                bufferedWriter.append(getLinesAsString());
                dateTimeOfLastSave = getCurrentDateTime();
                return closeOperations();
            } catch (Exception e) {
            }
        }

        return false;
    }

    public boolean saveLinesWhithoutBlankSpaces() {
        if (isOpened()) {
            try {
                bufferedWriter.append(getLinesWhithoutBlankSpacesAsString());
                dateTimeOfLastSave = getCurrentDateTime();
                return closeOperations();
            } catch (Exception e) {
            }
        }

        return false;
    }

    public boolean addLine(String newLine) {
        if (opened) {
            tempValidation = lines.add(newLine);
            tempValidation &= linesWhitoutBlankSpaces.add(convertNormalLineToLineWithoutBlankSpaces(newLine));
            return tempValidation;
        }

        return false;
    }

    public boolean addLineBetween(int indexOfInsertionPoint, String newLine) {
        if (opened && indexOfInsertionPoint > 0 && indexOfInsertionPoint < (countLines() - 1)) {
            lines.add(indexOfInsertionPoint, newLine);
            linesWhitoutBlankSpaces.add(indexOfInsertionPoint, convertNormalLineToLineWithoutBlankSpaces(newLine));
            return true;
        }

        return false;
    }

    public boolean removeLine(int indexOfLine) {
        if (opened && indexOfLine > 0 && indexOfLine < (countLines() - 1)) {
            tempLine = lines.remove(indexOfLine);
            linesWhitoutBlankSpaces.remove(indexOfLine);
            return tempLine != null;
        }

        return false;
    }
    
    public boolean updateLine(int indexOfLine, String newLine){
        if (opened && indexOfLine > 0 && indexOfLine < (countLines() - 1)) {
            tempLine = null;
            tempLine = lines.set(indexOfLine, newLine);
            tempLine = linesWhitoutBlankSpaces.set(indexOfLine, convertNormalLineToLineWithoutBlankSpaces(newLine));
            return tempLine != null;
        }
        
        return false;
    }
    
    public boolean existsLine(String searchedLine){
        //found
        tempValidation = lines.contains(searchedLine);
        
        if (tempValidation) {
            return tempValidation;
        }
        
        return linesWhitoutBlankSpaces.contains(searchedLine);
    }
    //    </editor-fold>
    
    //</editor-fold>
    
}//class
