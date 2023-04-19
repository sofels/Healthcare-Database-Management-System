package Controller;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;



public class Create_DB {

    static final String DB_URL = "jdbc:mysql://localhost:3306?allowMultiQueries=true";
    static final String USER = "root";
    static final String PASS = "ENSF608Rainbow";

    // Returns the maximum document ID for diagnosis doucment
    public int maxDocID() {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {
            Statement stmt_use = conn.createStatement();
            stmt_use.executeUpdate("use HOSPITAL");

            Statement stmt = conn.createStatement();
            String querey = "SELECT MAX(DocumentID) FROM DIAGNOSIS";

            ResultSet rs = stmt.executeQuery(querey);

            rs.next();
            return rs.getInt("MAX(DocumentID)");

        } catch (SQLIntegrityConstraintViolationException e) {
            // Handle duplicate primary key error
            System.out.println("update failed");

            return -1;
        } catch (SQLException e) {
            e.printStackTrace();

            return -1;
        }

    }

    public int maxAppointmentID() {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {
            Statement stmt_use = conn.createStatement();
            stmt_use.executeUpdate("use HOSPITAL");

            Statement stmt = conn.createStatement();
            String querey = "SELECT MAX(ConfirmationID) FROM APPOINTMENT";

            ResultSet rs = stmt.executeQuery(querey);

            rs.next();
            return rs.getInt("MAX(ConfirmationID)");

        } catch (SQLIntegrityConstraintViolationException e) {
            // Handle duplicate primary key error
            System.out.println("update failed");

            return -1;
        } catch (SQLException e) {
            e.printStackTrace();

            return -1;
        }

    }

        // returns an array for routine checkups
    public Object[][] searcAlldiagnosis(String docId, String name, String healthCareNum) {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {
            Statement stmt_use = conn.createStatement();
            stmt_use.executeUpdate("use HOSPITAL");

            Statement stmt = conn.createStatement();

            String querey = "select distinct DocumentID, Notes, Pname, Allergies, Familyhistory, Smoker, BirthDate, " +
                    "Pre_exisiting_Conditions, Notes, Resolved from patient, diagnosis where patient.HealthCareNum = " +
                    "diagnosis.healthcarenum ";
            String docIDsearch = " and DocumentID like ";
            String nameSearh = " and Pname like ";
            String healthCareNumSearch = " and patient.HealthCareNum like";
            ;

            if (docId != "") {
                docIDsearch += "'%" + docId + "%'";
                querey += docIDsearch;
            }
            if (name != "") {
                nameSearh += "'%" + name + "%'";
                querey += nameSearh;
            }
            if (healthCareNum != "") {
                healthCareNumSearch += "'%" + healthCareNum + "%'";
                querey += healthCareNumSearch;
            }

            ResultSet rs = stmt.executeQuery(querey);
            ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
            while (rs.next()) {
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(rs.getString("DocumentID"));
                temp.add(rs.getString("Notes"));
                temp.add(rs.getString("Resolved"));
                temp.add(rs.getString("Pname"));
                temp.add(rs.getString("Allergies"));
                temp.add(rs.getString("Familyhistory"));
                temp.add(rs.getString("Smoker"));
                temp.add(rs.getString("BirthDate"));
                temp.add(rs.getString("Pre_exisiting_Conditions"));
                

                results.add(temp);
            }

            Object[][] objectArray = new Object[results.size()][];

            for (int i = 0; i < results.size(); i++) {
                ArrayList<String> innerList = results.get(i);
                Object[] innerArray = new Object[innerList.size()];
                for (int j = 0; j < innerList.size(); j++) {
                    innerArray[j] = innerList.get(j);
                }
                objectArray[i] = innerArray;
            }

            return objectArray;

        } catch (SQLIntegrityConstraintViolationException e) {
            // Handle duplicate primary key error
            System.out.println("update failed");

            return null;
        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }

    }

