import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class StudentForm extends JFrame {

    JTextField txtId, txtName, txtCourse, txtAge, txtContact;
    JButton btnAdd, btnUpdate, btnDelete, btnClear;
    JTable table;
    DefaultTableModel model;

    public StudentForm() {

        setTitle("Student Management System");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6,2,10,10));

        // Labels and TextFields
        panel.add(new JLabel("Student ID"));
        txtId = new JTextField();
        panel.add(txtId);

        panel.add(new JLabel("Student Name"));
        txtName = new JTextField();
        panel.add(txtName);

        panel.add(new JLabel("Age"));
        txtAge = new JTextField();
        panel.add(txtAge);

        panel.add(new JLabel("Course"));
        txtCourse = new JTextField();
        panel.add(txtCourse);

        panel.add(new JLabel("Contact"));
        txtContact = new JTextField();
        panel.add(txtContact);

        // Buttons
        btnAdd = new JButton("Add");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");
        btnClear = new JButton("Clear");

        panel.add(btnAdd);
        panel.add(btnUpdate);

        panel.add(btnDelete);
        panel.add(btnClear);

        add(panel, BorderLayout.NORTH);

        // Table
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{
                "ID","Name","Course","Age","Contact"
        });

        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Add Button
        btnAdd.addActionListener(e -> {

            model.addRow(new Object[]{
                    txtId.getText(),
                    txtName.getText(),
                    txtCourse.getText(),
                    txtAge.getText(),
                    txtContact.getText()
            });

            clearFields();
        });

        // Clear Button
        btnClear.addActionListener(e -> clearFields());

        // Delete Button
        btnDelete.addActionListener(e -> {

            int row = table.getSelectedRow();

            if(row >= 0){
                model.removeRow(row);
            }
        });

        // Table Click
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

                int row = table.getSelectedRow();

                txtId.setText(model.getValueAt(row, 0).toString());
                txtName.setText(model.getValueAt(row,1).toString());
                txtCourse.setText(model.getValueAt(row,2).toString());
                txtAge.setText(model.getValueAt(row,   3).toString());
                txtContact.setText(model.getValueAt(row,4).toString());
            }
        });

        // Update Button
        btnUpdate.addActionListener(e -> {

            int row = table.getSelectedRow();

            if(row >= 0){

                model.setValueAt(txtId.getText(), row,0);
                model.setValueAt(txtName.getText(), row,1);
                model.setValueAt(txtCourse.getText(), row,2);
                model.setValueAt(txtAge.getText(), row,3);
                model.setValueAt(txtContact.getText(), row,4);

                clearFields();
            }
        });

        setVisible(true);
    }

    // Clear Method
    void clearFields(){

        txtId.setText("");
        txtName.setText("");
        txtCourse.setText("");
        txtAge.setText("");
        txtContact.setText("");
    }

    public static void main(String[] args) {

        new StudentForm();
    }
}
