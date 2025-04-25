
package EE333;

import java.io.IOException;
import EE333.UserInfo;
/**
 *
 * @author Zachary Zabriskie
 * DESC: 
 * VERS: 1.0
 */
public class StudentInfoManager {
    
        public static boolean ImportStudents( java.util.ArrayList<EE333.StudentInfo> Students, String Filename, String Format){
        boolean results = true;
        
        //EE333.UserInfo User = null;
                
        java.io.File InputFile;
        java.io.FileReader InputFileReader;
        java.io.BufferedReader InputBufferedReader;
        String Line; // one line in the file
        String Chunks[]; // array of strings
        String Chunk; // single column or value on a line
        String ID;
        String FirstName;
        String LastName;
        String Email;
        
        
        
        if ( Students == null ){
            System.out.println("Error: Please provide a valid ArrayList!");
            results = false;
        }else if ((Filename == null) && ( Filename.length() < 5) && (Filename.contains(".") == false)) {
            System.out.println("Error: Invalid Filename");
            results = false;
        } else if (Format == null) {
            System.out.println("Error: No Format provided!");
            results = false;
        } else {
            if ( Format.equalsIgnoreCase("CSV") == true ) {
                InputFile = new java.io.File( Filename );
                if (InputFile.exists() == true ){
                    // do something
                    try {
                        InputFileReader = new java.io.FileReader( InputFile );
                        InputBufferedReader = new java.io.BufferedReader( InputFileReader );
                        // Note: for class 8 --> 4 (Users.csv should include 8 columns instead of 4)
                        while (( Line = InputBufferedReader.readLine()) != null ) {
                            Chunks = Line.split(",");
                            if ( Chunks.length == 8 ) { // for the project we are going to need 8 values here...
                                
                                // Create new user with the chunks
                                // add the new user to Users ArrayList
                                
                                // we have enough columns
                                // Chunks[ 0 ]; ID
                                // Chunks[ 1 ]; FullName
                                // Chunks[ 2 ]; Email
                                
                                ID = Chunks[0];
                                FirstName = Chunks[1];
                                LastName = Chunks[2];
                                //Balance = Chunks[3];
                                Email = Chunks[3];
                                UserLevel = Chunks[4];

                                

                                
                                // Validate the fields that we have pulled out of the file..
                                
                                if ( ID.length() <= 0 ) {
                                    System.out.println("Error: Invalid ID!");
                                } else if (FirstName.length() <= 0 ){
                                    System.out.println("Error: Invalid FullName");
                                } else if (LastName.length() <= 0) { // more validation here (@, and the .)
                                    System.out.println("Error: Invalid Email!");
                                } else if (Email.length() <= 0) {
                                    System.out.println("Error: Invalid Email!");
                                } else {
                                    // all the fields that survived validation...
                                    EE333.StudentInfo Student = new EE333.StudentInfo(FirstName, LastName, Email, UserLevel.Other);
                                    
                                    // Add the Student to the arraylist
                                    Students.add(Student);
                                } 
                            } else {
                                // we have too few or too many...
                                System.out.println("Warning: Line does not contain enough columns!");
                            }
                        }
                        
                        InputBufferedReader.close();
                        InputFileReader.close();
                        
                    } catch (java.io.IOException ex) {
                        System.out.println( ex.toString() );
                        results = false;
                    }
                } else {
                    System.out.println("Error: " + Filename + "Does not exist: ");
                    results = false;
                }
            } else if ( Format.equalsIgnoreCase("XML") == true ) {
                // ADD XML
                
                System.out.println("XML FORMAT UNSUPPORTED");
                
                
                
            } else if ( Format.equalsIgnoreCase("JSON") == true ) {
                System.out.println("JSON FORMAT UNSUPPORTED");
            } else {
                // Assume custom format
                System.out.println("CUSTOM FORMAT UNSUPPORTED");
            }
        }
        
        return( results );
        
    }
    
        
    public static boolean ExportStudents(java.util.ArrayList<EE333.StudentInfo> Students, java.lang.String Filename, java.lang.String Format) throws IOException {
        boolean results = true;
        
        //java.io.File OutputFile = null;
        //java.io.FileWriter OutputFileWriter = null;
        //java.io.BufferedWriter OutputBufferedWriter;
        
        //Format possibilities: CSV, Custom, XML, JSON
        
        // Validating input arguments
        if ((Students == null) || (Students.isEmpty() )) {
            System.out.println("Error: No users provided!"); //overwriten users
            results = false;
            
        }else if ((Filename == null) && (Filename.length() < 5) && ( Filename.contains(".") == false)) {
            System.out.println("Error: Invalid Filename");
            results = false;
        } else if (Format == null) {
            System.out.println("Error: No Format provided!");
        } else if (Format.equalsIgnoreCase("CSV") == true) { // done enough validation on the input arguments, structure the code to leverage arguments to structure format
                // For Project
                // OutputFileWriter = new java.io.FileWriter( Filename ); // add the try, catch block
                // if the file exists, do you overwrite it? do you rename it? 
                //if ( OutputFile.exists() == true) {
                    // rename the file --> use a date/time stamp 
                //}
                try {
                    java.io.File OutputFile = new java.io.File( Filename );
                    java.io.FileWriter OutputFileWriter = new java.io.FileWriter(OutputFile);
                    java.io.BufferedWriter OutputBufferedWriter = new java.io.BufferedWriter(OutputFileWriter);
                // loop through users array list using toCSV
                    
                    for ( EE333.StudentInfo Student : Students) { // for each loop
                        if (Format.equalsIgnoreCase("CSV")) {
                            OutputBufferedWriter.write(Student.toCSV() + '\n');
                        } else if (Format.equalsIgnoreCase("XML")) {
                            OutputBufferedWriter.write(Student.toXML() + '\n');
                        } else {
                            OutputBufferedWriter.write(Student.toString() + '\n');
                        }
                    }
                    
                    OutputBufferedWriter.close();
                    OutputFileWriter.close();
                } catch( java.io.IOException ex ){
                    System.out.println("Error: failed to export user with CSV");
                    results = false;
                }
                return (results);
                
        } else if ( Format.equalsIgnoreCase("XML") == true ){
            
                
            try {
                java.io.File OutputFile = new java.io.File( Filename );
                java.io.FileWriter OutputFileWriter = new java.io.FileWriter(OutputFile);
                java.io.BufferedWriter OutputBufferedWriter = new java.io.BufferedWriter(OutputFileWriter);
                
                for ( EE333.StudentInfo Student : Students) {
                    if (Format.equalsIgnoreCase("XML")) {
                        OutputBufferedWriter.write(Student.toXML() + '\n');
                }
                OutputBufferedWriter.close();
                OutputFileWriter.close();
                }
            } catch (java.io.IOException ex ) {
                System.out.println("Error: failed to export user with XML");
                results = false;
            }
        }
        return (results);
    }        
        
        
        
}
