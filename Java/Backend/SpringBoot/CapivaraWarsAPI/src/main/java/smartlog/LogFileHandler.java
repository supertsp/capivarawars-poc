package smartlog;

// <editor-fold defaultstate="collapsed" desc="imports...">
import java.util.List;
import java.util.ArrayList;
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 * 
 * Description: ...
 * 
 * @version 1.0.0
 * @author ${user}, ${date}, ${time}
 */// </editor-fold>
public class LogFileHandler {
    
    //<editor-fold defaultstate="collapsed" desc="attributes...">
    
    //    <editor-fold defaultstate="collapsed" desc="main attributes...">
    private String url;
    private String folderName;
    private String fileName;
    private String fileExtension;    
    //    </editor-fold>
    
    //    <editor-fold defaultstate="collapsed" desc="constants attributes...">
    
    //    </editor-fold>
    
    //    <editor-fold defaultstate="collapsed" desc="static attributes...">
    
    //    </editor-fold>
    
    //    <editor-fold defaultstate="collapsed" desc="auxiliary attributes...">
    private FileHandler file;
    private StringBuffer tempStringBuffered = new StringBuffer();
    private boolean headerExists;
    //    </editor-fold>
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constructors...">
    public LogFileHandler(String url, String folderName, String fileName, String fileExtension) {
        this.url = url;
        this.folderName = folderName;
        this.fileName = fileName;
        this.fileExtension = fileExtension;
        
        FolderHandler.createFolderWithSubfolders(url, folderName);
        file = new FileHandler(true, url + "/" + folderName, fileName, fileExtension);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="methods...">
    
    //    <editor-fold defaultstate="collapsed" desc="getter and setter methods...">
    public String getUrl() {
        return url;
    }

    public String getFolderName() {
        return folderName;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileExtension() {
        return fileExtension;
    }
    //    </editor-fold>
    
    //    <editor-fold defaultstate="collapsed" desc="override methods...">
    
    //    </editor-fold>    
    
    //    <editor-fold defaultstate="collapsed" desc="auxiliary methods...">
    
    //    </editor-fold>
    
    //    <editor-fold defaultstate="collapsed" desc="static methods...">
    
    //    </editor-fold>
    
    //    <editor-fold defaultstate="collapsed" desc="main methods...">
    public void addHeader(String... newTextItem){
        //open file
        file.open();
        
        tempStringBuffered.delete(0, tempStringBuffered.length());        
        
        for (int count = 0; count < newTextItem.length; count++) {
            tempStringBuffered.append(newTextItem[count]);
            
            if (count + 1 < newTextItem.length) {
                tempStringBuffered.append(";");
            }
        }
        
        if (!file.existsLine(tempStringBuffered.toString())) {            
            file.addLine(tempStringBuffered.toString());            
        }
        
        //close and save
        file.save();
    }
    
    public void addLine(String... newTextItem){
        file.open();
        
        tempStringBuffered.delete(0, tempStringBuffered.length());
        
        for (int count = 0; count < newTextItem.length; count++) {
            tempStringBuffered.append(newTextItem[count]);
            
            if (count + 1 < newTextItem.length) {
                tempStringBuffered.append(";");
            }
        }
        
        file.addLine(tempStringBuffered.toString());
        file.save();
    }
    
    public void addLineWithDateTime(String... newTextItem){
        file.open();
        
        tempStringBuffered.delete(0, tempStringBuffered.length());
        tempStringBuffered.append(FileHandler.getCurrentDateTime());
        tempStringBuffered.append(";");
        
        for (int count = 0; count < newTextItem.length; count++) {
            tempStringBuffered.append(newTextItem[count]);
            
            if (count + 1 < newTextItem.length) {
                tempStringBuffered.append(";");
            }
        }
        
        file.addLine(tempStringBuffered.toString());
        file.save();
    }
    
    public void addLineWithDateTimeMilliseconds(String... newTextItem){
        file.open();
        
        tempStringBuffered.delete(0, tempStringBuffered.length());
        tempStringBuffered.append(FileHandler.getCurrentDateTimeMilliseconds());
        tempStringBuffered.append(";");
        
        for (int count = 0; count < newTextItem.length; count++) {
            tempStringBuffered.append(newTextItem[count]);
            
            if (count + 1 < newTextItem.length) {
                tempStringBuffered.append(";");
            }
        }
        
        file.addLine(tempStringBuffered.toString());
        file.save();
    }
    
    public String getLine(int indexOfLine){
        return file.getLine(indexOfLine);
    }
    
    public String getAllLines(){
        return file.getLinesAsString();
    }
    
    public void removeLine(int indexOfLine){
        file.removeLine(indexOfLine);
    }
    
    public void updateLine(int indexOfLine, String... newTextItem){
        file.open();
        
        tempStringBuffered.delete(0, tempStringBuffered.length());
        tempStringBuffered.append(FileHandler.getCurrentDateTime());
        tempStringBuffered.append(";");
        
        for (int count = 0; count < newTextItem.length; count++) {
            tempStringBuffered.append(newTextItem[count]);
            
            if (count + 1 < newTextItem.length) {
                tempStringBuffered.append(";");
            }
        }
        
        file.updateLine(indexOfLine, tempStringBuffered.toString());
        file.save();   
    }
    //    </editor-fold>
    
    //</editor-fold>
    
}//class

