package javaassignment.patient;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.*;
import javax.swing.JOptionPane;

public class Appoint {
    
    private String patientName; // New field for appointment ID
    private String date;
    private String timeslot;
    private String category; // Assuming date as String for simplicity in this example
    private String status;

    private static List<Appoint> appointments = new ArrayList<>();


    public Appoint(String patientName, String date, String timeslot, String category, String status) {
        this.patientName = patientName;
        this.date = date;
        this.timeslot = timeslot;
        this.category = category;
        this.status = "Scheduled";
    }
    


    // Getter and Setter methods

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(String timeslot) {
        this.timeslot = timeslot;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // CRUD Functions using ArrayList

    // Create a new appointment with auto-generated ID
    public static void createAppointment(String patientName, String date, String timeslot, String category, String status) {
        Appoint newAppointment = new Appoint(patientName, date, timeslot, category, status);
        appointments.add(newAppointment);
        saveAppointmentsToFile();
    }
    
    // Read all appointments
    public static List<Appoint> readAppointments() {
        return appointments;
    }

    // Update an existing appointment
    

    // Delete an appointment
    public static void cancelAppointment(String patientName, String date) {
    for (Appoint appointment : appointments) {
        if (appointment.getPatientName().equals(patientName) && appointment.getDate().equals(date)) {
            appointment.setStatus("Cancelled");
        }
    }
    saveAppointmentsToFile();
    }

    // Save appointments to file
    public static void saveAppointmentsToFile(){
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("src\\textfiles\\appointment.txt"))) {
        for (Appoint appointment : appointments) {
            writer.write(appointment.toFileString());
            writer.newLine();
        }
    } catch (IOException e) {
        System.err.println("Error writing to file: " + e.getMessage());
    }
    }


    // Function to convert appointment details to a string for file storage
    private String toFileString() {
        return patientName + ", " + date + ", " + timeslot + ", " + category + ", " + status ;
    }
    
    public static List<Appoint> getAllAppointments() {
        return appointments;
    }

    // Function to load appointments from file into ArrayList
    public static void loadAppointmentsFromFile() {
        appointments.clear(); // Clear existing list before loading

        try (BufferedReader reader = new BufferedReader(new FileReader("src\\textfiles\\appointment.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 5) {
                    appointments.add(new Appoint(parts[0], parts[1], parts[2], parts[3], parts[4]));
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }
    
    


    
}
