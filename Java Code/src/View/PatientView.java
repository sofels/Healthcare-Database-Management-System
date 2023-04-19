package View;

import Controller.Create_DB;

import javax.swing.*;
import java.awt.*;

public class PatientView extends javax.swing.JPanel {
    /**
     * Creates new form PatientView
     */
    public PatientView() {
        initComponents();
    }

    /**
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        step1Label = new javax.swing.JLabel();
        HcnInput = new javax.swing.JTextField();
        step2LAbel = new javax.swing.JLabel();
        bdMonthInput = new javax.swing.JComboBox<>();
        bdMonthLabel = new javax.swing.JLabel();
        dayLabel = new javax.swing.JLabel();
        bdDayInput = new javax.swing.JComboBox<>();
        yearLabel = new javax.swing.JLabel();
        bdYearInput = new javax.swing.JComboBox<>();
        submitButton = new javax.swing.JButton();
        pageLabel = new javax.swing.JLabel();
        hcnLabel = new javax.swing.JLabel();
        pNameLabel = new javax.swing.JLabel();
        pNameInput = new javax.swing.JTextField();
        phoneLabel = new javax.swing.JLabel();
        phoneInput = new javax.swing.JTextField();
        famHistoryLabel = new javax.swing.JLabel();
        famHistoryInput = new javax.swing.JTextField();
        allergyLabel = new javax.swing.JLabel();
        allergyInput = new javax.swing.JTextField();
        smokerLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        smokerInput = new javax.swing.JList<>();
        birthdateLabel = new javax.swing.JLabel();
        genderLabel = new javax.swing.JLabel();
        genderInput = new javax.swing.JTextField();
        pecLabel = new javax.swing.JLabel();
        pecInput = new javax.swing.JTextField();
        addressLabel = new javax.swing.JLabel();
        addressInput = new javax.swing.JTextField();
        cityLabel = new javax.swing.JLabel();
        cityInput = new javax.swing.JTextField();
        provinceLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        provinceInput = new javax.swing.JList<>();
        monthDrop2 = new javax.swing.JComboBox<>();
        monthLabel1 = new javax.swing.JLabel();
        dayLabel1 = new javax.swing.JLabel();
        monthDrop3 = new javax.swing.JComboBox<>();
        yearLabel1 = new javax.swing.JLabel();
        yearDrop1 = new javax.swing.JComboBox<>();
        submitButton1 = new javax.swing.JButton();

        dconn = new Create_DB();

        step1Label.setText("Step 1: Please fill out all boxes below.");

        HcnInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HcnInputActionPerformed(evt);
            }
        });

        step2LAbel.setText("Step 2: Select the date of your desired appointment");

        bdMonthInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        bdMonthLabel.setText("Month");

        dayLabel.setText("Day");

        bdDayInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        yearLabel.setText("Year");

        bdYearInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        pageLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pageLabel.setText("Patient Registration");

        hcnLabel.setText("Health Card Number");

        pNameLabel.setText("Name");

        pNameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pNameInputActionPerformed(evt);
            }
        });

        phoneLabel.setText("Phone Number");

        phoneInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneInputActionPerformed(evt);
            }
        });

        famHistoryLabel.setText("Family History");

        famHistoryInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                famHistoryInputActionPerformed(evt);
            }
        });

        allergyLabel.setText("Allergies");

        allergyInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allergyInputActionPerformed(evt);
            }
        });

        smokerLabel.setText("Smoker");

        smokerInput.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Yes", "No" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(smokerInput);

        birthdateLabel.setText("Birth Date");

        genderLabel.setText("Gender");

        genderInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderInputActionPerformed(evt);
            }
        });

        pecLabel.setText("Pre-existing Conditions");

        pecInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pecInputActionPerformed(evt);
            }
        });

        addressLabel.setText("Address");

        addressInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressInputActionPerformed(evt);
            }
        });

        cityLabel.setText("City");

        cityInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cityInputActionPerformed(evt);
            }
        });

        provinceLabel.setText("Province");

        provinceInput.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "AB", "BC", "SK", "NWT", "YT", "NT", "MB", "QC", "NS", "NB", "PE", "NL" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(provinceInput);

        monthDrop2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        monthLabel1.setText("Month");

        dayLabel1.setText("Day");

        monthDrop3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        yearLabel1.setText("Year");

        yearDrop1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        submitButton1.setText("Back");
        submitButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(submitButton)
                                .addGap(24, 24, 24))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(136, 136, 136)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(addressLabel)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(addressInput, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(pecLabel)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(pecInput, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(submitButton1)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(6, 6, 6)
                                                                                .addComponent(hcnLabel)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(HcnInput, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(step1Label)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(pNameLabel)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(pNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(phoneLabel)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(phoneInput, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(famHistoryLabel)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(famHistoryInput, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(birthdateLabel)
                                                                                                .addGap(40, 40, 40)
                                                                                                .addComponent(bdMonthInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(114, 114, 114)
                                                                                                .addComponent(bdMonthLabel)))
                                                                                .addGap(18, 18, 18)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(24, 24, 24)
                                                                                                .addComponent(dayLabel))
                                                                                        .addComponent(bdDayInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(bdYearInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(42, 42, 42)
                                                                                                .addComponent(yearLabel))))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(genderLabel)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(genderInput, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                                .addGap(70, 70, 70)
                                                                                                                .addComponent(allergyInput, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGap(42, 42, 42))
                                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                                .addComponent(allergyLabel)
                                                                                                                .addGap(22, 22, 22)))
                                                                                                .addComponent(smokerLabel))
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(cityLabel)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(cityInput, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addComponent(step2LAbel)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                        .addComponent(monthDrop2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                                .addGap(22, 22, 22)
                                                                                                                .addComponent(monthLabel1)))
                                                                                                .addGap(18, 18, 18)
                                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                                .addGap(24, 24, 24)
                                                                                                                .addComponent(dayLabel1))
                                                                                                        .addComponent(monthDrop3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                                .addGap(18, 18, 18)
                                                                                                                .addComponent(yearDrop1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                                .addGap(42, 42, 42)
                                                                                                                .addComponent(yearLabel1)))))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(provinceLabel)
                                                                                                .addGap(4, 4, 4)
                                                                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(418, 418, 418)
                                                .addComponent(pageLabel)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(pageLabel)
                                .addGap(18, 18, 18)
                                .addComponent(step1Label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(HcnInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(hcnLabel))
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(pNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pNameLabel)
                                        .addComponent(phoneInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(phoneLabel))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(famHistoryInput, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(famHistoryLabel))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(allergyInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(allergyLabel)
                                                                        .addComponent(smokerLabel))
                                                                .addGap(51, 51, 51)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(bdMonthLabel)
                                                                                .addGap(4, 4, 4)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(birthdateLabel)
                                                                                        .addComponent(bdMonthInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(dayLabel)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(bdDayInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(yearLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(bdYearInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(34, 34, 34)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(genderInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(genderLabel))
                                                .addGap(27, 27, 27)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(pecInput, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(pecLabel))
                                                .addGap(26, 26, 26)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(addressInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(addressLabel)))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(submitButton)
                                                        .addComponent(submitButton1))
                                                .addGap(17, 17, 17))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(cityInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(cityLabel))
                                                        .addComponent(provinceLabel)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                                .addComponent(step2LAbel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(monthLabel1)
                                                                .addGap(4, 4, 4)
                                                                .addComponent(monthDrop2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(dayLabel1)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(monthDrop3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(yearLabel1)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(yearDrop1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(105, 105, 105))))
        );
    }// </editor-fold>

    private void HcnInputActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        dconn.Registration("",Integer.parseInt(HcnInput.getText()),"",
                "","","yes","1991-1-1","male","","",
                "","");
    }

    private void pNameInputActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void phoneInputActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void famHistoryInputActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void allergyInputActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void genderInputActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void pecInputActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void addressInputActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void cityInputActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void submitButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        MainView mainView = (MainView) SwingUtilities.getWindowAncestor(this);
        mainView.setCard(0);
    }


    // Variables declaration - do not modify
    private javax.swing.JTextField HcnInput;
    private javax.swing.JTextField addressInput;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField allergyInput;
    private javax.swing.JLabel allergyLabel;
    private javax.swing.JComboBox<String> bdDayInput;
    private javax.swing.JComboBox<String> bdMonthInput;
    private javax.swing.JLabel bdMonthLabel;
    private javax.swing.JComboBox<String> bdYearInput;
    private javax.swing.JLabel birthdateLabel;
    private javax.swing.JTextField cityInput;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JLabel dayLabel;
    private javax.swing.JLabel dayLabel1;
    private javax.swing.JTextField famHistoryInput;
    private javax.swing.JLabel famHistoryLabel;
    private javax.swing.JTextField genderInput;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel hcnLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> monthDrop2;
    private javax.swing.JComboBox<String> monthDrop3;
    private javax.swing.JLabel monthLabel1;
    private javax.swing.JTextField pNameInput;
    private javax.swing.JLabel pNameLabel;
    private javax.swing.JLabel pageLabel;
    private javax.swing.JTextField pecInput;
    private javax.swing.JLabel pecLabel;
    private javax.swing.JTextField phoneInput;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JList<String> provinceInput;
    private javax.swing.JLabel provinceLabel;
    private javax.swing.JList<String> smokerInput;
    private javax.swing.JLabel smokerLabel;
    private javax.swing.JLabel step1Label;
    private javax.swing.JLabel step2LAbel;
    private javax.swing.JButton submitButton;
    private javax.swing.JButton submitButton1;
    private javax.swing.JComboBox<String> yearDrop1;
    private javax.swing.JLabel yearLabel;
    private javax.swing.JLabel yearLabel1;
    private Create_DB dconn;
    // End of variables declaration
}
