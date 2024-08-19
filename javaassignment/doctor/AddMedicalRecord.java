/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment.doctor;

/**
 *
 * @author Rauf
 */
public class AddMedicalRecord {
    private String name;
    private int age;
    private String num;
    private String allergy;
    private String illness;
    private String date;

    // Constructor
    public AddMedicalRecord(String name, int age, String num, String allergy, String illness, String date) {
        this.name = name;
        this.age = age;
        this.num = num;
        this.allergy = allergy;
        this.illness = illness;
        this.date = date;
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}


