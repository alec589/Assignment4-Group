/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseSchedule;

import info5100.university.example.Persona.StudentProfile;
import info5100.university.example.Persona.Transcript;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author kal bugrara
 */
public class CourseLoad {
    String semester;
    ArrayList<SeatAssignment> seatassignments;
    Transcript transcript; 
    
    public CourseLoad(String s){
        seatassignments = new ArrayList();
        semester = s;
    }
    
    public SeatAssignment newSeatAssignment(CourseOffer co,StudentProfile sp){
        
        Seat seat = co.getEmptySeat(); // seat linked to courseoffer
        if (seat==null) return null;
        SeatAssignment sa = seat.newSeatAssignment(this);
        seatassignments.add(sa);  //add to students course 
        return sa;
    }
    
    public void registerStudent(SeatAssignment sa){
        
        
        sa.assignSeatToStudent(this);
        seatassignments.add(sa);
    }
    
    public float getsemestercreditshours(){ //total score for a full semeter
        float creditshours = 0;
        for (SeatAssignment sa: seatassignments){
            creditshours = creditshours + sa.getCreditHours();
        }
        return creditshours;
    }
    
    public double getqualitypoints(){
        double sum = 0;
        for (SeatAssignment sa: seatassignments){
            sum = sum + sa.convertToGPA(sa.calculateFinalCourseScore())*sa.getCreditHours();
            
        }
        return sum;
    }
    
    public String convertToLetter(double score) {
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
    public double gettotalhours(){
         double creditshours = 0;
        for (SeatAssignment sa: seatassignments){
           
            creditshours = creditshours +sa.getCreditHours();
        }
        return creditshours;        
    }
    public ArrayList<SeatAssignment> getSeatAssignments(){
        return seatassignments;
    }
    
    public  boolean dropCourse(SeatAssignment sa) {
        if (seatassignments.contains(sa)) {
            seatassignments.remove(sa);
            Seat seat = sa.getSeat();
            seat.occupied=false;
            return true;  
        }
        JOptionPane.showMessageDialog(null, "Student is not registered for this seat assignment.", "warning",JOptionPane.WARNING_MESSAGE);
           return false;
        }
    
    public SeatAssignment getAssignmentByCourseOffer(CourseOffer co) {
        if (co == null) return null;
            for (SeatAssignment sa : seatassignments) {
                if (sa.getSeat() == null) {
                    continue; 
                }
                CourseOffer registeredCO = sa.getSeat().getCourseOffer();
                if (registeredCO == null) {
                    continue; 
                }
                if (registeredCO.equals(co)) {
                    return sa;
                }
            }
            return null; 
    }

    public Transcript getTranscript() {
        return transcript;
    }

    public void setTranscript(Transcript transcript) {
        this.transcript = transcript;
    }
    public SeatAssignment findSeatAssignmentByCourseName(String courseName) {
    for (SeatAssignment sa : this.seatassignments) {
        if (sa.getAssociatedCourse().getName().equals(courseName)) {
            return sa;
        }
    }
    return null;
}
    

}
