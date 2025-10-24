/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Degree;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.SeatAssignment;
import info5100.university.example.Persona.Person;
import info5100.university.example.Persona.StudentProfile;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class Degree {

    String title;
    ArrayList<Course> corelist;
    ArrayList<Course> electives;
   
    public Degree(String name ) {
        title = name;
        corelist = new ArrayList();
        electives = new ArrayList();
        
    }

    
    public Course addCoreCourse(Course c) {
        corelist.add(c);
        return c;
    }
    public Course addElectiveCourse(Course c) {
        electives.add(c);
        return c;

    }

    public boolean isStudentReadyToGraduate(StudentProfile sp) {
        ArrayList sas = sp.getCourseList(); 
        if (validateCoreClasses(sas) == false) {
            return false;
        } if(getcredishours(sp) <= 32){
            return false;
        }
            return true; 

    }

    public boolean validateCoreClasses(ArrayList<SeatAssignment> sas) {
        for (Course c : corelist) {
            if (!isCoreSatisfied(sas, c)) { 
                return false;
            }
        }
        return true; 

    }
    public int getcredishours(StudentProfile sp){
        int sum=0;
        for(CourseLoad courseLoad : sp.getTranscript().getCourseloadlist().values()){
        for(SeatAssignment sa : courseLoad.getSeatAssignments()){
           if(!sa.ispass()){
               sum = sum+ sa.getCreditHours();
           }
        }}
        return sum;
    }
    public boolean isCoreSatisfied(ArrayList<SeatAssignment> sas, Course course1) {
        for (SeatAssignment sa : sas) {
            if (sa.getAssociatedCourse().equals(course1)) {
                return true;
            }
        }
        return false;

    }

    public int getTotalElectiveCoursesTaken(ArrayList<SeatAssignment> sas) {
        int electivecount = 0;
        for (SeatAssignment sa : sas) {
            if (isElectiveSatisfied(sa)) {
                electivecount = electivecount + 1;
            }
        }
        return electivecount;

    }

    public boolean isElectiveSatisfied(SeatAssignment sa) {
        for (Course c : electives) {
            if (sa.getAssociatedCourse().equals(c)) {
                return true;
            }
        }
        return false;

    }

}
