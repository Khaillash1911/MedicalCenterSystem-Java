/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment.doctor;

/**
 *
 * @author Rauf
 */
public class Appointment {
    private String patientName;
    private String date;
    private String time;
    private String category;
    private String status;
    private String doctorName;

    // Constructor
    public Appointment(String patientName, String date, String time, String category, String status, String doctorName) {
        this.patientName = patientName;
        this.date = date;
        this.time = time;
        this.category = category;
        this.status = status;
        this.doctorName = doctorName;
    }

    // Getter methods
    public String getPatientName() {
        return patientName;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getCategory() {
        return category;
    }

    public String getStatus() {
        return status;
    }

    public String getDoctorName() {
        return doctorName;
    }
}

