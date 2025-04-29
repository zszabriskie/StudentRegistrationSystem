package EE333;

// author: cf_jo

import java.util.ArrayList;
import java.util.Random;

public class StudentInfo {
    private String FirstName;
    private String LastName;
    private String Email;
    private String ID;
    private UserLevel Level;

    private ArrayList<CourseInfo> registeredCourses = new ArrayList<>();

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

    public UserLevel getLevel() {
        return Level;
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

    // Add a course to the student's registered list
    public void registerCourse(CourseInfo course) {
        if (!registeredCourses.contains(course)) {
            registeredCourses.add(course);
        }
    }

    // Retrieve all registered courses
    public ArrayList<CourseInfo> getRegisteredCourses() {
        return registeredCourses;
    }

    public String toStringStudent() {
        return "Name: " + FirstName + " " + LastName + " ID: " + ID + " Email: " + Email;
    }

    public String toStringFullname() {
        return FirstName + " " + LastName;
    }
}




