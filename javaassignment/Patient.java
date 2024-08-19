/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment;

/**
 *
 * @author Rauf
 */
public class Patient extends User {
   
    public Patient(String name, String email, String password){
        super(name, email, password);
        setRole("Patient");
    }
    
    @Override
    public String getRole(){
        return "Patient";
    }
}
