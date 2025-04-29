
package EE333;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author Zachary Zabriskie
 * 
 */
public class CourseInfoManager {
        public static java.util.ArrayList<EE333.CourseInfo> ImportCourses(String Filename, String Format){
        java.io.File InputFile; // = new File("Users.csv");
        java.io.FileReader InputFileReader;
        java.io.BufferedReader InputBufferedReader;
        String Line;
        String[] Chunks;
        
        java.util.ArrayList<EE333.CourseInfo> Courses = new ArrayList<>();
        EE333.CourseInfo Course;
        EE333.UserLevel UserLevel;
        
        try {
            InputFile = new File( Filename );
            InputFileReader = new FileReader(InputFile);
            InputBufferedReader = new BufferedReader(InputFileReader);
            
            // Put this in the controller...
            while((Line = InputBufferedReader.readLine()) != null) {
                Chunks = Line.split(",");
                if( Chunks.length != 4) {
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
                    
                    Course = new CourseInfo(Filename, Line, Line, Format, 0);
                    Courses.add(Course);
                }
            }
            
            InputBufferedReader.close();
            InputFileReader.close();
        } catch (java.io.IOException ex) {
            //this.jTextStatus.setText("Error: " + ex.toString() );
        }
        return(Courses);
    }
        
        
        public static boolean ExportCourses(CourseInfo Courses, java.lang.String Filename, java.lang.String Format){

        // File, Filewriter
        File OutputFile;
        FileWriter OutputFileWriter;
        
        // TODO: Validate "Filename" and "format"
        
        if (Format.equalsIgnoreCase("csv") == true) {
            try { 
                // NOTE: We need to verify that the User does not already exist...
                
                // NOTE: toCustom and XML need to be supported
                OutputFile = new File(Filename);
                OutputFileWriter = new FileWriter(OutputFile, true); // Append existing file
                
                OutputFileWriter.write(Courses.toCSV() + '\n' );
                
                OutputFileWriter.close();
            } catch (IOException ex) {
                // Log it... (LogManager file)
                // EE333.LogManager.LogException ( log the exception using the LogManager to a File )
            }
            
        } else if (Format.equalsIgnoreCase("xml") == true) {
            try {
                
                OutputFile = new File( Filename );
                OutputFileWriter = new FileWriter(OutputFile, true);
                
                OutputFileWriter.write(Courses.toXML() + '\n' );
                
                OutputFileWriter.close();
            } catch (IOException ex ) {
                // Log it...
                // EE333.LogManager.LogException
            }
            
        } else if (Format.equalsIgnoreCase("json") == true) {
            System.out.println("Not Yet Supported");
        } else {
            try{
                OutputFile = new File( Filename );
                OutputFileWriter = new FileWriter(OutputFile, true);
                
                OutputFileWriter.write(Courses.toString());
            } catch (IOException ex ) {
                    
            }

            

        }
        return( true );
    
}
        
        
}
