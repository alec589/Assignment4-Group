/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package info5100.university.example.Persona;

import info5100.university.example.CourseSchedule.SeatAssignment;
import java.util.Date;

/**
 *
 * @author sunzuolin
 */
public class PaymentTransaction {
    Date transactionDate;
    double amount; 
    String type;   
    String description; 
    double newBalance;  
    SeatAssignment seatassignment;

    public PaymentTransaction(double amount, String type, String description, double newBalance,SeatAssignment seatassignment) {
        this.transactionDate = new Date(); 
        this.amount = amount;
        this.type = type;   
        this.description = description;
        this.newBalance = newBalance;
        this.seatassignment = seatassignment;
    }

    public SeatAssignment getSeatassignment() {
        return seatassignment;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public double getNewBalance() {
        return newBalance;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", type, description);
    }
}
