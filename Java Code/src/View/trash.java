//package View;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class trash {
//
//    extends JPanel{
//
//        private JTextField healthCareNumField;
//        private JTextField searchField;
//        private JLabel healthCareNumLabel;
//        private JButton healthCareNumButton;
//        private JButton searchButton;
//        private JTable table;
//        private JScrollPane scrollPane;
//
//    public PatientView() {
//
//            // create UI components
//            JLabel searchLabel = new JLabel("Appointment Booking");
//            healthCareNumLabel = new JLabel("Step 1: Enter Health Care Number");
//            healthCareNumField = new JTextField(20);
//            healthCareNumButton = new JButton("Search");
//
//
////        searchField = new JTextField(20);
////        searchButton = new JButton("Search");
//            table = new JTable();
//            scrollPane = new JScrollPane(table);
//
//            // add event listeners
//            healthCareNumButton.addActionListener(e -> search());
//
//
//            // create layout
//            setLayout(new BorderLayout());
//            setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//
//            // create sub-panels
//            JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
//            topPanel.add(searchLabel);
//            topPanel.add(healthCareNumField);
//            topPanel.add(healthCareNumLabel);
//            topPanel.add(healthCareNumButton);
//
//            // add sub-panels to main panel
//            add(topPanel, BorderLayout.NORTH);
//            add(scrollPane, BorderLayout.CENTER);
//        }
//
//        private void search() {
//        }
//
//
//}

//        jTable.setModel(new javax.swing.table.DefaultTableModel(
//                new Object [][] {
//                        {null, null, null, null, null, null, null, null, null, null, null},
//                        {null, null, null, null, null, null, null, null, null, null, null},
//                        {null, null, null, null, null, null, null, null, null, null, null},
//                        {null, null, null, null, null, null, null, null, null, null, null}
//                },
//                new String [] {
//                        "DocumentID", "Date", "Notes", "Resolved", "TestType", "Results", "Tech_SSN", "Doc Type",
//                        "Procedure Type", "Anesthetic", "Pharmacy Name"
//                }
//        ));
