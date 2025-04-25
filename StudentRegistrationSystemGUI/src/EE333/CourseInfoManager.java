
package EE333;

import java.io.IOException;

/**
 *
 * @author zacat
 */
public class CourseInfoManager {
        public static boolean ImportCourses( java.util.ArrayList<EE333.CourseInfo> Courses, String Filename, String Format){
        boolean results = true;
        
        //EE333.UserInfo User = null;
                
        java.io.File InputFile;
        java.io.FileReader InputFileReader;
        java.io.BufferedReader InputBufferedReader;
        String Line; // one line in the file
        String Chunks[]; // array of strings
        String Chunk; // single column or value on a line
        String CourseName;
        String Professor;
        String CRN;
        String Description;
        int Seats;

        
        if ( Courses == null ){
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
                        
                        while (( Line = InputBufferedReader.readLine()) != null ) {
                            Chunks = Line.split(",");
                            if ( Chunks.length == 5 ) {
                                
                                
                                CourseName = Chunks[0];
                                Professor = Chunks[1];
                                CRN = Chunks[2];
                                Description = Chunks[3];
                                try {
                                    Seats = java.lang.Integer.parseInt(Chunks[4]);
                                    
                                } catch (java.lang.NumberFormatException ex) {
                                    System.out.println( ex.toString() );
                                    // log the exception to a file
                                    Seats = 0;
                                }

                                
                                // Validate the fields that we have pulled out of the file..
                                
                                if ( CourseName.length() <= 0 ) {
                                    System.out.println("Error: Invalid CourseName!");
                                } else if (Professor.length() <= 0 ){
                                    System.out.println("Error: Invalid Professor");
                                } else if (CRN.length() <= 0) { // more validation here (@, and the .)
                                    System.out.println("Error: Invalid CRN");
                                } else if (Description.length() <= 0) {
                                    System.out.println("Error: Invalid Description");
                                } else if (Seats <= 0) {
                                    System.out.println("Error: Invalid Seat Number");
                                } else {
                                    // all the fields that survived validation...
                                    EE333.CourseInfo Course = new EE333.CourseInfo(CourseName, Professor, CRN, Description, Seats);
                                    
                                    // Add the user to the arraylist
                                    Courses.add(Course);
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
                System.out.println("XML FORMAT UNSUPPORTED");
                
                
                // add
                
            } else if ( Format.equalsIgnoreCase("JSON") == true ) {
                System.out.println("JSON FORMAT UNSUPPORTED");
            } else {
                // Assume custom format
                System.out.println("CUSTOM FORMAT UNSUPPORTED");
            }
        }
        
        return( results );
        
    }
        
        public static boolean ExportCourses(java.util.ArrayList<EE333.CourseInfo> Courses, java.lang.String Filename, java.lang.String Format) throws IOException {
        boolean results = true;
        
        //java.io.File OutputFile = null;
        //java.io.FileWriter OutputFileWriter = null;
        //java.io.BufferedWriter OutputBufferedWriter;
        
        //Format possibilities: CSV, Custom, XML, JSON
        
        // Validating input arguments
        if ((Courses == null) || (Courses.size() == 0 )) {
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
                    
                    for ( EE333.CourseInfo Course : Courses) { // for each loop
                        if (Format.equalsIgnoreCase("CSV")) {
                            OutputBufferedWriter.write(Course.toCSV() + '\n');
                        } else if (Format.equalsIgnoreCase("XML")) {
                            OutputBufferedWriter.write(Course.toXML() + '\n');
                        } else {
                            OutputBufferedWriter.write(Course.toString() + '\n');
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
                
                for ( EE333.CourseInfo Course : Courses) {
                    if (Format.equalsIgnoreCase("XML")) {
                        OutputBufferedWriter.write(Course.toXML() + '\n');
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
