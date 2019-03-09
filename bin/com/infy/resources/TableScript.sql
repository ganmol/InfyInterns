Drop table Mentor CASCADE CONSTRAINTS;
Drop table Mentor_Project CASCADE CONSTRAINTS;


DROP SEQUENCE project_pid_seq;


CREATE SEQUENCE project_pid_seq START WITH 12 INCREMENT BY 1;


CREATE TABLE Mentor (
mentorId NUMBER CONSTRAINT mentor_pk PRIMARY KEY,
mentorName VARCHAR2(50) NOT NULL,
projectCount NUMBER NOT NULL
);

INSERT INTO Mentor VALUES(10000,'Vasudha',0);
INSERT INTO Mentor VALUES(10001,'Vivek',0);
INSERT INTO Mentor VALUES(10012,'Shilpa',2);
INSERT INTO Mentor VALUES(10018,'Vikrant',1);
INSERT INTO Mentor VALUES(10009,'Jyoti',1); 
INSERT INTO Mentor VALUES(10025,'Alka',1); 
INSERT INTO Mentor VALUES(10038,'Shivangi',3); 
INSERT INTO Mentor VALUES(10085,'Sarthak',1); 
INSERT INTO Mentor VALUES(10096,'Abhilash',2);

CREATE TABLE Mentor_Project(
projectId NUMBER CONSTRAINT Mentor_Proj_pk PRIMARY KEY,
projectName VARCHAR2(50) NOT NULL,
ideaOwner NUMBER NOT NULL,
mentorId NUMBER REFERENCES Mentor(mentorId) NOT NULL
);

INSERT INTO Mentor_Project VALUES(1,'Shoe Cart',10012,10009);
INSERT INTO Mentor_Project VALUES(2,'A one-stop shop App',10025,10038);
INSERT INTO Mentor_Project VALUES(3,'Buy N Sell Portal',10085,10038);
INSERT INTO Mentor_Project VALUES(4,'Dine Easy',10000,10096);
INSERT INTO Mentor_Project VALUES(5,'Tutor Point',10012,10018);
INSERT INTO Mentor_Project VALUES(6,'Elevate',10000,10038);
INSERT INTO Mentor_Project VALUES(7,'Health App',10018,10012);
INSERT INTO Mentor_Project VALUES(8,'Visitor Portal',10096,10012);
INSERT INTO Mentor_Project VALUES(9,'Chatter Box',10038,10025);
INSERT INTO Mentor_Project VALUES(10,'Quiz Yourself',10009,10085);
INSERT INTO Mentor_Project VALUES(11,'Take a Ride',10085,10096);


select * from MENTOR_PROJECT;

select * from MENTOR;

