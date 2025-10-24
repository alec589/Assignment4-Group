/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseSchedule;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.Persona.Faculty.FacultyAssignment;
import info5100.university.example.Persona.Faculty.FacultyProfile;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class CourseOffer {
    Course course;
    ArrayList<Seat> seatlist;
    FacultyAssignment facultyassignment;
    int buildingNumber;
    int floorNumber;
    int classroomNumber;
    String classroom;
    String dayOfWeek;       
    int startTime;          
    int endTime;  
    String timeSchedule;
    boolean enrollmentStatus;
    double tuitionFee;
    
    public CourseOffer(Course c) {
        course = c;
        seatlist = new ArrayList();
        
    }
    
    public void setLocation(int buildingNumber, int floorNumber, int classroomNumber) {
        this.buildingNumber = buildingNumber;
        this.floorNumber = floorNumber;
        this.classroomNumber = classroomNumber;
        this.classroom=buildingNumber + "-" + floorNumber + "-" + classroomNumber;
    }

    public String getClassroom() {
       if (this.classroom == null || this.classroom.isEmpty()) {
        return "Unassigned";
    }
    return this.classroom; 
       
    }
    public void setTimeSchedule(String dayOfWeek, int startTime, int endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
        this.timeSchedule= dayOfWeek + " " + startTime + "-" + endTime;
    }

    public double getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(double tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    public String getTimeSchedule() {
        if (this.timeSchedule == null || this.timeSchedule.isEmpty()) {
        return "Unassigned";
    }
    
        return timeSchedule;
    }
    
    public void AssignAsTeacher(FacultyProfile fp) {

        facultyassignment = new FacultyAssignment(fp, this);
    }

    public FacultyProfile getFacultyProfile() {
        return facultyassignment.getFacultyProfile();
    }

    public int getCourseNumber() {
        return course.getCourseNumber();
    }

    public String getCourseName() {
        return course.getName();
    }
    
    public void generatSeats(int n) {

        for (int i = 0; i < n; i++) {
            seatlist.add(new Seat(this, i));
        }
    }

    public Seat getEmptySeat() {
        for (Seat s : seatlist) {
            if (!s.isOccupied()) {
                return s;
            }
        }
        return null;
    }
    public int getOcupiedSeatNumber() {
        int occupiedCount = 0;
        for (Seat seat : seatlist) {
            if (seat.isOccupied()) {
                occupiedCount++;
            }
        }
        return occupiedCount;
    }

    public SeatAssignment assignEmptySeat(CourseLoad cl) {

        Seat seat = getEmptySeat();
        if (seat == null) {
            return null;
        }
        SeatAssignment sa = seat.newSeatAssignment(cl); //seat is already linked to course offer
        cl.registerStudent(sa); //coures offer seat is now linked to student
        return sa;
    }

    public int getTotalCourseRevenues() {

        int sum = 0;

        for (Seat s : seatlist) {
            if (s.isOccupied() == true) {
                sum = sum + course.getCoursePrice();
            }

        }
        return sum;
    }
    
    public Course getSubjectCourse(){
        return course;
    }
    
    public int getCreditHours(){
        return course.getCredits();
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        CourseOffer that = (CourseOffer) o;
        return this.course.getName() == that.course.getName();
    }
    
    @Override
    public int hashCode() {

        return this.course.getCourseNumber();
    }
    
    public String toString() {

        return String.valueOf(course.getCourseNumber());
    }

    public Course getCourse() {
        return course;
    }

    public ArrayList<Seat> getSeatlist() {
        return seatlist;
    }

    public FacultyAssignment getFacultyassignment() {
        return facultyassignment;
    }

    public boolean isEnrollmentStatus() {
        return enrollmentStatus;
    }

    public void setEnrollmentStatus(boolean enrollmentStatus) {
        this.enrollmentStatus = enrollmentStatus;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public int getClassroomNumber() {
        return classroomNumber;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }
    
}
