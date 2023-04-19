# Healthcare Database Management System

### Overview
This work was completed as a group project.
We created a stand-alone application that was coded in java and uses a MySQL database to manage the data and relations.  The data is manipulated by users through a java-built GUI that directly interfaces with the SQL database.  The java code is primarily composed of GUI code that passes and retrieves information from the user as well as functions that execute the required queries, inserts, updates and deletes.
Much of the relational functionality and data quality enforcement resides within the SQL database through foreign keys, attribute data types, cascading and triggers.  Triggers were used to automatically create bills with an associated cost when a procedure, prescription, lab test or doctor visit is created.  Foreign keys and cascading ensure data consistency and integrity when performing SQL operations.

### Project Design
Types of Users and Functionalities

#### Guests / New Patient:
A first-time visitor can register himself or herself as a patient of the hospital. The visitor will fill in personal details and medical history. Also, the patient can include emergency contacts to his or her profile.  

 
#### Admin (non-medical staff)
The admin Is responsible for managing medical appointments for patients. The admin can create, view, update and delete appointments. The admin can also register a patient. In addition, the admin can view all hospital personnel and their profile details. Finally, the admin can search and view all patients in the hospital management system.  

#### Medical Staff
There four types of medical personnels in the hospital system: Nurse, Generalist Doctor, Specialist Doctor, and Laboratory Technician
 
#### Nurse
The nurse is a medical staff that can only search and view patient records so as to assist patients and doctors. The nurse cannot make any changes to the profile of a patient or to the medical documents.

 
#### Generalist Doctor
The generalist doctor can manage the diagnosis of a patient. Using the patient’s healthcare number and name, the generalist doctor can create a medical diagnosis for a patient which includes medical notes and resolution status of the purpose of the patient’s visit. The medical doctor can also view, update and delete an existing diagnosis document. A laboratory test can also be created for a patient and the test status viewed. However, the doctor cannot update the status of the test result because this is the sole responsibility of the laboratory technician. Finally, the doctor can manage drug prescriptions for a patient. This includes creating, updating, deleting and viewing drug prescriptions.


#### Specialist Doctor
This user type is for a doctor that is specialized in a medical field such as a surgeon. Like a generalist doctor, a specialist doctor can create, update, delete and view a medical diagnosis document regarding a patient. The specialist doctor can also indicate the type of medical procedure performed (special examination or surgery), the resolution status of the procedure and if anesthetic was used during the procedure. Finally, the specialist doctor can request, delete and view laboratory tests for patients. Like the generalist doctor, medical tests cannot be updated.


#### Laboratory Technician
The laboratory technician is solely responsible for updating the results of a laboratory test that has been requested by a doctor. The lab technician cannot create or delete laboratory test requests because that is the responsibility of the doctors.

### Contributors
- [Samuel Sofela](https://github.com/sofels)
- [Chris DiMattia](https://github.com/chd-vicis)
- [Sam Rainbow](https://github.com/SMRain10)
