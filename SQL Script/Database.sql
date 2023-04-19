DROP DATABASE IF EXISTS HOSPITAL;
CREATE DATABASE HOSPITAL; 
USE HOSPITAL;

-- select* from Patient;


DROP TABLE IF EXISTS Government;
CREATE TABLE Government (
	CostingCode				varchar(30)	not null,
	Department				varchar(30),
	Province				varchar(2),
	primary key (CostingCode)
);

DROP TABLE IF EXISTS Insurance;
CREATE TABLE Insurance (
	CompanyID			varchar(30) not null,
	TaxCode				varchar(30) not null,
	InsuranceRate		float(5) not null,
	primary key (CompanyID)
);

DROP TABLE IF EXISTS Send_to;
CREATE TABLE Send_to (
	InvoiceNo					int(20) not null,
	CostingCode					varchar(30),
	CompanyID					varchar(30),
	primary key (InvoiceNo, CostingCode, CompanyID)
);


DROP TABLE IF EXISTS Bill;
CREATE TABLE Bill (
	InvoiceNo					int(20) not null,
	CoveredbyInsurance			float(4) not null,
    Cost					int(9) not null,
	primary key (InvoiceNo)
);

DROP TABLE IF EXISTS Emergency_contact;
CREATE TABLE Emergency_contact (
	HealthCareNum			int(9) not null,
	Cname					varchar(100) not null,
	PhoneNum				bigint(15),
    Relationship			varchar(30),

	primary key (HealthCareNum, Cname)
);

DROP TABLE IF EXISTS Patient;
CREATE TABLE Patient (
	HealthCareNum					int(9) not null,
    Pname							varchar(30) not null,
    PhoneNum						bigint(15),
    Allergies						varchar(100),
    Familyhistory					varchar(100),
    Smoker							ENUM("Yes","No","Unknown"),
    BirthDate						date,
    Gender							ENUM("Male","Female","Unknown"),
    Pre_exisiting_Conditions		varchar(100),
    City							varchar(30),
    Province						varchar(2),
    StreetAddress					varchar(50),
    AdminSSN						int(9),
	primary key (HealthCareNum)
);

DROP TABLE IF EXISTS Pharmacy;
CREATE TABLE Pharmacy (
	Pname					varchar(100) not null,
	StreetAddress			varchar(50),
	City					varchar(30),
    Province				varchar(2),
	primary key (Pname)
);

DROP TABLE IF EXISTS Supplies;
CREATE TABLE Supplies (
	Pname					varchar(100) not null,
	DrugName			varchar(100) not null,
	Quantity			int(100) not null,
	primary key (Pname, DrugName)
);

DROP TABLE IF EXISTS APPOINTMENT;
CREATE TABLE APPOINTMENT( 
	ConfirmationID           VARCHAR(10)       NOT NULL,
	Appt_Date         		DATETIME           NOT NULL,
	ReasonForVisit         	VARCHAR(100),
PRIMARY KEY (ConfirmationID));


DROP TABLE IF EXISTS HOSPITAL_ROOM;
CREATE TABLE HOSPITAL_ROOM
( RoomNo         INT(10)               NOT NULL,
  Ward			VARCHAR(4) 			NOT NULL,
  RoomType       VARCHAR(100),
PRIMARY KEY (RoomNo, Ward));


DROP TABLE IF EXISTS HOSPITAL;
CREATE TABLE HOSPITAL
( HospitalID			VARCHAR(10) 		NOT NULL,
  hosp_name 			VARCHAR(100) 		NOT NULL,
  Street_Address        VARCHAR(100)        NOT NULL,
  Province        		VARCHAR(100)        NOT NULL,
  City        			VARCHAR(100)        NOT NULL,

PRIMARY KEY (HospitalID),
UNIQUE (hosp_name));

DROP TABLE IF EXISTS CONDUCTED_IN;
CREATE TABLE CONDUCTED_IN
( ConfirmationID    VARCHAR(10)       	NOT NULL,
  Hospital			VARCHAR(10) 		NOT NULL,
  RoomNo         	INT(10)             NOT NULL,
  Ward				VARCHAR(4) 			NOT NULL,
PRIMARY KEY (ConfirmationID, Hospital, RoomNo, Ward));

DROP TABLE IF EXISTS APPT_SCHEDULE;
CREATE TABLE APPT_SCHEDULE
( HealthCareNo    	INT(9)     NOT NULL,
  AdminSSN			INT(9) 			NOT NULL,
  MedicalSSN        INT(9)          NOT NULL,
  ConfirmationID	VARCHAR(10)     NOT NULL,
PRIMARY KEY (HealthCareNo, AdminSSN, MedicalSSN, ConfirmationID));

