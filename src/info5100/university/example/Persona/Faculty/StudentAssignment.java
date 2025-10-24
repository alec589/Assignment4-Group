/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package info5100.university.example.Persona.Faculty;

import info5100.university.example.Persona.StudentProfile;
import javax.swing.ImageIcon;

/**
 *
 * @author luwang
 */
public class StudentAssignment {
    private String submissionContent;
    private Boolean completed;     
    private double score;
    private ImageIcon logoImage;
    private Assignment assignment;
    
    public StudentAssignment(Assignment assignment){
        this.completed = false;
        this.score = 0;
        this.assignment = assignment;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public ImageIcon getLogoImage() {
        return logoImage;
    }

    public void setLogoImage(ImageIcon logoImage) {
        this.logoImage = logoImage;
    }

    public String getSubmissionContent() {
        return submissionContent;
    }

    public void setSubmissionContent(String submissionContent) {
        this.submissionContent = submissionContent;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
    
    public void clearScore() { 
        score = Double.NaN; 
    }
    
}