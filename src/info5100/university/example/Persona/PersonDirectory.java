/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona;

import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author kal bugrara
 */
public class PersonDirectory {
    
      ArrayList<Person> personlist ;
    
      public PersonDirectory (){
          
       personlist = new ArrayList();

    }

    
    public Person newPerson(String name) {

        Person p = new Person(name); 
        String uniqueId = "U-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        
       
        while (isIdExists(uniqueId)) {
             uniqueId = "U-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        }
        
        p.setPersonId(uniqueId); 
        personlist.add(p);
        return p;
    }

    public Person findPerson(String id) {

        for (Person p : personlist) {
         
            if (p.getPersonId() != null && p.getPersonId().equals(id)) {
                return p;
            }
        }
            return null; 
         }
    
    public boolean isEmailExists(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false; 
        }
        String trimmedEmail = email.trim();
        for (Person p : personlist) {
            if (p.getEmail() != null && p.getEmail().equalsIgnoreCase(trimmedEmail)) {
                return true;
            }
        }
        return false;
    }
    
    
    public boolean isIdExists(String id) {
        if (id == null) {
            return false;
        }
        for (Person p : personlist) {
            if (p.getPersonId() != null && p.getPersonId().equals(id)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean removePerson(Person personToRemove) {
        if (personToRemove == null || personlist == null) {
            return false;
        }
        // Use ArrayList's remove method on the internal list
        return personlist.remove(personToRemove); 
    }
}