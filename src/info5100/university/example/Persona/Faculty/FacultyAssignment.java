/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona.Faculty;

import info5100.university.example.CourseSchedule.CourseOffer;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class FacultyAssignment {
    double tracerating;
    CourseOffer courseoffer;
    FacultyProfile facultyprofile;
    private ArrayList<Assignment> assignments;
    public FacultyAssignment(FacultyProfile fp, CourseOffer co){
        courseoffer = co;
        facultyprofile = fp;
        assignments = new ArrayList<>();
    }

       public double getRating(){
        
        return tracerating;
    }
       public void seProfRating(double r){
           
           tracerating = r;
       }
    public FacultyProfile getFacultyProfile(){
        return facultyprofile;
    }
    public void assignAssignment(Assignment assignment) {
        assignments.add(assignment);}

    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }
        
    
  
}
