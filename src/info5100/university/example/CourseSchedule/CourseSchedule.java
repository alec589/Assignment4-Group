/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseSchedule;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseCatalog.CourseCatalog;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class CourseSchedule {

    CourseCatalog coursecatalog;

    ArrayList<CourseOffer> schedule;
    String semester;

    public CourseSchedule(String s, CourseCatalog cc) {
        semester = s;
        coursecatalog = cc;
        schedule = new ArrayList();

    }

    public CourseOffer newCourseOffer(int  n) {
        Course c = coursecatalog.getCourseByNumber(n);
        if(c==null) return null;
        CourseOffer co;
        co = new CourseOffer(c);
        schedule.add(co);
        return co;
    }
    
    public void deleteCourseOffer(CourseOffer co) {
       schedule.remove(co);
    }
    
    public ArrayList<CourseOffer> getSchedule() {
        return schedule;
    }

    public CourseOffer getCourseOfferByNumber(int n) {
        for (CourseOffer co : schedule) {
            if (co.getCourseNumber()==(n)) {
                return co;
            }
        }
        return null;
    }
    
    public CourseOffer getCourseOfferByName(String name) {
        if (name == null) return null;
        for (CourseOffer co : schedule) {
            if (co.getCourseName().toLowerCase().contains(name.toLowerCase())) {
                return co;
            }
        }
        return null;
    }

    public int calculateTotalRevenues() {
        int sum = 0;
        for (CourseOffer co : schedule) {
            sum = sum + co.getTotalCourseRevenues();
        }
        return sum;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    
}
