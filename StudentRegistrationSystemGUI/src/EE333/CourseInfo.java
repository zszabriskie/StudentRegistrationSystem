
package EE333;

import java.util.Random;

/**
 *
 * @author cf_jo
 */

public class CourseInfo {
    private String CourseName;
    private String Professor;
    private String CRN;
    private String Description;
    private int Seats;

    public CourseInfo(String CourseName, String Professor, String CRN, String Description, int Seats) {
        this.CourseName = CourseName;
        this.Professor = Professor;
        this.CRN = CRN;
        this.Description = Description;
        this.Seats = Seats;
    }

    // Getters
    public String getCourseName() {
        return CourseName;
    }

    public String getProfessor() {
        return Professor;
    }

    public String getCRN() {
        return CRN;
    }

    public String getDescription() {
        return Description;
    }

    public int getSeats() {
        return Seats;
    }

    // Setters
    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }

    public void setProfessor(String Professor) {
        this.Professor = Professor;
    }

    public void setCRN(String CRN) {
        this.CRN = CRN;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setSeats(int Seats) {
        this.Seats = Seats;
    }

    @Override
    public String toString() {
        return "Course: " + CourseName + ", Professor: " + Professor + ", CRN: " + CRN + ", Seats: " + Seats;
    }
    
    public String toCSV() {
        return( CourseName + "," + Professor + "," + CRN + "," + Seats );
    }
    
    public String toXML() {
        return( "<Courses>" +
                "<CourseName>" + this.getCourseName() + "</CourseName>" +
                "<Professor> " + this.getProfessor() + "</Professor>" +
                "<CRN> " + this.getCRN() + "</CRN>" +
                "<Seats> " + this.getSeats() + "</Seats>" +
                "</Courses>"
        );
    }
    
    public String toJSON() {
    return "{\n" +
           " \"CourseName\": \"" + CourseName + "\",\n" +
           " \"Professor\": \"" + Professor + "\",\n" +
           " \"CRN\": \"" + CRN + "\",\n" +
            " \"Seats\": \"" + Seats + "\",\n" +
            "}";
    }
    
    public String toCustom(){
        return "CourseName: " + CourseName + "Professor: " + Professor + " CRN: " + CRN + "Seats: " + Seats;
    }
    
}

