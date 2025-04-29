
package EE333;

/**
 *
 * @author Zachary Zabriskie
 */
public class SettingsInfoManager {
    
    public static SettingInfo GetSettingInfo(String Filename){ // in p2 import users
        SettingInfo CurrentSettingInfo = null;
        java.io.File SettingFile = null;
        java.io.FileReader SettingFileReader = null;
        java.io.BufferedReader SettingBufferedReader = null;
        java.lang.String[] Chunks;
        java.lang.String Line = "";
        
        // Validation of Filename
        if (Filename == null || Filename.isEmpty()) {
            System.out.println("Error: Invalid Filename");
            // return ( results )
        }
        
        // Read File once it has been found
        // SettingFileReader = new java.io.FileReader(SettingFile);
        try {
            SettingFileReader = new java.io.FileReader(SettingFile);
            
//            for( int index = 0; index < User.size(); index++) {
//                System.out.println("reading..." + Users.get(index).Firstname);
            
            
        } catch (java.lang.Exception ex) {
            System.out.println(ex.toString());
        }
        
        SettingBufferedReader = new java.io.BufferedReader(SettingFileReader);
        
        try {
            if((Line = SettingBufferedReader.readLine()) != null ) {
                Chunks = Line.split(",");
                
                
                // Chunks.length looking for Filename, and Filetype...
                if (Chunks.length >= 2) {
                    String settingsFilename = Chunks[0];
                    String settingsFiletype = Chunks[1];
                    CurrentSettingInfo = new SettingInfo(settingsFilename, settingsFiletype);
                } else {
                    System.out.println("Error: There is not enough data in the file");
                }
            }
        } catch (java.lang.Exception ex) {
            SettingBufferedReader = new java.io.BufferedReader(SettingFileReader);
        }
        
        return(CurrentSettingInfo);
    }
    
    class SettingInfo {
    public String Filename;
    public String Filetype; // could be replaced as an enum.
    
    public SettingInfo( String Filename, String Filetype) {
        // validatation needs to happen
        
        this.Filename = Filename;
        this.Filetype = Filetype;
    }
    
    
}
    
}