DROP TABLE IF EXISTS HOSPITAL_STAFF;
CREATE TABLE HOSPITAL_STAFF
( Ssn    			INT(9)     NOT NULL,
  staff_name		VARCHAR(50) 	NOT NULL,
  Department		VARCHAR(50) 	NOT NULL,
  RoleType			VARCHAR(50) 	NOT NULL,
  JobType			VARCHAR(50) 	,
  Residency			VARCHAR(50) 	,
  Specialty			VARCHAR(50) 	,
  Class				VARCHAR(50) 	,
  TestsCapable		VARCHAR(50) 	,
  HospitalID		VARCHAR(10) 	NOT NULL,
PRIMARY KEY (Ssn));

DROP TABLE IF EXISTS DIAGNOSIS;
CREATE TABLE DIAGNOSIS (
	DocumentID			integer(9) not null,
    HealthCareNum		integer(9),
    Appointment_Date	date,
    Notes				varchar(250),
    Resolved			varchar(200),
    TestType			varchar(100),
	Medical_SSN			integer(9),
    DocType				ENUM('Prescription','Lab_Test','Procedure', 'Routine_Checkup','NULL'),
    Results				varchar(250),
    ProcedureType		ENUM('Surgery','Special Examination','NULL'),
    Anesthetic			varchar(200),
    PharmName			varchar(50),
    Nurse_SSN			integer(9),
    primary key (DocumentID)
);

DROP TABLE IF EXISTS DRUG_INFO;
CREATE TABLE DRUG_INFO (
	DocumentID			integer(9)	not null,
	Quantity			integer(4),
	DrugName			varchar(50),
    primary key (DocumentID)
);


ALTER TABLE Send_to
ADD foreign key (InvoiceNo) references Bill(InvoiceNo) 
	ON UPDATE CASCADE ON DELETE CASCADE,
ADD foreign key (CostingCode) references Government(CostingCode)
	ON UPDATE CASCADE ON DELETE CASCADE,
ADD foreign key (CompanyID) references Insurance(CompanyID)
	ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE bill
ADD foreign key (invoiceno) references diagnosis(documentid)
	ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE emergency_contact
ADD foreign key (healthcarenum) references patient(healthcarenum)
	ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE patient
ADD foreign key (adminssn) references hospital_staff(ssn)
	ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE supplies
ADD foreign key (Pname) references pharmacy(Pname)
	ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE drug_info
ADD foreign key (DocumentID) references DIAGNOSIS(DocumentID)
	ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE DIAGNOSIS
ADD foreign key (healthcarenum) references patient(healthcarenum)
	ON UPDATE CASCADE ON DELETE CASCADE,
ADD foreign key (PharmName) references pharmacy(Pname)
	ON UPDATE CASCADE ON DELETE CASCADE,
ADD foreign key (medical_ssn) references hospital_staff(ssn)
	ON UPDATE CASCADE ON DELETE CASCADE,
    ADD foreign key (nurse_ssn) references hospital_staff(ssn)
	ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE hospital_staff
ADD foreign key (hospitalID) references hospital(HospitalID)
	ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE APPT_SCHEDULE
ADD foreign key (HealthCareNo) references patient(HealthCareNum)
	ON UPDATE CASCADE ON DELETE CASCADE,
ADD foreign key (AdminSSN) references hospital_staff(ssn)
	ON UPDATE CASCADE ON DELETE CASCADE,
ADD foreign key (MedicalSSN) references hospital_staff(ssn)
	ON UPDATE CASCADE ON DELETE CASCADE,
ADD foreign key (ConfirmationID) references appointment(ConfirmationID)
	ON UPDATE CASCADE ON DELETE CASCADE;


ALTER TABLE CONDUCTED_IN
ADD foreign key (ConfirmationID) references APPOINTMENT(ConfirmationID)
	ON UPDATE CASCADE ON DELETE CASCADE,
ADD foreign key (Hospital) references hospital(HospitalID)
	ON UPDATE CASCADE ON DELETE CASCADE,
ADD foreign key (RoomNo,ward) references hospital_room(RoomNo,ward)
	ON UPDATE CASCADE ON DELETE CASCADE;
    

--   Creating a trigger and checking bills table
DELIMITER $$

