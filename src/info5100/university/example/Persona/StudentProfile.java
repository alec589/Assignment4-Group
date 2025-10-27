/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona;

import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.SeatAssignment;
import info5100.university.example.Persona.EmploymentHistory.EmploymentHistroy;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class StudentProfile extends Profile{

    Person person;
    Transcript transcript;
    EmploymentHistroy employmenthistory;
    static int counter=0;
    int studentID;
    String firstName;
    String lastName;
    double tuitionBalance = 7000.0;
    String status;
    ArrayList<PaymentTransaction> paymentHistory = new ArrayList<>();
    
    public StudentProfile(Person p) {
        super(p);
        person = p;
        transcript = new Transcript(this);
        employmenthistory = new EmploymentHistroy();
        counter++;
        studentID = counter;
        status = "Avtive";
    }

    public String getStatus() {
        return status;
    }
    
    public void updateBalance(double changeAmount, String type, String description ,SeatAssignment seatassignment) {
        if(type=="bill"){
        this.tuitionBalance = tuitionBalance + (-changeAmount); 
        PaymentTransaction transaction = new PaymentTransaction(changeAmount, type, description, this.tuitionBalance,seatassignment);
        this.paymentHistory.add(transaction);}else{
        this.tuitionBalance = tuitionBalance - (-changeAmount); 
        PaymentTransaction transaction = new PaymentTransaction(changeAmount, type, description, this.tuitionBalance,seatassignment);
        this.paymentHistory.add(transaction);
        }
    }
    public ArrayList<PaymentTransaction> getPaymentHistory() {
        return paymentHistory;
    }

    public double getTuitionBalance() {
        return tuitionBalance;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public boolean isMatch(String id) {
        return person.getPersonId().equals(id);
    }
    public boolean isMatchName(String name) {
        return firstName.toLowerCase().contains(name.toLowerCase())||lastName.toLowerCase().contains(name.toLowerCase());
    }
    public Transcript getTranscript() {
        return transcript;
    }

    public CourseLoad getCourseLoadBySemester(String semester) {

        return transcript.getCourseLoadBySemester(semester);
    }

    public CourseLoad getCurrentCourseLoad() {

        return transcript.getCurrentCourseLoad();
    }

    public CourseLoad newCourseLoad(String s) {

        return transcript.newCourseLoad(s);
    }

    public ArrayList<SeatAssignment> getCourseList() {

        return transcript.getCourseList();

    }
    
    public String getrole(){
        return  "Student";
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    @Override
   public String toString(){
   return String.valueOf(studentID);
   }
    
}
