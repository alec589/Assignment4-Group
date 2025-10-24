/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseCatalog;

import info5100.university.example.Department.Department;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class CourseCatalog {
    Department department;
    String lastupdated;
    ArrayList<Course> courselist; 
    public CourseCatalog(Department d){
        courselist = new ArrayList();
        department = d;
    }
    
    public ArrayList<Course> getCourseList(){
        return courselist;
    }
    
    public Course newCourse( String nm, int cr){
        Course c = new Course( nm, cr);
        courselist.add(c);
        return c;
    }
    
    public Course getCourseByNumber(int n){
        
        for( Course c: courselist){
            
            if(c.getCourseNumber()==(n)) return c;
        }
        return null;
    }
    public Course getCourseByName(String n){
        
        for( Course c: courselist){
            
            if(c.getName()==n) return c;
        }
        return null;
    }
}