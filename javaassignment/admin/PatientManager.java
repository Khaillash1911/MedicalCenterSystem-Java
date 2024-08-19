
package javaassignment.admin;

import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PatientManager {
    private DefaultTableModel model;
    private String[] columnName = {"Full Name", "Age","Phone Number","Password","Email"};
    
    
    public PatientManager(){
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columnName);
        loadFromFile();
    }
     
    public DefaultTableModel getModel(){
        return model;
    }
    
    public void loadFromFile(){
        try{
            FileReader fr = new FileReader("src\\textfiles\\patient.txt");
            BufferedReader br = new BufferedReader(fr);
            
            String line;
            while ((line = br.readLine()) != null){
                String[] values = line.split(", ");
                model.addRow(values);
            }
            br.close();
            fr.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public void addPatient(String patientName, int patientAge, String patientNum, String patientMail, String patientPass ){
         boolean emailExists = false;

        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 3) != null && model.getValueAt(i, 3).equals(patientMail)) { 
                emailExists = true;
                break;
            }
        }

        if (emailExists) {
            JOptionPane.showMessageDialog(null, "Patient with this email already exists.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String[] patientRow = {patientName, String.valueOf(patientAge), patientNum, patientMail, patientPass};
            model.addRow(patientRow);
            saveToFile();
        }
    }
    
    
    public void editPatient(int row, String patientName, int patientAge, String patientNum, String patientMail, String patientPass ){
        boolean emailExists = false;

        for (int i = 0; i < model.getRowCount(); i++) {
            if (i != row && model.getValueAt(i, 4).equals(patientMail)) { 
                emailExists = true;
                break;
            }
        }

        if (emailExists) {
            JOptionPane.showMessageDialog(null, "A patient with this email already exists.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String[] patientValues = {patientName, String.valueOf(patientAge), patientNum, patientMail, patientPass};
            model.removeRow(row);
            model.insertRow(row, patientValues);
            saveToFile();
        }
    }
    
    public void deletePatient(int row){
        if(row != 1){
            model.removeRow(row);
            saveToFile();
        }
    }
    
    private void saveToFile() {
        try {
            FileWriter fw = new FileWriter("src\\textfiles\\patient.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    bw.write(model.getValueAt(i, j).toString());
                    if (j < model.getColumnCount() - 1) bw.write(", ");
                }
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        
}
