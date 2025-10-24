/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseSchedule;

import info5100.university.example.Persona.StudentProfile;

/**
 *
 * @author kal bugrara
 */
public class Seat {
    
    Boolean occupied; 
    int number;
    SeatAssignment seatassignment; //links back to studentprofile
    CourseOffer courseoffer;
    
    public Seat (CourseOffer co, int n){
        courseoffer = co;
        number = n;
        occupied = false;
        
    }
    
    public Boolean isOccupied(){
        return occupied;

    }

    public void setOccupied(Boolean occupied) {
        this.occupied = occupied;
    }

    public void setSeatassignment(SeatAssignment seatassignment) {
        this.seatassignment = seatassignment;
    }
    
    
    
    public SeatAssignment newSeatAssignment(CourseLoad cl){
        
        seatassignment = new SeatAssignment(cl, this); //links seatassignment to seat
        occupied = true;   
        return seatassignment;
    }
    
    public CourseOffer getCourseOffer(){
        return courseoffer;
    }
    
    public int getCourseCredits(){
        return courseoffer.getCreditHours();
    }
    
    public StudentProfile getStudentProfile() {
        if (seatassignment == null) return null;
        return seatassignment.getStudentProfile();
    }

    public SeatAssignment getSeatassignment() {
        return seatassignment;
    }

    
}
