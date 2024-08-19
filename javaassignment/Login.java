package javaassignment;

import java.io.*;
import javaassignment.User;

public class Login extends User {

    public void doctorValidation(String email, String password) throws IOException {
        File file = new File("C:/Users/Rauf/Desktop/Java/doctor.txt");
        
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {
            
            String line;
            boolean found = false;
            
            while ((line = br.readLine()) != null) {
                // Assuming each line in the file represents a doctor's information in format "username,password"
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String storedEmail = parts[0].trim();
                    String storedPassword = parts[1].trim();
                    
                    if (storedEmail.equals(email) && storedPassword.equals(password)) {
                        found = true;
                        break;
                    }
                }
            }
            
            if (found) {
                System.out.println("Doctor validated successfully.");
                // Implement further actions upon successful validation
            } else {
                System.out.println("Doctor not found or invalid credentials.");
                // Handle invalid credentials or doctor not found
            }
            
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }
}
