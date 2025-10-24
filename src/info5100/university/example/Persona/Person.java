/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona;

/**
 *
 * @author kal bugrara
 */
public class Person {
    
    String ID;
    String Name;
    String Email;
    
    public Person (String name){
        
        
        this.Name=name;
    }
    public String getPersonId(){
        return ID;
    }

    public String getName() {
        return Name;
    }

        public boolean isMatch(String id){
        if(getPersonId().equals(id)) return true;
        return false;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    
    
}
