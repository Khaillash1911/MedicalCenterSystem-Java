/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment;

/**
 *
 * @author Rauf
 */
public class Admin extends User {
   
    public Admin(String name, String email, String password){
        super(name, email, password);
        setRole("Admin");
    }
    
    @Override
    public String getRole(){
        return "Admin";
    }
}