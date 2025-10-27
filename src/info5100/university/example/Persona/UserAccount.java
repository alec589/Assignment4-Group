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

import info5100.university.example.workareas.Workarea;

/**
 *
 * @author kal bugrara
 */
public class UserAccount {
    Person person;
    Workarea landingworkarea;
    Profile profile;
    String UserName;
    String UserPassword;
    int ID;
    static int count=0;
    String Email;
    
    public UserAccount(Profile profile,String username, String userpassword){
        this.profile = profile;
        UserName = username;
        UserPassword =userpassword;
        count++;
        ID = count;
    }

   public String GetPersonID(){
        return profile.getPerson().getPersonId();
    
}
    public String getPersonName(){
        return profile.getPerson().getName();
    }
     public String getUserLoginName(){
        return UserName;
    }
    public boolean IsValidUser(String un, String pw){
        
            if (UserName.equalsIgnoreCase(un) && UserPassword.equals(pw)) return true;
            else return false;
        
        }
      public String getRole(){
            return profile.getrole();
        }
       public Profile getAssociatedPersonProfile(){
            return profile;
        }
        public boolean isMatch(String id){
        if(GetPersonID().equals(id)) return true;
        return false;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public void setUserPassword(String UserPassword) {
        this.UserPassword = UserPassword;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    @Override
    public String toString(){
        return String.valueOf(ID);
    }
    
}