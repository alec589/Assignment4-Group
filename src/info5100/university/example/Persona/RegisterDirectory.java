/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package info5100.university.example.Persona;

import info5100.university.example.Department.Department;
import java.util.ArrayList;

/**
 *
 * @author lichun
 */
public class RegisterDirectory {
    Department department;
    ArrayList<RegisterProfile> registerlist;

    public RegisterDirectory(Department d) {

        department = d;
        registerlist = new ArrayList();

    }

    public RegisterProfile newRegisterProfile(Person p) {

        RegisterProfile rp = new RegisterProfile(p);
        registerlist.add(rp);
        return rp;
    }

    public RegisterProfile findRgister(String id) {

        for (RegisterProfile rp : registerlist) {

            if (rp.isMatch(id)) {
                return rp;
            }
        }
            return null; //not found after going through the whole list
         }
    
    public RegisterProfile findRegisterProfile(String personId) {
        if (personId == null || personId.trim().isEmpty() || registerlist == null) {
            return null; 
        }

        for (RegisterProfile rp : registerlist) {
            Person person = rp.getPerson();
           
            if (person != null && personId.equals(person.getPersonId())) {
                return rp; // Found the matching profile
            }
        }
        return null; 
    }
        public RegisterProfile findRegister(int id) {
        for (RegisterProfile rp : registerlist) {
            if (rp.getID()==id) {
                return rp; // Found the matching profile
            }
        }
        return null; 
    }
    public ArrayList<RegisterProfile> getRegisterlist() {
    return registerlist;
}
    public void delete(RegisterProfile r){
    registerlist.remove(r);
    }

    public ArrayList<RegisterProfile> getRegistrarList() {
    return getRegisterlist();
}
}
