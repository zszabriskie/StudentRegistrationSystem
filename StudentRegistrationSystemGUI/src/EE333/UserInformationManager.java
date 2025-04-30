package EE333;

import EE333.UserInfo;
import EE333.StudentInfo;
import EE333.CourseInfo;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JDialog;

/**
 *
 * @author Zachary Zabriskie
 * DESC:
 * 
 */

public class UserInformationManager {
    
    public static boolean ExportUserInfo(EE333.StudentInfo UserToBeExported, String Filename, String format) {
        // File, Filewriter
        if (Filename == null || Filename.isEmpty()) {
            System.out.println("Error: Invalid filename.");
            return (false);
        }
        
        if (format == null || format.isEmpty()) {
            System.out.println("Error: Invalid format.");
            return (false);
        }
        
        
        File OutputFile;
        FileWriter OutputFileWriter;
        
        if (format.equalsIgnoreCase("csv") == true) {
            try { 
                // NOTE: We need to verify that the User does not already exist...
                
                // NOTE: toCustom and XML need to be supported
                OutputFile = new File(Filename);
                OutputFileWriter = new FileWriter(OutputFile, true);
                OutputFileWriter.write(UserToBeExported.toCSV() + '\n');
                OutputFileWriter.close();
            } catch ( IOException ex ) {
                System.out.println("Error writing CSV: " + ex.getMessage());
                // Log it... (LogManager file)
                // EE333.LogManager.LogException ( log the exception using the LogManager to a File )
                return false;
            }
            
        } else if (format.equalsIgnoreCase("xml") == true) {
            try {
                
                OutputFile = new File( Filename );
                OutputFileWriter = new FileWriter(OutputFile, true);
                OutputFileWriter.write(UserToBeExported.toXML() + '\n' );
                OutputFileWriter.close();
                
            } catch (IOException ex ) {
                System.out.println("Error writing XML: " + ex.getMessage());
                // Log it...
                // EE333.LogManager.LogException
                return false;
            }
            
        } else if ( format.equalsIgnoreCase("json") == true) {
            try{
                OutputFile = new File( Filename );
                OutputFileWriter = new FileWriter(OutputFile, true);
                OutputFileWriter.write(UserToBeExported.toJSON() + '\n' );
                OutputFileWriter.close();
            } catch (IOException ex) {
                System.out.println("Error writing JSON:" + ex.getMessage());
                return false;
            }
        } else if (format.equalsIgnoreCase("Custom")) {
            try {
                OutputFile = new File( Filename );
                OutputFileWriter = new FileWriter(OutputFile, true);
                OutputFileWriter.write(UserToBeExported.toCustom() + '\n' );
                OutputFileWriter.close();
            } catch (IOException ex) {
                System.out.println("Error writing Custom format; " + ex.getMessage());
                
                return false;
            }
            //toCustom()
            

        } else {
            System.out.println("Error: Unsupported format");
            return false;
        }
        
        
        return true;
        
    }
    
        public static boolean ExportCourseInfo(EE333.CourseInfo CourseToBeExported, String Filename, String format) {
        // File, Filewriter
        if (Filename == null || Filename.isEmpty()) {
            System.out.println("Error: Invalid filename.");
            return false;
        }
        
        if (format == null || format.isEmpty()) {
            System.out.println("Error: Invalid format.");
            return false;
        }
        
        
        File OutputFile;
        FileWriter OutputFileWriter;
        
        if (format.equalsIgnoreCase("csv") == true) {
            try { 
                // NOTE: We need to verify that the User does not already exist...
                
                // NOTE: toCustom and XML need to be supported
                OutputFile = new File(Filename);
                OutputFileWriter = new FileWriter(OutputFile, true);
                OutputFileWriter.write(CourseToBeExported.toCSV() + '\n');
                OutputFileWriter.close();
            } catch ( IOException ex ) {
                System.out.println("Error writing CSV: " + ex.getMessage());
                // Log it... (LogManager file)
                // EE333.LogManager.LogException ( log the exception using the LogManager to a File )
                return false;
            }
            
        } else if (format.equalsIgnoreCase("xml") == true) {
            try {
                
                OutputFile = new File( Filename );
                OutputFileWriter = new FileWriter(OutputFile, true);
                OutputFileWriter.write(CourseToBeExported.toXML() + '\n' );
                OutputFileWriter.close();
                
            } catch (IOException ex ) {
                System.out.println("Error writing XML: " + ex.getMessage());
                // Log it...
                // EE333.LogManager.LogException
                return false;
            }
            
        } else if ( format.equalsIgnoreCase("json") == true) {
            try{
                OutputFile = new File( Filename );
                OutputFileWriter = new FileWriter(OutputFile, true);
                OutputFileWriter.write(CourseToBeExported.toXML() + '\n' );
                OutputFileWriter.close();
            } catch (IOException ex) {
                System.out.println("Error writing JSON:" + ex.getMessage());
                return false;
            }
        } else if (format.equalsIgnoreCase("Custom")) {
            try {
                OutputFile = new File( Filename );
                OutputFileWriter = new FileWriter(OutputFile, true);
                OutputFileWriter.write(CourseToBeExported.toString() + '\n' );
                OutputFileWriter.close();
            } catch (IOException ex) {
                System.out.println("Error writing Custom format; " + ex.getMessage());
                
                return false;
            }
            //toCustom()
            

        } else {
            System.out.println("Error: Unsupported format");
            return false;
        }
        
        
        return true;
        
    }
    
    public static java.util.ArrayList<EE333.UserInfo> ImportUserInfo( String Filename, String Format) {
        java.io.File InputFile; // = new File("Users.csv");
        java.io.FileReader InputFileReader;
        java.io.BufferedReader InputBufferedReader;
        String Line;
        String[] Chunks;
        
        java.util.ArrayList<EE333.UserInfo> Users = new ArrayList<>();
        EE333.UserInfo User;
        EE333.UserLevel UserLevel;
        boolean UserContact;
        
        try {
            InputFile = new File( Filename );
            InputFileReader = new FileReader(InputFile);
            InputBufferedReader = new BufferedReader(InputFileReader);
            
            // Put this in the controller...
            while((Line = InputBufferedReader.readLine()) != null) {
                Chunks = Line.split(",");
                if( Chunks.length != 6) {
                    // Log it
                    
                } else {
                    if (Chunks[4].equalsIgnoreCase("Undergraduate")) {
                        UserLevel = EE333.UserLevel.Undergraduate;
                    } else if (Chunks[4].equalsIgnoreCase("Graduate")) {
                        UserLevel = EE333.UserLevel.Graduate;
                    } else if (Chunks[4].equalsIgnoreCase("Instructor")){
                        UserLevel = EE333.UserLevel.Instructor;
                    } else if (Chunks[4].equalsIgnoreCase("Other")){
                        UserLevel = EE333.UserLevel.Other;
                    } else {
                        UserLevel = EE333.UserLevel.Other;
                    }
                    
                    if (Chunks[5].equalsIgnoreCase("true")){
                        UserContact = true;
                    } else {
                        UserContact = false;
                    }
                    
                    User = new UserInfo( Chunks[ 0 ], Chunks[ 1 ],Chunks[ 2 ], Chunks[ 3 ], UserLevel.Other, false);
                    Users.add(User);
                }
            }
            
            InputBufferedReader.close();
            InputFileReader.close();
        } catch (java.io.IOException ex) {
            //this.jTextStatus.setText("Error: " + ex.toString() );
        }
        return( Users );
    }
}