CREATE TRIGGER bill_creation
AFTER INSERT
ON diagnosis FOR EACH ROW
BEGIN
	if new.doctype ="lab_Test" then
        insert into bill(InvoiceNo, CoveredbyInsurance, cost)
        values (new.documentid, 0.3, 300);
	end if;
    if new.doctype ="Routine_checkup" then
        insert into bill(InvoiceNo, CoveredbyInsurance, cost)
        values (new.documentid, 0.3, 100);
	end if;
    if new.doctype ="Procedure" then
        insert into bill(InvoiceNo, CoveredbyInsurance, cost)
        values (new.documentid, 0.3, 1000);
	end if;
    if new.doctype ="Prescription" then
        insert into bill(InvoiceNo, CoveredbyInsurance, cost)
        values (new.documentid, 0.3, 50);
	end if;
END$$

DELIMITER ;

DELIMITER $$

CREATE TRIGGER send_to_sponsor
AFTER INSERT
ON bill FOR EACH ROW
BEGIN
	if new.cost < 200 then
        insert into send_to(InvoiceNo, CostingCode, CompanyID)
        values (new.InvoiceNo, 'AB001', 'CIBC');
	end if;
    if new.cost >= 200 then 
        insert into send_to(InvoiceNo, CostingCode, CompanyID)
        values (new.InvoiceNo, 'AB002', 'RBC');
	end if;
END$$

DELIMITER ;



-- Insserting values

-- Insurance
INSERT INTO Insurance (CompanyID, TaxCode, InsuranceRate)
VALUES
('CIBC','GST-003', 0.2),
('RBC','GST-002', 0.3); 

-- Goverment
INSERT INTO Government (CostingCode, Department, Province)
VALUES
('AB001','healthcare','AB'),
('AB002','finance','AB');

-- appointment
INSERT INTO Appointment (ConfirmationID, Appt_Date, ReasonForVisit)
VALUES
('10001','2023-01-22','Routine Check up'),
('10002','2023-02-22','Feeling nauseous'),
('10003','2023-01-10','headache'),
('10004','2023-03-12','pain on lower back');

-- hospital room
INSERT INTO HOSPITAL_ROOM (RoomNo, Ward, RoomType)
VALUES
('10001','01','General room'),
('10002','02','emergency'),
('10003','03','Surgery'),
('10004','04','operation');

-- hospital
INSERT INTO HOSPITAL (HospitalID, hosp_name, Street_Address, Province, City)
VALUES
('10001','MedPlus','Sherwood', 'AB', 'Calgary'),
('10002','Foothills','Country Hills', 'AB', 'Calgary'),
('10003','Sage Clinic','Sage Hills', 'AB', 'Calgary'),
('10004','Brentwood Medical','Crowfoot', 'AB', 'Calgary');


-- conducted, references hospital, appointment and hospital room
INSERT INTO CONDUCTED_IN (ConfirmationID, Hospital, RoomNo, Ward)
VALUES
('10001','10001', '10001','01'),
('10002','10001', '10003', '03'),
('10003','10001', '10004', '04');


-- inserting into hospital staff, references hospital
INSERT INTO HOSPITAL_STAFF (Ssn, staff_name, Department, RoleType, JobType, Residency, Specialty, Class, TestsCapable, HospitalID)
VALUES
('1234567','John', 'Family Medicine','Medical','Generalist', 'R10001',Null, Null, Null,'10001'),
('2234567','Jane', 'Family Medicine','Medical','Generalist', 'R10002', Null, Null, Null,'10001'),
('3234567','Rachel', 'Surgery','Medical','Nurse', Null, Null, '1',Null,'10001'),
('4234567','Ruth', 'Surgery','Medical','Nurse', Null, Null, '2','Null','10001'),
('5234567','Bill', 'Surgery','Medical','Technician', Null,Null, Null,'Blood','10001'),
('6234567','Bella', 'Surgery','Medical','Technician', Null, Null, Null,'Urine','10001'),
('7234567','Jack', 'Virology','Medical','Specialist', 'R10003','Covid', Null, Null,'10001'),
('8234567','James', 'Oncology','Medical','Specialist', 'R10004','Colon', Null, Null,'10001'),
('9234567','Beth', 'Admin','Admin', Null, Null, Null, Null, Null,'10001');


-- pharmacy
INSERT INTO Pharmacy (Pname, StreetAddress, City, Province)
VALUES
('Crowfoot Pharmacy','23 st','Calgary',"AB"),
('CrowChild Pharmacy','24 st','Calgary',"AB"),
('Bowness Pharmacy','25 str downtown','Calgary',"AB"),
('Ridgewood Pharmacy','26 ave','Edmonton',"BC");


