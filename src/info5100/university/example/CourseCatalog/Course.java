/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseCatalog;

/**
 *
 * @author kal bugrara
 */
public class Course {
    private static int counter =1;
    int number;
    String name;
    int credits;
    int price = 1500; //per credit hour
    
    String description;

    public Course( String numb, int ch) {
        this.number=counter++;
        
        name = numb;
        credits = ch;

    }

    public int getCourseNumber() {
        return number;
    }

    public int getCoursePrice() {
        return price * credits;

    }

    public int getCredits() {
        return credits;
    
}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    
}