package EE333;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cf_jo
 */

import java.util.Random;

public class StudentInfo {
    private String FirstName;
    private String LastName;
    private String Email;
    private String ID;
    private UserLevel Level;

    // Constructor
    public StudentInfo(String FirstName, String LastName, String Email, UserLevel Level) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Email = Email;
        this.ID = generateID();  
        this.Level = Level;
    }

    // Method to generate a random ID
    private String generateID() {
        Random random = new Random();
        String ID = "B0";
        for (int i = 0; i < 7; i++) {
            ID += random.nextInt(10); 
        }
        return ID;
    }

    // Getters
    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getEmail() {
        return Email;
    }

    public String getID() {
        return ID;
    }

    // Setters
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setLevel(UserLevel Level) {
        this.Level = Level;
    }

    public String toStringStudent() {
        return "Name: " + FirstName + " " + LastName + " ID: " + ID + " Email: " + Email;
    }

    public String toStringFullname() {
        return FirstName + " " + LastName;
    }
    
    public String toCSV() {
        return(FirstName + "," + LastName + "," + Email + "," + Level);
    }
    
    public String toXML() {
        return "<Student>\n" + 
                "<FirstName>" + FirstName + "</FirstName>\n" +
                "<LastName>" + LastName + "</LastName>\n" +
                "<Email>" + Email + "</Email>\n" +
                "<Level>" + Level + "</Level>\n" +
                "</Student>";
                
    }
    
}