-- Supplies, references pharmacy
INSERT INTO SUPPLIES (Pname, DrugName, Quantity)
VALUES
('Crowfoot Pharmacy','Advil', 2000),
('Crowfoot Pharmacy','Vit C', 2000),
('Crowfoot Pharmacy','Vit D', 2000),
('Crowfoot Pharmacy','Zinc', 2000),
('Bowness Pharmacy','Advil', 2000),
('Bowness Pharmacy','Vit C', 2000),
('Bowness Pharmacy','Vit D', 2000),
('Bowness Pharmacy','Zinc', 2000),
('CrowChild Pharmacy','Advil', 2000),
('CrowChild Pharmacy','Vit C', 2000),
('CrowChild Pharmacy','Vit D', 2000),
('CrowChild Pharmacy','Zinc', 2000);

-- PATIENT refences Hospital staff on Adminssn
INSERT INTO Patient (HealthCareNum, Pname, PhoneNum, Allergies, Familyhistory, Smoker, BirthDate, Gender, Pre_exisiting_Conditions, City, Province, StreetAddress, AdminSSN)
VALUES
('123456789', 'Ted', 403203111, "peanuts", "heart attacks", "Yes", "1991-12-23", "Male", Null, "Calgary", "AB", "22 Brown ave", "9234567"),
('223456789', 'Kate', 403203222, "seafood", "diabetes", "No", "1993-12-23", "Female", "Diabetes", "Calgary", "AB", "23 Brown ave", "9234567"),
('323456789', 'Quinn', 403203333, "milk", Null, "No", "1995-12-23", "Female", Null, "Calgary", "AB", "24 First Str", "9234567"),
('423456789', 'Bob', 403203444, Null, "diabetes", "Yes", "1996-12-23", "Male", "Myopia", "Calgary", "AB", "25 Second ave", "9234567"),
('523456789', 'William', 403203555, Null, Null, "Yes", "1997-12-23", "Male", Null, "Calgary", "AB", "21 Third Str", "9234567");


-- emergency_contact refences patient on healthcarenum
INSERT INTO Emergency_contact (HealthCareNum, Cname, PhoneNum, Relationship)
VALUES
('123456789', 'Tammy', 403203112, "Wife"),
('123456789', 'Tom', 403203112, "Son"),
('223456789', 'Tim', 403203223, "brother"),
('323456789', 'Kim', 403203334, "sister");


-- Diagnosis refences Patient(healthCareNum) and Pharmacy(Pname)
INSERT INTO DIAGNOSIS (DocumentID, HealthCareNum, Appointment_Date, Notes, Resolved, TestType, Medical_SSN, DocType, Results, ProcedureType, Anesthetic, PharmName, Nurse_SSN)
VALUES
('10001', '123456789', '2023-04-16', "Patient is allergic to peanuts. Recommend blood work", "No", Null, "1234567", "Routine_checkup", 'Great', NULL, "No", Null, Null),
('10002', '123456789', '2023-02-16', "Patient reacted to peanuts and milk, lab test recommended", "No", "Lactose Reaction", "5234567", "Lab_Test", 'Result indicate lactose intolerance', Null, "No", Null, Null),
('10003', '223456789', '2023-05-16', "Xray shows damaged ribs. Possible cause of abdominal pain", "No", Null, "7234567", "Procedure", 'Not completed', 'Special Examination', "No", Null, "3234567"),
('10004', '423456789', '2023-04-20', "ACL surgery suucessfully", "No", Null, "8234567", "Procedure", 'Completed', 'Surgery', "No", Null, "3234567"),

('10005', '323456789', '2023-04-10', "Advil. 3x daily for 5 days", "No", Null, "1234567", "Prescription", Null, Null, "No", 'Crowfoot Pharmacy', Null),
('10006', '323456789', '2023-03-10', "Daily dose of zinc", "No", Null, "2234567", "Prescription", Null, Null, "No", 'Bowness Pharmacy', Null),

('10007', '523456789', '2023-04-16', "Numbing pain on leg. Recommend test and medication", "No", Null, "2234567", "Routine_checkup", 'Great', NULL, "No", 'Crowfoot Pharmacy', Null);

