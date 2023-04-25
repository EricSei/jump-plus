
-- User
-- - Id
-- - email
-- - pw
-- - firstName
-- - lastName

-- Student
-- - 

-- Teacher
-- - Id
-- - Name
-- - 

-- Class ()
-- - Id
-- - name
-- - Teacher


-- Enrollement (classes_students)
-- - id
-- - classId
-- - student_id
-- grade

create database grade_book;

use grade_book;

create Table Teacher(
 id int not null auto_increment,
 email varchar(200) not null unique,
 password varchar(200) not null,
 role varchar(200) not null,
 primary key(id)
);
ALTER TABLE Teacher ADD name varchar(100) not null;

create Table Student(
	id int not null auto_increment,
	email varchar(200) not null unique,
	password varchar(200) not null,
    role varchar(100) not null,
	primary key(id)
);
ALTER TABLE Student ADD name varchar(100) not null;

use grade_book;
create Table Class(
	id int not null auto_increment primary key,
    name varchar(100) not null unique,
    teacher_id int not null,
    foreign key(teacher_id) references Teacher(id)
    
);

-- students_classes
create Table Enrollement(
	id int not null auto_increment primary key,
    class_id int not null,
    student_id int not null,
	foreign key(class_id) references Class(id),
    foreign key(student_id) references Student(id)
);

ALTER TABLE Enrollement ADD grade1 varchar(1) not null;
ALTER TABLE Enrollement ADD grade2 varchar(1) not null;
ALTER TABLE Enrollement ADD grade3 varchar(1) not null;

insert into Student (id, email, password, role)
values
	(0, "eric@gmail.com", "eric@123", "student"),
	(0, "eric1@gmail.com", "eric@123", "student"),
	(0, "eric2@gmail.com", "eric@123", "student"),
	(0, "eric3@gmail.com", "eric@123", "student"),
	(0, "eric4@gmail.com", "eric@123", "student");

insert into Student (id, email, password, name, role )
values
	(0, "james@gmail.com", "james@123", "james", "student"),
	(0, "allison@gmail.com", "allison@123","allison", "student"),
	(0, "shelly@gmail.com", "shelly@123","shelly", "student"),
	(0, "Charles@gmail.com", "Charles@123", "charles","student"),
	(0, "Joshua@gmail.com", "Joshua@123","joshua", "student");


    
select * from Student;

insert into Teacher (id, email, password, role)
values
	(0, "rachel@gmail.com", "rachel@123", "teacher"),
    (0, "rachel1@gmail.com", "rachel@123", "teacher"),
    (0, "rachel2@gmail.com", "rachel@123", "teacher"),
    (0, "rachel3@gmail.com", "rachel@123", "teacher"),
    (0, "rachel4@gmail.com", "rachel@123", "teacher");

select * from Teacher;

insert into class (id, name, teacher_id)
values
	(0, "computer science 102", 1),
    (0, "Data Structures", 1),
    (0, "Computer Organization", 1)
;

select * from Class;

insert into enrollement(id, class_id, student_id, grade1, grade2, grade3)
values
	(0, 1, 12, 100, 85, 95),
    (0, 1, 11, 100, 85, 95),
    (0, 1, 10,  75, 85, 95),
    (0, 1, 9, 100, 85, 95),
    (0, 1, 8, 100, 85, 95);
    

ALTER TABLE Enrollement MODIFY grade1 INTEGER Not null;
ALTER TABLE Enrollement MODIFY grade2 INTEGER Not null;
ALTER TABLE Enrollement MODIFY grade3 INTEGER Not null;

-- teacher update student enrollement
UPDATE enrollement
SET grade1 = 100 , grade2 = 85, grade3 = 95
WHERE student_id=1 and class_id = 2;

UPDATE enrollement
SET grade2 = 100 
WHERE student_id=3 and class_id = 1;

select Enrollement.id, Enrollement.class_id, Enrollement.student_id, Enrollement.grade1, Enrollement.grade2, Enrollement.grade3, Student.email, Student.name 
from Enrollement
left join Student on Enrollement.student_id = Student.id
where class_id=1;

select * from Enrollement
inner join Student on Enrollement.student_id = Student.id
where student_id=1;


select * from Teacher;
Update Teacher
set name = "rachel4"
where id = 5;

select * from Student;

Update Student
set name = "eric444"
where id = 4;




-- ALTER TABLE ReferencingTable ADD 
--    CONSTRAINT fk__ReferencingTable__MainTable 
--       FOREIGN KEY (pk_col_1)
--       REFERENCES MainTable (pk_col_1)
--       ON DELETE CASCADE;

create Table Enrollement(
	id int not null auto_increment primary key,
    class_id int not null,
    student_id int not null,
	foreign key(class_id) references Class(id),
    foreign key(student_id) references Student(id)
);
      
ALTER TABLE Enrollement
drop foreign key enrollement_ibfk_9;

ALTER TABLE Enrollement
ADD 
    FOREIGN KEY (student_id)
    REFERENCES Student(id) ON DELETE CASCADE ON UPDATE CASCADE;
    
ALTER TABLE Enrollement
ADD 
    FOREIGN KEY (class_id)
    REFERENCES Class(id)
    ON DELETE CASCADE ON UPDATE CASCADE;

show create table Enrollement;


select * from student;
select * from Enrollement;

select * from Student;

select * from Class;

select * from class
where teacher_id=1;

select * from Enrollement
where student_id = 3 and class_id =1;

select * from Enrollement
where class_id =2;


Truncate TABLE Enrollement;


select * from Teacher;



DELETE FROM Student 
WHERE id=6;
















