package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 *
 * @author sammr
 */
public class LoginView extends javax.swing.JPanel {

    /**
     * Creates new form LoginView
     */
    public LoginView() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        // Initialize the components. Variable declaration is at the end of this file.
        pageLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        staffLabel = new javax.swing.JLabel();
        ssnLabel = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        ssnInput = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        registerPatient = new javax.swing.JButton();
        billingButton = new javax.swing.JButton();


        setPreferredSize(new java.awt.Dimension(1000, 900));

        pageLabel.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
        pageLabel.setText("Welcome to UCalgary Hospital");

        staffLabel.setText("Hospital Staff Login");

        ssnLabel.setText("Enter Role Type:");

        billingButton.setText("Billing");
        billingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billingButtonActionPerformed(evt);
            }
        });

        loginButton.setText("Login");
        // Login button listener. Method is implemented near the end of this file.
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        registerPatient.setText("Register Patient");
        registerPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerPatientActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(367, 367, 367)
                                                .addComponent(pageLabel))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(308, 308, 308)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(56, 56, 56)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(ssnInput, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(loginButton))
                                                                        .addComponent(ssnLabel)
                                                                        .addComponent(staffLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(438, 438, 438)
                                                .addComponent(registerPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(313, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(110, 110, 110)
                                        .addComponent(billingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(800, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(pageLabel)
                                .addGap(276, 276, 276)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(staffLabel)
                                .addGap(46, 46, 46)
                                .addComponent(ssnLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(loginButton)
                                        .addComponent(ssnInput, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(55, 55, 55)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 277, Short.MAX_VALUE)
                                .addComponent(registerPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap(804, Short.MAX_VALUE)
                                        .addComponent(billingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(44, 44, 44)))
        );
    }// </editor-fold>

    private void registerPatientActionPerformed(ActionEvent evt) {
        MainView mainView = (MainView) SwingUtilities.getWindowAncestor(this);
        mainView.setRegisterPatientView(new RegisterPatientView());
        mainView.setCard(1);
    }

    private void billingButtonActionPerformed(ActionEvent evt) {
        MainView mainView = (MainView) SwingUtilities.getWindowAncestor(this);
        mainView.setBillingView(new BillView());
        mainView.setCard(10);
    }


    // Variables declaration - do not modify
    private javax.swing.JButton billingButton;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel pageLabel;
    private javax.swing.JButton registerPatient;
    private javax.swing.JTextField ssnInput;
    private javax.swing.JLabel ssnLabel;
    private javax.swing.JLabel staffLabel;
    // End of variables declaration

    //Switches to various staff views based on JTextField input - loginID.
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (ssnInput.getText().equals("doctor")) {
            MainView mainView = (MainView) SwingUtilities.getWindowAncestor(this);
            mainView.setDoctorView(new DoctorView());
            mainView.setCard(3);
        } else if (ssnInput.getText().equals("nurse")) {
            MainView mainView = (MainView) SwingUtilities.getWindowAncestor(this);
            mainView.setNurseView(new NurseView());
            mainView.setCard(6);
        } else if (ssnInput.getText().equals("admin")) {
            MainView mainView = (MainView) SwingUtilities.getWindowAncestor(this);
            mainView.setAppointmentView(new AppointmentView());
            mainView.setCard(5);
        } else if (ssnInput.getText().equals("labtech")) {
            MainView mainView = (MainView) SwingUtilities.getWindowAncestor(this);
            mainView.setLabTechView(new LabTechView());
            mainView.setCard(8);
        } else if (ssnInput.getText().equals("surgeon")) {
            MainView mainView = (MainView) SwingUtilities.getWindowAncestor(this);
            mainView.setSurgeonView(new SurgeonView());
            mainView.setCard(9);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid login ID");
        }
    }

}
