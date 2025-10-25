/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona;

import info5100.university.example.Department.Department;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class StudentDirectory {

    Department department;
    ArrayList<StudentProfile> studentlist;
    public StudentDirectory(Department d) {

        department = d;
        studentlist = new ArrayList();

    }

    public StudentProfile newStudentProfile(Person p) {

        StudentProfile sp = new StudentProfile(p);
        studentlist.add(sp);
        return sp;
    }

    public StudentProfile findStudent(String id) {

        for (StudentProfile sp : studentlist) {

            if (sp.isMatch(id)) {
                return sp;
            }
        }
            return null; //not found after going through the whole list
         }
    public StudentProfile findStudentByName(String name) {

        for (StudentProfile sp : studentlist) {

            if (sp.isMatchName(name)) {
                return sp;
            }
        }
            return null; //not found after going through the whole list
         }
    public ArrayList<StudentProfile> findStudentListByName(String name) {
        ArrayList<StudentProfile> result = new ArrayList<>();
        if (name == null || name.isEmpty()) {
        return new ArrayList<>();
    }
        for (StudentProfile sp : studentlist) {

            if (sp.isMatchName(name)) {
                result.add(sp);
            }
        }
            return result;
         }

    public ArrayList<StudentProfile> getStudentlist() {
        return studentlist;
    }
    
}
