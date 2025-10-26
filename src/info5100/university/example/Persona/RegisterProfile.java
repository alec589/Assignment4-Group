/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package info5100.university.example.Persona;

/**
 *
 * @author sunzuolin
 */
public class RegisterProfile extends Profile{
    Person person;
    String name;
    String phoneNumber;
    String email;
    String offerHour;
    int ID;
    static int count=0;
    
     public RegisterProfile(Person p){
     
      super(p);
        person = p;   
        count++;
        ID = count;
     }
     
     public String getrole(){
        return  "Register";
    }
     
       public boolean isMatch(String id) {
        if (person.getPersonId().equals(id)) {
            return true;
        }
        return false;
    }

    public Person getPerson() {
        return person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOfferHour() {
        return offerHour;
    }

    public void setOfferHour(String offerHour) {
        this.offerHour = offerHour;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
      
    
}
