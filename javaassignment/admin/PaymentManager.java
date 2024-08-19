
package javaassignment.admin;

import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class PaymentManager {
    private DefaultTableModel model;

    public PaymentManager(DefaultTableModel model) {
        this.model = model;
        model.setColumnIdentifiers(new String[] {"Patient Name", "Doctor Name", "Date", "Payment Status", "Amount"});
        loadPaymentsFromFile();
    }
    
    private void loadPaymentsFromFile() {
        try {
            FileReader fr = new FileReader("src\\textfiles\\payment.txt");
            BufferedReader br = new BufferedReader(fr);

            String line = null;
            while ((line = br.readLine()) != null) {
                String values[] = line.split(", ");
                model.addRow(values);
            }

            br.close();
            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
    public void addPayment(String patientName, String doctorName,String date, String paymentStatus, double amount) {
        String paymentRow[] = {patientName, doctorName, date, paymentStatus, String.valueOf(amount)};
        model.addRow(paymentRow);
        savePaymentsToFile();
    }
    
    public void editPayment(int row, String patientName, String doctorName, String date, String paymentStatus, double amount) {
        model.setValueAt(patientName, row, 0);
        model.setValueAt(doctorName, row, 1);
        model.setValueAt(date, row, 2);
        model.setValueAt(paymentStatus, row, 3);
        model.setValueAt(amount, row, 4);
        savePaymentsToFile();
    
    }
    
    public void deletePayment(int row){
        if (row >= 0 && row < model.getRowCount()) {
            model.removeRow(row);
            savePaymentsToFile();
        } else {
            JOptionPane.showMessageDialog(null, "Please choose a row");
        }
    }
    
    public void savePaymentsToFile() {
        try {
            FileWriter fw = new FileWriter("src\\textfiles\\payment.txt");
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