-- Drug info refences DIAGNOSIS(documentid)
INSERT INTO DRUG_INFO (DocumentID, Quantity, DrugName)
VALUES
('10005', 20, "Advil"),
('10007', 6, "VitC"),
('10006', 15, "Zinc");


-- Bill references DIAGNOSIS(documentid)
-- INSERT INTO Bill (InvoiceNo, CoveredbyInsurance, DocumentID)
-- VALUES
-- ('1111','0.2','10001'),
-- ('1112','0.3','10002'),
-- ('1113','0.3','10003'),
-- ('1114','0.2','10004'),
-- ('1115','0.5','10005'),
-- ('1116','0.5','10006');


-- SEND_TO references BILL(invoiceNo), Insurance(companyID), government(costingCode)
-- INSERT INTO SEND_TO (InvoiceNo, CostingCode, CompanyID)
-- VALUES
-- ('1111','AB001','TD'),
-- ('1112','AB001','RBC'),
-- ('1113','BC001','TD'),
-- ('1114','BC001','CIBC'),
-- ('1115','SK001','RBC'),
-- ('1116','SK001','TD');


-- APPT_SCHEDULE references PATIENT(HealthCareNo), HOSPITAL_STAFF(AdminSSN), HOSPITAL_STAFF(MedicalSSN), APPOINTMENT(ConfirmationID))
INSERT INTO APPT_SCHEDULE (HealthCareNo, AdminSSN, MedicalSSN, ConfirmationID)
VALUES
('123456789','9234567', '1234567','10001'),
('123456789','9234567', '2234567','10002'),
('223456789','9234567', '5234567','10003'),
('223456789','9234567', '3234567','10004');



-- select * from diagnosis;


-- Test Cases
INSERT INTO DIAGNOSIS (DocumentID, HealthCareNum, Appointment_Date, Notes, Resolved, TestType, Medical_SSN, DocType, Results, ProcedureType, Anesthetic, PharmName, Nurse_SSN)
VALUES
('10008', '123456789', '2023-04-16', "Patient is allergic to peanuts. Recommend blood work", "No", Null, "1234567", "Routine_checkup", 'Great', NULL, "No", Null, Null),
('100010', '223456789', '2023-04-16', "Patient is allergic to peanuts. Recommend blood work", "No", Null, "7234567", "Procedure", 'Great', NULL, "No", Null, '3234567'),
('100011', '323456789', '2023-04-16', "Patient is allergic to peanuts. Recommend blood work", "No", Null, "1234567", "prescription", 'Great', NULL, "No", Null, null),
('10009', '423456789', '2023-02-16', "Patient reacted to peanuts and milk, lab test recommended", "No", "Lactose Reaction", "5234567", "Lab_Test", 'Result indicate lactose intolerance', Null, "No", Null, null);

select * from bill;
select * from send_to;

-- *********TEST CASES ****************

-- -- testing updatting pharmacy name using its address
-- UPDATE pharmacy
-- SET pname = 'Crowfoot Pharmacy updated'
-- WHERE StreetAddress = '23 st';

-- select * from pharmacy;
-- select * from supplies;
select * from patient;


-- -- testing updating an hospital id using its name
-- UPDATE hospital
-- SET hospitalid = 'XXXXXX'
-- WHERE hosp_name = 'medplus';


-- select * from hospital;
-- select * from conducted_in;
-- select * from hospital_staff;
-- select * from hospital;


-- -- testing deleting a patient to affect emergency contact
-- DELETE FROM patient
-- WHERE pname='Ted';

-- select * from patient;
-- select * from emergency_contact;
-- select * from appt_schedule;
-- select * from diagnosis;

-- -- testting changing an appointment
-- UPDATE appointment
-- SET reasonforvisit = 'changed my mind'
-- WHERE confirmationid = '10001';

-- select * from appointment;
-- select * from conducted_in;
-- select * from appt_schedule;

-- select * from patient;


-- select * from patient;
-- -- testting changing an hospital room
-- UPDATE hospital_room
-- SET ward = '99'
-- WHERE roomno = '10001';

-- select * from hospital_room;
-- select * from conducted_in;
-- select * from appt_schedule;


-- DELETE FROM hospital
-- WHERE hosp_name='Medplus';

select * from emergency_contact;
-- select * from hospital_staff;
-- select * from diagnosis;

-- -- testing update from relationship table (where foreign key resides)
-- UPDATE send_to
-- SET companyid = 'RBC'
-- WHERE invoiceNo = '1111';

-- select * from send_to;
-- select * from bill;
-- select * from insurance;
-- select * from government;
