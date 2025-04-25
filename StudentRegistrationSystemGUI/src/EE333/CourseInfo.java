/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
        return(CourseName + "," + Professor + "," + CRN + "," + Description + "," + Seats);
    }
    
    public String toXML() {
        return "<Course>\n" + 
                "<CourseName>" + CourseName + "</CourseName>\n" +
                "<Professor>" + Professor + "</Professor>\n" +
                "<CRN>" + CRN + "</CRN>\n" +
                "<Description>" + Description + "</Description>\n" +
                "<Seats>" + Seats + "</Seats>\n" +
                "</Course>";
                
    }
}

