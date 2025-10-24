/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona;

import info5100.university.example.Persona.*;
import info5100.university.example.Department.Department;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class UserAccountDirectory {

    Department department;
    ArrayList<UserAccount> UserAccountDirectory;

    public UserAccountDirectory(Department d) {

        department = d;
        UserAccountDirectory = new ArrayList();

    }

    public UserAccount addUserAccount(Profile profile, String username, String userpassword) {

        UserAccount ua = new UserAccount(profile,username,userpassword);
        UserAccountDirectory.add(ua);
        return ua;
    }

    public UserAccount findStudent(String id) {

        for (UserAccount sa : UserAccountDirectory) {

           if (sa.isMatch(id)) {
                return sa;
           }
        }
            return null; //not found after going through the whole list
         }
    public UserAccount findUserAccount(String name) {

        for (UserAccount useraccount : UserAccountDirectory) {

            if (useraccount.getPersonName().equals(name)) {
                return useraccount;
            }
        }
            return null; //not found after going through the whole list
         }
      public UserAccount AuthenticateUser(String username, String userpassword) {

        for (UserAccount useraccount : UserAccountDirectory) {

            if (useraccount.IsValidUser(username, userpassword)) {
                return useraccount;
            }
        }
            return null; 
         }   
    public boolean removeUserAccountByUser(Profile profile) {
    UserAccount toRemove = null;

   
    for (UserAccount ua : UserAccountDirectory) {
        if (ua.getAssociatedPersonProfile() == profile) {
            toRemove = ua;   
            break;          
        }
    }

  
    if (toRemove != null) {
        UserAccountDirectory.remove(toRemove);
        return true;
    }
    return false;
}
    public ArrayList<UserAccount> getUserAccountDirectory() {
        return UserAccountDirectory;
    }
      
}
