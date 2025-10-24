/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package info5100.university.example.Persona.Faculty;



/**
 *
 * @author sunzuolin
 */
public class Assignment {
    private String assignmentName;
    private int maxPoints;
    private double weight;
    private FacultyProfile facultyProfile;
    private String Description;
    
    public Assignment(String name, FacultyProfile fp, int maxPoints) {
        this.assignmentName = name;
        this.facultyProfile =fp;
        this.maxPoints = maxPoints;
        
    }
    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public FacultyProfile getFacultyProfile() {
        return facultyProfile;
    }

    
    public String getAssignmentName() {
        return assignmentName;
    }

    public int getMaxPoints() {
        return maxPoints;
    }
    public String toString() {

        return assignmentName;
    }
}
