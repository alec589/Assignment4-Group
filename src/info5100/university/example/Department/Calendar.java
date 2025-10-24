/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Department;

import info5100.university.example.CourseSchedule.CourseSchedule;
import java.lang.*;
import java.util.Collection;
import java.util.HashMap;
/**
 *
 * @author kal bugrara
 */
public class Calendar {
    
    HashMap<String, CourseSchedule> mastercatalog; 
    
    public Calendar(){
    mastercatalog = new HashMap<String, CourseSchedule>();    
    }
    
    public void addCourseSchedule(String semester, CourseSchedule cs){
        
        mastercatalog.put(semester, cs);
        
    }
    public CourseSchedule getCourseSchedule(String semester) {
        return mastercatalog.get(semester);
    }
    
    public Collection<String> getAllSemesterNames() {
        return mastercatalog.keySet();
}
}
