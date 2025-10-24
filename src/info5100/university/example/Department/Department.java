/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Department;

import info5100.university.example.College.College;
import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseCatalog.CourseCatalog;
import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.Degree.Degree;
import info5100.university.example.Employer.EmployerDirectory;
import info5100.university.example.Persona.Faculty.FacultyDirectory;
import info5100.university.example.Persona.PersonDirectory;
import info5100.university.example.Persona.RegisterDirectory;
import info5100.university.example.Persona.StudentDirectory;
import info5100.university.example.Persona.StudentProfile;
import info5100.university.example.Persona.UserAccountDirectory;
import java.util.HashMap;

/**
 *
 * @author kal bugrara
 */
public class Department {

    String name;
    CourseCatalog coursecatalog;
    PersonDirectory persondirectory;
    StudentDirectory studentdirectory;
    FacultyDirectory facultydirectory;
    EmployerDirectory employerdirectory;
    Degree degree;
    RegisterDirectory registerdirectory;
    UserAccountDirectory useraccountdirectory;
    Calendar calendar;
    CourseLoad courseload;
    College college;
    

    HashMap<String, CourseSchedule> mastercoursecatalog;

    public Department(String n) {
        name = n;
        mastercoursecatalog = new HashMap<>();
        coursecatalog = new CourseCatalog(this);
        studentdirectory = new StudentDirectory(this); //pass the department object so it stays linked to it
        persondirectory = new PersonDirectory();
        degree = new Degree("MSIS");
        useraccountdirectory = new UserAccountDirectory(this);
        calendar = new Calendar();
        facultydirectory = new FacultyDirectory(this);
        registerdirectory=new RegisterDirectory(this);
    }

    public String getName() {
        return name;
    }

    public CourseCatalog getCoursecatalog() {
        return coursecatalog;
    }

    public PersonDirectory getPersondirectory() {
        return persondirectory;
    }

    public StudentDirectory getStudentdirectory() {
        return studentdirectory;
    }

    public FacultyDirectory getFacultydirectory() {
        return facultydirectory;
    }

    public EmployerDirectory getEmployerdirectory() {
        return employerdirectory;
    }

    public Degree getDegree() {
        return degree;
    }

    public RegisterDirectory getRegisterdirectory() {
        return registerdirectory;
    }

    public UserAccountDirectory getUseraccountdirectory() {
        return useraccountdirectory;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public CourseLoad getCourseload() {
        return courseload;
    }

    public HashMap<String, CourseSchedule> getMastercoursecatalog() {
        return mastercoursecatalog;
    }
    
    public void addCoreCourse(Course c){
        degree.addCoreCourse(c);
        
    }
    public void addElectiveCourse(Course c){
        degree.addElectiveCourse(c);
        
    }
    public PersonDirectory getPersonDirectory() {

        return persondirectory;

    }

    public StudentDirectory getStudentDirectory() {
    return studentdirectory;
    }

    public CourseSchedule newCourseSchedule(String semester) {

        CourseSchedule cs = new CourseSchedule(semester, coursecatalog);
        mastercoursecatalog.put(semester, cs);
        return cs;
    }

    public CourseSchedule getCourseSchedule(String semester) {

        return mastercoursecatalog.get(semester);

    }

    public CourseCatalog getCourseCatalog() {

        return coursecatalog;

    }

    public Course newCourse( String nm, int cr) {

        Course c = coursecatalog.newCourse( nm, cr);
        return c;
    }

    public int calculateRevenuesBySemester(String semester) {

        CourseSchedule css = mastercoursecatalog.get(semester);

        return css.calculateTotalRevenues();

    }

    public void RegisterForAClass(String studentid, int cn, String semester) {

        StudentProfile sp = studentdirectory.findStudent(studentid);

        CourseLoad cl = sp.getCurrentCourseLoad();

        CourseSchedule cs = mastercoursecatalog.get(semester);

        CourseOffer co = cs.getCourseOfferByNumber(cn);

        co.assignEmptySeat(cl);

    }
    public void setCollege(College college) {
    this.college = college;
}

public College getCollege() {
    return college;
}
}
