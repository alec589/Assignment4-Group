/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseSchedule;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.Persona.Faculty.Assignment;
import info5100.university.example.Persona.Faculty.StudentAssignment;
import info5100.university.example.Persona.StudentProfile;
import java.util.HashMap;

/**
 *
 * @author kal bugrara
 */
public class SeatAssignment {
    double grade; //(Letter grade mappings: A=4.0, A-=3.7, B+=3.3, B=3.0, )        //Lu: this "grade" is actually "gpa"
    Seat seat;
    boolean like; //true means like and false means not like
    CourseLoad courseload;
    Boolean pass;
    private HashMap<String, StudentAssignment> assignmentRecords;
    double score; //Lu: max point is 100 or can be converted to
    String letterGrade;
    String Status;
    
    public SeatAssignment(CourseLoad cl, Seat s){
        seat = s;
        courseload = cl;
        pass= false;
        this.assignmentRecords = new HashMap<>();
        Status = "unpaid";
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    public Boolean ispass(){
        return pass;

    }
    
    public boolean getLike(){
        return like;
    }
    
    public void assignSeatToStudent(CourseLoad cl){
        courseload = cl;
    }
    
    public int getCreditHours(){
        return seat.getCourseCredits();
       
    }
    
    public Seat getSeat(){
        return seat;
    }
    
    public CourseOffer getCourseOffer(){
        
        return seat.getCourseOffer();
    }
    
    public Course getAssociatedCourse(){
        
        return getCourseOffer().getSubjectCourse();
    }
    
    public double GetCourseStudentScore(){
        return getCreditHours()*score;
    }
    
    public StudentProfile getStudentProfile() {
        if (courseload == null) return null;
        return courseload.getTranscript().getStudentProfile();
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }


    public double getScore() {
        return score;
    }
    
    public double setScore(double score) {
        this.score = score;
        this.letterGrade = convertToLetter(score);
        this.grade = convertToGPA(score);
        this.pass = score >= 60;
        return score;
    }

    public static String convertToLetter(double score) {               // Lu: make sure it is static
        if (score >= 93) return "A";
        else if (score >= 90) return "A-";
        else if (score >= 87) return "B+";
        else if (score >= 83) return "B";
        else if (score >= 80) return "B-";
        else if (score >= 77) return "C+";
        else if (score >= 73) return "C";
        else if (score >= 70) return "C-";
        else if (score >= 67) return "D+";
        else if (score >= 63) return "D";
        else if (score >= 60) return "D-";
        else return "F";
    }
    
    public static double convertToGPA(double score) {
        if (score >= 93) return 4.0;
        else if (score >= 90) return 3.7;
        else if (score >= 87) return 3.3;
        else if (score >= 83) return 3.0;
        else if (score >= 80) return 2.7;
        else if (score >= 77) return 2.3;
        else if (score >= 73) return 2.0;
        else if (score >= 70) return 1.7;
        else if (score >= 67) return 1.3;
        else if (score >= 63) return 1.0;
        else if (score >= 60) return 0.7;
        else return 0.0;                                // Lu: if fail, GPA=0.0
    }
    
    public StudentAssignment getStudentAssignmentRecord(String assignmentName) {
        return this.assignmentRecords.get(assignmentName);
    }
    
    public HashMap<String, StudentAssignment> getAssignmentRecords() {
        return assignmentRecords;
    }
    
    public Double calculateFinalCourseScore() {
        double total = 0.0;
        double usedWeight = 0.0;

        for (StudentAssignment sa : assignmentRecords.values()) {
            Double score = sa.getScore();
            if (score == null) continue;
            Assignment a = sa.getAssignment();
            double weight = a.getWeight();
            double pct = score / a.getMaxPoints();
            total += pct * weight;
            usedWeight += weight;
        }
        if (usedWeight == 0) return null;
        if(total / usedWeight * 100.0>=60){
           pass=true;
        }
        return total / usedWeight * 100.0;
    }  

    public CourseLoad getCourseload() {
        return courseload;
    }

    public void setCourseload(CourseLoad courseload) {
        this.courseload = courseload;
    }
    @Override
    public String toString (){
        return Status;
    }
    
    
}