    // updates a single routine checkup document
    public String UpdateRoutineCheckUp(String notes, String resolved, String docID) {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {
            Statement stmt_use = conn.createStatement();
            stmt_use.executeUpdate("use HOSPITAL");

            String table = "DIAGNOSIS";


            if(!(notes.equals(""))){
                String sql = "update  " + table
                    + " SET Notes= '" + notes + "'  where DocumentID = " + String.valueOf(docID);
                    Statement stmt = conn.prepareStatement(sql);


            stmt.executeUpdate(sql);

            }


            if(!(resolved.equals(""))){
                String sql = "update  " + table
                    + " SET Resolved = '" + resolved  +"' where DocumentID = " + String.valueOf(docID);
                    Statement stmt = conn.prepareStatement(sql);



                    stmt.executeUpdate(sql);

            }


            return null;

        } catch (SQLIntegrityConstraintViolationException e) {
            // Handle duplicate primary key error
            System.out.println("update failed");

            return "exists";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    // inserts a routine checkup document
    public void InsertRoutineCheckUp(String notes, int healthCareNum, String resolved, String medicalSSN) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {

            Statement stmt = conn.createStatement();
            stmt.executeUpdate("use HOSPITAL");

            String table = "DIAGNOSIS";
            String docType = "Routine_Checkup";
            int docNum = maxDocID() + 1;

            String sql = " insert into " + table + " (DocumentID, HealthCareNum, Notes, Resolved, DocType, Medical_SSN)"
                    + " values (?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setInt(1, docNum);
            preparedStmt.setInt(2, healthCareNum);
            preparedStmt.setString(3, notes);
            preparedStmt.setString(4, resolved);
            preparedStmt.setString(5, docType);
            preparedStmt.setString(6, medicalSSN);

            preparedStmt.execute();
            conn.close();

        } catch (SQLIntegrityConstraintViolationException e) {
            // Handle duplicate primary key error
            System.out.println("Insert failed: Primary key already exists");
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    // deletes a routine checkup document
    public void DeleteRoutineCheckUp(int docID) {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {
            Statement stmt_use = conn.createStatement();
            stmt_use.executeUpdate("use HOSPITAL");

            String table = "DIAGNOSIS";
            String sql = "delete from " + table + " where DocumentID= ? and DocType = 'Routine_Checkup'";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, docID);

            stmt.execute();

        } catch (SQLIntegrityConstraintViolationException e) {
            // Handle duplicate primary key error
            System.out.println("update failed");

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

   // inserts a lab test document
    public void InsertLabTest(String notes, int healthCareNum, String testType, String medicalSSN) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {

            Statement stmt = conn.createStatement();
            stmt.executeUpdate("use HOSPITAL");

            String table = "DIAGNOSIS";
            String docType = "Lab_Test";

            int docNum = maxDocID() + 1;

            String sql = " insert into " + table
                    + " (DocumentID, HealthCareNum, Notes, DocType, TestType, Medical_SSN)"
                    + " values (?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setInt(1, docNum);
            preparedStmt.setInt(2, healthCareNum);
            preparedStmt.setString(3, notes);
            preparedStmt.setString(4, docType);
            preparedStmt.setString(5, testType);
            preparedStmt.setString(6, medicalSSN);

            preparedStmt.execute();


        } catch (SQLIntegrityConstraintViolationException e) {
            // Handle duplicate primary key error
            System.out.println("Insert failed: Primary key already exists");

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }
    //SR
    public Object[][] searchLabTest(String docId, String healthCareNum) {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {
            Statement stmt_use = conn.createStatement();
            stmt_use.executeUpdate("use HOSPITAL");

            Statement stmt = conn.createStatement();

            String querey = "select distinct DocumentID, patient.HealthCareNum, Pname, TestType, Notes, Results from patient, diagnosis where patient.HealthCareNum = diagnosis.healthcarenum and DocType = 'Lab_Test'";
            String docIDsearch = "and DocumentID like ";
//            String nameSearh = "and Pname like ";
            String healthCareNumSearch = "and patient.HealthCareNum like";
            ;

            if (docId != "") {
                docIDsearch += "'%" + docId + "%'";
                querey += docIDsearch;
            }
//            if (name != "") {
//                nameSearh += "'%" + name + "%'";
//                querey += nameSearh;
//            }
            if (healthCareNum != "") {
                healthCareNumSearch += "'%" + healthCareNum + "%'";
                querey += healthCareNumSearch;
            }

            ResultSet rs = stmt.executeQuery(querey);
            ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
            while (rs.next()) {
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(rs.getString("DocumentID"));
                temp.add(rs.getString("HealthCareNum"));
                temp.add(rs.getString("Pname"));
                temp.add(rs.getString("TestType"));
                temp.add(rs.getString("Notes"));
                temp.add(rs.getString("Results"));

                results.add(temp);
            }

            Object[][] objectArray = new Object[results.size()][];

            for (int i = 0; i < results.size(); i++) {
                ArrayList<String> innerList = results.get(i);
                Object[] innerArray = new Object[innerList.size()];
                for (int j = 0; j < innerList.size(); j++) {
                    innerArray[j] = innerList.get(j);
                }
                objectArray[i] = innerArray;
            }

            return objectArray;

        } catch (SQLIntegrityConstraintViolationException e) {
            // Handle duplicate primary key error
            System.out.println("update failed");

            return null;
        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }

    }

    //CDD
    public Object[][] searchLabTest(String docId, String name, String healthCareNum) {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {
            Statement stmt_use = conn.createStatement();
            stmt_use.executeUpdate("use HOSPITAL");

            Statement stmt = conn.createStatement();

            String querey = "select distinct DocumentID, Pname, Allergies, Notes, Results, TestType from patient, diagnosis where patient.HealthCareNum = diagnosis.healthcarenum and DocType = 'Lab_Test'";
            String docIDsearch = "and DocumentID like ";
            String nameSearh = "and Pname like ";
            String healthCareNumSearch = "and patient.HealthCareNum like";
            ;

            if (docId != "") {
                docIDsearch += "'%" + docId + "%'";
                querey += docIDsearch;
            }
            if (name != "") {
                nameSearh += "'%" + name + "%'";
                querey += nameSearh;
            }
            if (healthCareNum != "") {
                healthCareNumSearch += "'%" + healthCareNum + "%'";
                querey += healthCareNumSearch;
            }

            ResultSet rs = stmt.executeQuery(querey);
            ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
            while (rs.next()) {
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(rs.getString("DocumentID"));
                temp.add(rs.getString("Pname"));
                temp.add(rs.getString("Notes"));
                temp.add(rs.getString("Results"));
                temp.add(rs.getString("TestType"));

                results.add(temp);
            }

            Object[][] objectArray = new Object[results.size()][];

            for (int i = 0; i < results.size(); i++) {
                ArrayList<String> innerList = results.get(i);
                Object[] innerArray = new Object[innerList.size()];
                for (int j = 0; j < innerList.size(); j++) {
                    innerArray[j] = innerList.get(j);
                }
                objectArray[i] = innerArray;
            }

            return objectArray;

        } catch (SQLIntegrityConstraintViolationException e) {
            // Handle duplicate primary key error
            System.out.println("update failed");

            return null;
        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }

    }

    //CDD
   public void DeleteLabTest(int docID) {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {
            Statement stmt_use = conn.createStatement();
            stmt_use.executeUpdate("use HOSPITAL");

            String table = "DIAGNOSIS";
            String sql = "delete from " + table + " where DocumentID= ? and DocType = 'Lab_Test'";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, docID);

            stmt.execute();

        } catch (SQLIntegrityConstraintViolationException e) {
            // Handle duplicate primary key error
            System.out.println("update failed");

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

   //SR
    public String UpdateLabTest(Integer healthCareNumber, Integer documentID, String result) {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {
            Statement stmt_use = conn.createStatement();
            stmt_use.executeUpdate("use HOSPITAL");

            String table = "DIAGNOSIS";

            String sql = "update  " + table
                    + " SET Results = ? where DocumentID = ? and HealthCareNum = ? and DocType = 'Lab_Test'";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, result);
            stmt.setInt(2, documentID);
            stmt.setInt(3, healthCareNumber);

            stmt.execute();

            return null;

        } catch (SQLIntegrityConstraintViolationException e) {
            // Handle duplicate primary key error
            System.out.println("update failed");

            return "exists";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }


       public void DeleteEmergencyContact(int healthCareNum, String cName) {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {
            Statement stmt_use = conn.createStatement();
            stmt_use.executeUpdate("use HOSPITAL");

            String table = "Emergency_contact";
            String sql = "delete from " + table + " where HealthCareNum = ? and Cname = ? ";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, healthCareNum);
            stmt.setString(2, cName);

            stmt.execute();

        } catch (SQLIntegrityConstraintViolationException e) {
            // Handle duplicate primary key error
            System.out.println("update failed");

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }


    public Object[][] searchEmergencyContact(String healthCareNum) {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {
            Statement stmt_use = conn.createStatement();
            stmt_use.executeUpdate("use HOSPITAL");

            Statement stmt = conn.createStatement();

            String querey = "select distinct HealthCareNum, Cname, PhoneNum, Relationship from Emergency_contact ";
            String docIDsearch = " where HealthCareNum like ";


            if (healthCareNum != "") {
                docIDsearch += "'%" + healthCareNum + "%'";
                querey += docIDsearch;
            }
   

            ResultSet rs = stmt.executeQuery(querey);
            ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
            while (rs.next()) {
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(rs.getString("HealthCareNum"));
                temp.add(rs.getString("Cname"));
                temp.add(rs.getString("PhoneNum"));
                temp.add(rs.getString("Relationship"));

                results.add(temp);
            }

            Object[][] objectArray = new Object[results.size()][];

            for (int i = 0; i < results.size(); i++) {
                ArrayList<String> innerList = results.get(i);
                Object[] innerArray = new Object[innerList.size()];
                for (int j = 0; j < innerList.size(); j++) {
                    innerArray[j] = innerList.get(j);
                }
                objectArray[i] = innerArray;
            }

            return objectArray;

        } catch (SQLIntegrityConstraintViolationException e) {
            // Handle duplicate primary key error
            System.out.println("update failed");

            return null;
        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }

    }





    public void addEmergencyContact(int healthCareNum, String phone, String name, String relationship) {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {

            Statement stmt = conn.createStatement();
            stmt.executeUpdate("use HOSPITAL");




            String sql = " insert into Emergency_contact "
                    + " (HealthCareNum, Cname, PhoneNum, Relationship)"
                    + " values (?, ?, ?, ?)";



            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            if (phone.equals("")) {
                preparedStmt.setString(3, null);
            } else {
                preparedStmt.setString(3, phone);
            }
            preparedStmt.setInt(1, healthCareNum);
            preparedStmt.setString(2, name);
            preparedStmt.setString(4, relationship);

            preparedStmt.execute();

        } catch (SQLIntegrityConstraintViolationException e) {
            // Handle duplicate primary key error
            System.out.println("Insert failed: Primary key already exists");

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }
    
    
    
    
    public void Registration(String name, int healthCareNum, String phone, String allergies, String familyHistory,
            String smoker, String birthDate, String gender,
            String preExistingConditions, String city, String province, String streetAddress) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {

            String phoneI = null;
            String birthDateNull = null;

            if (birthDate != "") {
                birthDateNull = birthDate;
            }

            Statement stmt = conn.createStatement();
            stmt.executeUpdate("use HOSPITAL");

            String table = "Patient";

            String sql = " insert into " + table
                    + " (HealthCareNum, Pname, PhoneNum, Allergies, Familyhistory, Smoker, BirthDate, Gender, Pre_exisiting_Conditions, City, Province, StreetAddress)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setInt(1, healthCareNum);
            preparedStmt.setString(2, name);

            if (phone.equals("")) {
                preparedStmt.setString(3, null);
            } else {
                preparedStmt.setString(3, phone);
            }

            if (allergies.equals("")) {
                preparedStmt.setString(4, null);
            } else {
                preparedStmt.setString(4, allergies);
            }

            if (familyHistory.equals("")) {
                preparedStmt.setString(5, null);
            } else {
                preparedStmt.setString(5, familyHistory);
            }


            if (smoker == (null)) {
                preparedStmt.setString(6, "unknown");
            } else {
                preparedStmt.setString(6, smoker);
            }

            if (gender == (null)) {
                preparedStmt.setString(8, "unknown");
            } else {
                preparedStmt.setString(8, gender);
            }


            preparedStmt.setString(7, birthDateNull);




            if (preExistingConditions.equals("")) {
                preparedStmt.setString(9, null);
            } else {
                preparedStmt.setString(9, preExistingConditions);
            }

            if (streetAddress.equals("")) {
                preparedStmt.setString(12, null);
            } else {
                preparedStmt.setString(12, streetAddress);
            }

            if (city.equals("")) {
                preparedStmt.setString(10, null);
            } else {
                preparedStmt.setString(10, city);
            }

            preparedStmt.setString(11, province);

            preparedStmt.execute();
            conn.close();

        } catch (SQLIntegrityConstraintViolationException e) {
            // Handle duplicate primary key error
            System.out.println("Insert failed: Primary key already exists");
            JOptionPane.showMessageDialog(null, "Insert failed: Primary key already exists.");

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }
    
    


   

    public void AdminRegistration(String name, int healthCareNum, String phone, String allergies, String familyHistory,
            String smoker, String birthDate, String gender,
            String preExistingConditions, String city, String province, String streetAddress, int admintSSN) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {

            Statement stmt = conn.createStatement();
            stmt.executeUpdate("use HOSPITAL");

            String phoneI = null;

            if (phone != "") {
                phoneI = phone;
            }

            String table = "Patient";

            String sql = " insert into " + table
                    + " (HealthCareNum, Pname, PhoneNum, Allergies, Familyhistory, Smoker, BirthDate, Gender, Pre_exisiting_Conditions, City, Province, StreetAddress, AdminSSN)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setInt(1, healthCareNum);
            preparedStmt.setString(2, name);
            preparedStmt.setString(3, phoneI);
            preparedStmt.setString(4, allergies);
            preparedStmt.setString(5, familyHistory);
            preparedStmt.setString(6, smoker);
            preparedStmt.setString(7, birthDate);
            preparedStmt.setString(8, gender);
            preparedStmt.setString(9, preExistingConditions);
            preparedStmt.setString(10, city);
            preparedStmt.setString(11, province);
            preparedStmt.setString(12, streetAddress);
            preparedStmt.setInt(13, admintSSN);

            preparedStmt.execute();
            conn.close();

        } catch (SQLIntegrityConstraintViolationException e) {
            // Handle duplicate primary key error
            System.out.println("Insert failed: Primary key already exists");

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }
public String UpdatePrescription(int quantity, String drugName, int docID) {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {
            Statement stmt_use = conn.createStatement();
            stmt_use.executeUpdate("use HOSPITAL");

            String sql = "update  DRUG_INFO as d inner join DIAGNOSIS as g on d.DocumentID = g.DocumentID " +
                    "SET d.Quantity = ?, d.DrugName = ? where d.DocumentID = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);

            // String sql = "update insurance set companyid = 'asf' , taxcode = 'asdf',
            // insurancerate = 0.7 where companyid = 'testcomp'";

            stmt.setInt(1, quantity);
            stmt.setString(2, drugName);
            stmt.setInt(3, docID);

            stmt.execute();

            return null;

        } catch (SQLIntegrityConstraintViolationException e) {
            // Handle duplicate primary key error
            System.out.println("update failed");

            return "exists";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public void DeletePrescription(int docID) {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {
            Statement stmt_use = conn.createStatement();
            stmt_use.executeUpdate("use HOSPITAL");

            String table = "DIAGNOSIS";
            String sql = "delete from " + table + " where DocumentID= ? and DocType = 'Prescription'";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, docID);

            stmt.execute();

        } catch (SQLIntegrityConstraintViolationException e) {
            // Handle duplicate primary key error
            System.out.println("update failed");

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    public Object[][] searchPrescription(String docId, String name, String healthCareNum, String drugName) {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {
            Statement stmt_use = conn.createStatement();
            stmt_use.executeUpdate("use HOSPITAL");

            Statement stmt = conn.createStatement();

            String querey = "select distinct Quantity, DrugName, DRUG_INFO.DocumentID, patient.pname, Notes from DRUG_INFO, diagnosis, patient where DRUG_INFO.DocumentID = DIAGNOSIS.DocumentID and DIAGNOSIS.HealthCareNum = patient.HealthCareNum ";
            String docIDsearch = "and Diagnosis.DocumentID like ";
            String nameSearh = "and patient.Pname like ";
            String healthCareNumSearch = "and patient.HealthCareNum like ";
            String drugNameSearch = "and DRUG_INFO.drugName like ";
            ;

            if (docId != "") {
                docIDsearch += "'%" + docId + "%'";
                querey += docIDsearch;
            }
            if (name != "") {
                nameSearh += "'%" + name + "%'";
                querey += nameSearh;
            }
            if (healthCareNum != "") {
                healthCareNumSearch += "'%" + healthCareNum + "%'";
                querey += healthCareNumSearch;
            }
            if (drugName != "") {
                drugNameSearch += "'%" + drugName + "%'";
                querey += drugNameSearch;
            }
            System.out.println(querey);

            ResultSet rs = stmt.executeQuery(querey);
            ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
            while (rs.next()) {
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(rs.getString("Quantity"));
                temp.add(rs.getString("DrugName"));
                temp.add(rs.getString("DocumentID"));
                temp.add(rs.getString("PName"));
                temp.add(rs.getString("Notes"));

                results.add(temp);
            }

            Object[][] objectArray = new Object[results.size()][];

            for (int i = 0; i < results.size(); i++) {
                ArrayList<String> innerList = results.get(i);
                Object[] innerArray = new Object[innerList.size()];
                for (int j = 0; j < innerList.size(); j++) {
                    innerArray[j] = innerList.get(j);
                }
                objectArray[i] = innerArray;
            }

            return objectArray;

        } catch (SQLIntegrityConstraintViolationException e) {
            // Handle duplicate primary key error
            System.out.println("update failed");

            return null;
        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }

    }

    public void InsertPrescription(int healthCareNum, int quantity,
            String drugName, String medicalSSN) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {

            Statement stmt = conn.createStatement();
            stmt.executeUpdate("use HOSPITAL");

            String table = "DIAGNOSIS";
            String docType = "Prescription";

            int docNum = maxDocID() + 1;

            String sql = " insert into " + table
                    + " (DocumentID, HealthCareNum, DocType, Medical_SSN)"
                    + " values (?, ?, ?, ?)";

            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setInt(1, docNum);
            preparedStmt.setInt(2, healthCareNum);
            preparedStmt.setString(3, docType);
            preparedStmt.setString(4, medicalSSN);

            preparedStmt.execute();

            String sql2 = " insert into DRUG_INFO"
                    + " (DocumentID, Quantity, DrugName)"
                    + " values (?, ?, ?)";

            PreparedStatement preparedStmt2 = conn.prepareStatement(sql2);
            preparedStmt2.setInt(1, docNum);
            preparedStmt2.setInt(2, quantity);
            preparedStmt2.setString(3, drugName);
            preparedStmt2.execute();

        } catch (SQLIntegrityConstraintViolationException e) {
            // Handle duplicate primary key error
            System.out.println("Insert failed: Primary key already exists");

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    
    public void InsertAppointment(String healthCareNo, String doctorSSN, String adminSSN, String hopsitalName, String ward,
            String roomNo, String appDate, String reasonForVisit) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {

            Statement stmt = conn.createStatement();
            stmt.executeUpdate("use HOSPITAL");

            String table = "APPOINTMENT";
            int confirmationID = maxAppointmentID() + 1;

            String sql = " insert into " + table
                    + " (confirmationid, appt_date, reasonforvisit)"
                    + " values (?, ?, ?)";

            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setInt(1, confirmationID);
            preparedStmt.setString(2, appDate);
            preparedStmt.setString(3, reasonForVisit);

            preparedStmt.execute();

            String sql_2 = " insert into CONDUCTED_IN"
                    + " (ConfirmationID, Hospital, RoomNo, Ward)"
                    + " values (?, ?, ?, ?)";

            PreparedStatement preparedStmt_2 = conn.prepareStatement(sql_2);
            preparedStmt_2.setInt(1, confirmationID);
            preparedStmt_2.setString(2, hopsitalName);
            preparedStmt_2.setString(3, roomNo);
            preparedStmt_2.setString(4, ward);
            preparedStmt_2.execute();

            String sql_3 = " insert into APPT_SCHEDULE"
                    + " (HealthCareNo, AdminSSN, MedicalSSN, ConfirmationID)"
                    + " values (?, ?, ?, ?)";

            PreparedStatement preparedStmt_3 = conn.prepareStatement(sql_3);
            preparedStmt_3.setString(1, healthCareNo);
            preparedStmt_3.setString(2, adminSSN);
            preparedStmt_3.setString(3, doctorSSN);
            preparedStmt_3.setInt(4, confirmationID);
            preparedStmt_3.execute();

        } catch (SQLIntegrityConstraintViolationException e) {
            // Handle duplicate primary key error
            System.out.println("Insert failed: Primary key already exists");
            System.out.println(e.getMessage());

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }
public Object[][] searchAppointment(String name, String healthCareNum, String date, String confirmationID, String reason) {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {
            Statement stmt_use = conn.createStatement();
            stmt_use.executeUpdate("use HOSPITAL");

            Statement stmt = conn.createStatement();

            String querey = "select distinct appointment.ConfirmationID, CONDUCTED_IN.hospital ,CONDUCTED_IN.Ward " +
                    ",CONDUCTED_IN.RoomNo, appointment.Appt_Date, patient.Pname, patient.HealthCareNum," +
                    "APPOINTMENT.ReasonForVisit "
                    + "from appointment, CONDUCTED_IN, APPT_SCHEDULE, patient  WHERE appointment.ConfirmationID = " +
                    "CONDUCTED_IN.ConfirmationID and APPT_SCHEDULE.ConfirmationID = appointment.ConfirmationID and " +
                    "patient.HealthCareNum = APPT_SCHEDULE.HealthCareNo ";
            String confirmationIDsearch = "and APPT_SCHEDULE.confirmationID like ";
            String nameSearh = "and patient.Pname like ";
            String healthCareNumSearch = "and patient.HealthCareNum like ";
            String reasonSearch = "and APPOINTMENT.ReasonForVisit like ";

            if (confirmationID != "") {
                confirmationIDsearch += "'%" + confirmationID + "%'";
                querey += confirmationIDsearch;
            }
            if (name != "") {
                nameSearh += "'%" + name + "%'";
                querey += nameSearh;
            }
            if (healthCareNum != "") {
                healthCareNumSearch += "'%" + healthCareNum + "%'";
                querey += healthCareNumSearch;
            }
            if (reason != "") {
                reasonSearch += "'%" + reason + "%'";
                querey += reasonSearch;
            }




            // if (date != "") {
            //     dateSearch += "'%" + date + "%'";
            //     querey += dateSearch;
            // }

            ResultSet rs = stmt.executeQuery(querey);
            ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
            while (rs.next()) {
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(rs.getString("ConfirmationID"));
                temp.add(rs.getString("Hospital"));
                temp.add(rs.getString("Ward"));
                temp.add(rs.getString("RoomNo"));
                temp.add(rs.getString("Appt_Date"));
                temp.add(rs.getString("Pname"));
                temp.add(rs.getString("HealthCareNum"));
                temp.add(rs.getString("ReasonForVisit"));

                results.add(temp);
            }

            Object[][] objectArray = new Object[results.size()][];

            for (int i = 0; i < results.size(); i++) {
                ArrayList<String> innerList = results.get(i);
                Object[] innerArray = new Object[innerList.size()];
                for (int j = 0; j < innerList.size(); j++) {
                    innerArray[j] = innerList.get(j);
                }
                objectArray[i] = innerArray;
            }

            return objectArray;

        } catch (SQLIntegrityConstraintViolationException e) {
            // Handle duplicate primary key error
            System.out.println("update failed");

            return null;
        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }

    }
    public void DeleteAppointment(String ConfirmationID) {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {
            Statement stmt_use = conn.createStatement();
            stmt_use.executeUpdate("use HOSPITAL");

            String table = "APPOINTMENT";
            String sql = "delete from " + table + " where ConfirmationID= ?";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, ConfirmationID);

            stmt.execute();

        } catch (SQLIntegrityConstraintViolationException e) {
            // Handle duplicate primary key error
            System.out.println("update failed");

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    public String UpdateAppointment(String hopsitalName, String ward,
            String roomNo, String appDate, String reasonForVisit, String confirmationID) {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {
            Statement stmt_use = conn.createStatement();
            stmt_use.executeUpdate("use HOSPITAL");

            Statement stmt_reason = conn.createStatement();
            String reasonForVisit_u = "";

            if(!(reasonForVisit.isEmpty())){
                reasonForVisit_u = "update APPOINTMENT SET  ReasonForVisit = '" +  reasonForVisit + "'" +  " where ConfirmationID = " + confirmationID;
                stmt_reason.executeUpdate(reasonForVisit_u);
            }

            Statement stmt_date = conn.createStatement();
            String date_u = "";

            if(!(appDate.isEmpty())){
                date_u = "update APPOINTMENT SET  Appt_Date = '" +  appDate + "'" + " where ConfirmationID = " + confirmationID;
                stmt_date.executeUpdate(date_u);
            }

             String appDate_q = "";
             String reasonForVisit_q = "";

             Statement stmt_new = conn.createStatement();

             if(!(appDate.isEmpty()) && reasonForVisit.isEmpty()){
                 appDate_q = " Appt_Date = " + appDate;
             } else if (!(appDate.isEmpty())){
                 appDate_q = " Appt_Date = " + appDate + ", ";
             }

             if(!(reasonForVisit.isEmpty())){
                 reasonForVisit_q = " ReasonForVisit = '" +  reasonForVisit + "'";
             }

             String querey = "update APPOINTMENT SET " + appDate_q + reasonForVisit_q + " where ConfirmationID = " + confirmationID;

             // String querey = "update APPOINTMENT SET ReasonForVisit = 'test' where ConfirmationID = " + confirmationID;

             if(!(appDate.isEmpty() && reasonForVisit.isEmpty())){
                 stmt_new.executeUpdate(querey);
             }


            return null;

        } catch (SQLIntegrityConstraintViolationException e) {
            // Handle duplicate primary key error

            return "exists";
        } catch (SQLException e) {
            return null;
        }

    }
    
    

    // ++++++++++++Samuel worked on this+++++++++++++++++
    public void InsertProcedure(String notes, int healthCareNum, String resolved,
            String procedureType, String anesthetic, String medicalSSN, String nurseSSN) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {

            Statement stmt = conn.createStatement();
            stmt.executeUpdate("use HOSPITAL");

            String table = "DIAGNOSIS";
            String docType = "Procedure";

            int docNum = maxDocID() + 1;

            String sql = " insert into " + table
                    + " (DocumentID, HealthCareNum, Notes, Resolved, DocType, ProcedureType, Anesthetic, Medical_SSN, Nurse_SSN)"
                    + " values (?, ?, ?, ?, ?,?,?,?,?)";

            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setInt(1, docNum);
            preparedStmt.setInt(2, healthCareNum);
            preparedStmt.setString(3, notes);
            preparedStmt.setString(4, resolved);
            preparedStmt.setString(5, docType);
            preparedStmt.setString(6, procedureType);
            preparedStmt.setString(7, anesthetic);
            preparedStmt.setString(8, medicalSSN);
            preparedStmt.setString(9, nurseSSN);

            preparedStmt.execute();
            conn.close();

        } catch (SQLIntegrityConstraintViolationException e) {
            // Handle duplicate primary key error
            System.out.println("Insert failed: Primary key already exists");

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }
    //+++++++++Samuel worked on this++++++++++++
    //only change was typo in method name
    public void DeleteProcedure(int docID) {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {
            Statement stmt_use = conn.createStatement();
            stmt_use.executeUpdate("use HOSPITAL");

            String table = "DIAGNOSIS";
            String sql = "delete from " + table + " where DocumentID= ? and DocType = 'Procedure'";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, docID);

            stmt.execute();

        } catch (SQLIntegrityConstraintViolationException e) {
            // Handle duplicate primary key error
            System.out.println("update failed");

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    //+++++++++Samuel worked on this++++++++++++
    //only change was typo in method name
    public String UpdateProcedure(String notes, String resolved, Integer healthCareNumber, Integer documentID,
            String procedureType, String anesthetic) {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {
            Statement stmt_use = conn.createStatement();
            stmt_use.executeUpdate("use HOSPITAL");

            String table = "DIAGNOSIS";

            String sql = "update  " + table
                    + " SET Notes= ? , Resolved = ? , ProcedureType = ?, Anesthetic = ? where DocumentID = ? and " +
                    "HealthCareNum = ? and DocType = 'Procedure'";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, notes);
            stmt.setString(2, resolved);
            stmt.setString(3, procedureType);
            stmt.setString(4, anesthetic);
            stmt.setInt(5, documentID);
            stmt.setInt(6, healthCareNumber);

            stmt.execute();

            return null;

        } catch (SQLIntegrityConstraintViolationException e) {
            // Handle duplicate primary key error
            System.out.println("update failed");

            return "exists";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    
  public Object[][] searchBill(String healthCareNum,String invoiceNo, String costingCode, String companyID) {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {
            Statement stmt_use = conn.createStatement();
            stmt_use.executeUpdate("use HOSPITAL");

            Statement stmt = conn.createStatement();

            String querey = "select  patient.HealthCareNum, Bill.InvoiceNo, CostingCode, CompanyID, Cost from Send_to, " +
                    "Bill, patient, DIAGNOSIS where Send_to.InvoiceNo = Bill.InvoiceNo " +
            " and Bill.InvoiceNo = DIAGNOSIS.DocumentID and DIAGNOSIS.HealthCareNum = patient.HealthCareNum ";
            String invoiceNosearch = " and Send_to.InvoiceNo like ";
            String costingCodeSearh = " and Send_to.CostingCode like ";
            String companyIDSearch = " and Send_to.CompanyID like ";
            String healthCareNumDSearch = " and DIAGNOSIS.HealthCareNum like ";

            if (invoiceNo != "") {
                invoiceNosearch += "'%" + invoiceNo + "%'";
                querey += invoiceNosearch;
            }
            if (costingCode != "") {
                costingCodeSearh += "'%" + costingCode + "%'";
                querey += costingCodeSearh;
            }
            if (companyID != "") {
                companyIDSearch += "'%" + companyID + "%'";
                querey += companyIDSearch;
            }
            if (healthCareNum != "") {
                healthCareNumDSearch += "'%" + healthCareNum + "%'";
                querey += healthCareNumDSearch;
            }

            ResultSet rs = stmt.executeQuery(querey + " order by Cost");
            ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
            while (rs.next()) {
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(rs.getString("HealthCareNum"));
                temp.add(rs.getString("invoiceNo"));
                temp.add(rs.getString("costingCode"));
                temp.add(rs.getString("companyID"));
                temp.add(rs.getString("cost"));

                results.add(temp);
            }

            Object[][] objectArray = new Object[results.size()][];

            for (int i = 0; i < results.size(); i++) {
                ArrayList<String> innerList = results.get(i);
                Object[] innerArray = new Object[innerList.size()];
                for (int j = 0; j < innerList.size(); j++) {
                    innerArray[j] = innerList.get(j);
                }
                objectArray[i] = innerArray;
            }

            return objectArray;

        } catch (SQLIntegrityConstraintViolationException e) {
            // Handle duplicate primary key error
            System.out.println("update failed");

            return null;
        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }

    }
    
    
    
    
    
    public Object[][] unresolvedPrescription() {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {
            Statement stmt_use = conn.createStatement();
            stmt_use.executeUpdate("use HOSPITAL");

            Statement stmt = conn.createStatement();

            String querey =     "select * from Pharmacy " +
                                "where Pname in ( "+
                                "select DIAGNOSIS.PharmName "+
                                "from DIAGNOSIS "+
                                "where Resolved = 'no' and DocType = 'Prescription') ";

            ResultSet rs = stmt.executeQuery(querey);
            ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
            while (rs.next()) {
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(rs.getString("Pname"));
                temp.add(rs.getString("StreetAddress"));
                temp.add(rs.getString("City"));
                temp.add(rs.getString("Province"));
                results.add(temp);
            }

            Object[][] objectArray = new Object[results.size()][];

            for (int i = 0; i < results.size(); i++) {
                ArrayList<String> innerList = results.get(i);
                Object[] innerArray = new Object[innerList.size()];
                for (int j = 0; j < innerList.size(); j++) {
                    innerArray[j] = innerList.get(j);
                }
                objectArray[i] = innerArray;
            }

            return objectArray;

        } catch (SQLIntegrityConstraintViolationException e) {
            // Handle duplicate primary key error
            System.out.println("update failed");

            return null;
        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }

    }

    


        
    public Object[][] printHospitalStaff() {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {
            Statement stmt_use = conn.createStatement();
            stmt_use.executeUpdate("use HOSPITAL");

            Statement stmt = conn.createStatement();

            String querey =     "select staff_name, RoleType, JobType, Department, Residency from HOSPITAL_STAFF";

            ResultSet rs = stmt.executeQuery(querey);
            ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
            while (rs.next()) {
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(rs.getString("staff_name"));
                temp.add(rs.getString("RoleType"));
                temp.add(rs.getString("JobType"));
                temp.add(rs.getString("Department"));
                temp.add(rs.getString("Residency"));
                results.add(temp);
            }

            Object[][] objectArray = new Object[results.size()][];

            for (int i = 0; i < results.size(); i++) {
                ArrayList<String> innerList = results.get(i);
                Object[] innerArray = new Object[innerList.size()];
                for (int j = 0; j < innerList.size(); j++) {
                    innerArray[j] = innerList.get(j);
                }
                objectArray[i] = innerArray;
            }

            return objectArray;

        } catch (SQLIntegrityConstraintViolationException e) {
            // Handle duplicate primary key error
            System.out.println("update failed");

            return null;
        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }

    }



public Object[][] printHospitalNumbers() {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {
            Statement stmt_use = conn.createStatement();
            stmt_use.executeUpdate("use HOSPITAL");

            Statement stmt = conn.createStatement();

            String querey =     "select count(*) as 'Staff Population', HOSPITAL_STAFF.HospitalID, HOSPITAL.hosp_name as 'Hospital Name' from HOSPITAL_STAFF, HOSPITAL where HOSPITAL_STAFF.HospitalID = HOSPITAL.HospitalID group by (HospitalID)";
           

            System.out.println(querey);

            ResultSet rs = stmt.executeQuery(querey);
            ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
            while (rs.next()) {
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(rs.getString("Staff Population"));
                temp.add(rs.getString("HospitalID"));
                temp.add(rs.getString("Hospital Name"));

                results.add(temp);
            }

            Object[][] objectArray = new Object[results.size()][];

            for (int i = 0; i < results.size(); i++) {
                ArrayList<String> innerList = results.get(i);
                Object[] innerArray = new Object[innerList.size()];
                for (int j = 0; j < innerList.size(); j++) {
                    innerArray[j] = innerList.get(j);
                }
                objectArray[i] = innerArray;
            }

            return objectArray;

        } catch (SQLIntegrityConstraintViolationException e) {
            // Handle duplicate primary key error
            System.out.println("update failed");

            return null;
        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }

    }





    public Object[][] searchPatient(String healthCareNum,String name, String city, String familyHistory) {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {
            Statement stmt_use = conn.createStatement();
            stmt_use.executeUpdate("use HOSPITAL");

            Statement stmt = conn.createStatement();

            String querey = "select healthcarenum, pname, city, familyhistory, Birthdate, gender, smoker, allergies from patient where 1=1 ";
            String healthCareNumsearch = " and healthcarenum like ";
            String nameSearch = " and pname like ";
            String citySearch = " and city like ";
            String familyHistorySearch = " and familyhistory like ";

            if (!healthCareNum.isEmpty()) {
                healthCareNumsearch += "'%" + healthCareNum + "%'";
                querey += healthCareNumsearch;
            }
            if (!name.isEmpty()) {
                nameSearch += "'%" + name + "%'";
                querey += nameSearch;
            }
            if (!city.isEmpty()) {
                citySearch += "'%" + city + "%'";
                querey += citySearch;
            }
            if (!familyHistory.isEmpty()) {
                familyHistorySearch += "'%" + familyHistory + "%'";
                querey += familyHistorySearch;
            }

            ResultSet rs = stmt.executeQuery(querey );
            ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
            while (rs.next()) {
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(rs.getString("healthcarenum"));
                temp.add(rs.getString("pname"));
                temp.add(rs.getString("city"));
                temp.add(rs.getString("familyhistory"));
                temp.add(rs.getString("Birthdate"));
                temp.add(rs.getString("gender"));
                temp.add(rs.getString("smoker"));
                temp.add(rs.getString("allergies"));



                results.add(temp);
            }

            Object[][] objectArray = new Object[results.size()][];

            for (int i = 0; i < results.size(); i++) {
                ArrayList<String> innerList = results.get(i);
                Object[] innerArray = new Object[innerList.size()];
                for (int j = 0; j < innerList.size(); j++) {
                    innerArray[j] = innerList.get(j);
                }
                objectArray[i] = innerArray;
            }

            return objectArray;

        } catch (SQLIntegrityConstraintViolationException e) {
            // Handle duplicate primary key error
            System.out.println("update failed");

            return null;
        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }

    }


    
}

