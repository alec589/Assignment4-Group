/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package info5100.university.example;

import info5100.university.example.College.College;
import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseCatalog.CourseCatalog;
import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.CourseSchedule.SeatAssignment;
import info5100.university.example.Department.Calendar;
import info5100.university.example.Department.Department;
import info5100.university.example.Persona.AdmainProfile;
import info5100.university.example.Persona.Faculty.Assignment;
import info5100.university.example.Persona.Faculty.FacultyDirectory;
import info5100.university.example.Persona.Faculty.FacultyProfile;
import info5100.university.example.Persona.Faculty.StudentAssignment;
import info5100.university.example.Persona.Person;
import info5100.university.example.Persona.PersonDirectory;
import info5100.university.example.Persona.RegisterDirectory;
import info5100.university.example.Persona.RegisterProfile;
import info5100.university.example.Persona.StudentDirectory;
import info5100.university.example.Persona.StudentProfile;
import info5100.university.example.Persona.Transcript;
import info5100.university.example.Persona.UserAccount;
import info5100.university.example.Persona.UserAccountDirectory;

/**
 *
 * @author sunzuolin
 */
public class ConfigureTheBusiness {
     static Department initialize(){
         College college = new College("Northeastern College"); 
         Department department = college.addDepartment("Information Systems");
         
         PersonDirectory persondirectory = department.getPersondirectory();
          // 1-10 are students
          Person person001 = persondirectory.newPerson("John Smith");
          Person person002 = persondirectory.newPerson("Gina Montana");
          Person person003 = persondirectory.newPerson("Adam Rollen");
          Person person004 = persondirectory.newPerson("Amy Scott");
          Person person005 = persondirectory.newPerson("Jim Dellon");
          Person person006 = persondirectory.newPerson("Anna Shnider");
          Person person007 = persondirectory.newPerson("Laura Brown");
          Person person008 = persondirectory.newPerson("Jack While");
          Person person009 = persondirectory.newPerson("Fidelity");
          Person person0010 = persondirectory.newPerson("Mark King");
          // 11-20 are faculties
          Person person0011 = persondirectory.newPerson("Kevin Hill");
          Person person0012 = persondirectory.newPerson("Julia Green");
          Person person0013 = persondirectory.newPerson("Tom Adams");
          Person person0014 = persondirectory.newPerson("Zoe Bennett");
          Person person0015 = persondirectory.newPerson("Chris Nelson");
          Person person0016 = persondirectory.newPerson("Rachel Carter");
          Person person0017 = persondirectory.newPerson("Alex Turner");
          Person person0018 = persondirectory.newPerson("Lucy White");
          Person person0019 = persondirectory.newPerson("Jane Harris");
          Person person0020 = persondirectory.newPerson("Kate Young");
          //
          Person person0021 = persondirectory.newPerson("Robert Clark");
          Person person0022 = persondirectory.newPerson("Lisa Hall");
          Person person0023 = persondirectory.newPerson("James Taylor");
          Person person0024 = persondirectory.newPerson("Sarah Miller");
          Person person0025 = persondirectory.newPerson("Ella Rogers");
          Person person0026 = persondirectory.newPerson("Mary Johnson");
          Person person0027 = persondirectory.newPerson("Emily Wilson");
          Person person0028 = persondirectory.newPerson("Michael Davis");
          Person person0029 = persondirectory.newPerson("Eric Ross");
          Person person0030 = persondirectory.newPerson("Justin Foster");
          Person person0031 = persondirectory.newPerson("Lucy While");    
          
          StudentDirectory studentdirectory = department.getStudentdirectory();
          StudentProfile stu1 = studentdirectory.newStudentProfile(person001);
          StudentProfile stu2 = studentdirectory.newStudentProfile(person002);
          StudentProfile stu3 = studentdirectory.newStudentProfile(person003);
          StudentProfile stu4 = studentdirectory.newStudentProfile(person004);
          StudentProfile stu5 = studentdirectory.newStudentProfile(person005);
          StudentProfile stu6 = studentdirectory.newStudentProfile(person006);
          StudentProfile stu7 = studentdirectory.newStudentProfile(person007);
          StudentProfile stu8 = studentdirectory.newStudentProfile(person008);
          StudentProfile stu9 = studentdirectory.newStudentProfile(person009);
          StudentProfile stu10 = studentdirectory.newStudentProfile(person0010);
          
          stu1.setFirstName("John");stu1.setLastName("Smith");
          stu2.setFirstName("Gina");stu2.setLastName(" Montana");
          stu3.setFirstName("Adam ");stu3.setLastName("Rollen");
          stu4.setFirstName("Amy ");stu4.setLastName("Scott");
          stu5.setFirstName("Jim Dellon");stu5.setLastName("Dellon");
          stu6.setFirstName("Anna ");stu6.setLastName("Shnider");
          stu7.setFirstName("Laura ");stu7.setLastName("Brown");
          stu8.setFirstName("Jack ");stu8.setLastName("While");
          stu9.setFirstName("Fidelity");stu9.setLastName("Fidelity");
          stu10.setFirstName("Mark King");stu10.setLastName(" King");
          
          FacultyDirectory facultyDirectory =department.getFacultydirectory();
          FacultyProfile fa01 = facultyDirectory.newFacultyProfile(person0011);
          FacultyProfile fa02 = facultyDirectory.newFacultyProfile(person0012);
          FacultyProfile fa03 = facultyDirectory.newFacultyProfile(person0013);
          FacultyProfile fa04 = facultyDirectory.newFacultyProfile(person0014);
          FacultyProfile fa05 = facultyDirectory.newFacultyProfile(person0015);
          FacultyProfile fa06 = facultyDirectory.newFacultyProfile(person0016);
          FacultyProfile fa07 = facultyDirectory.newFacultyProfile(person0017);
          FacultyProfile fa08 = facultyDirectory.newFacultyProfile(person0018);
          FacultyProfile fa09 = facultyDirectory.newFacultyProfile(person0019);
          FacultyProfile fa010 = facultyDirectory.newFacultyProfile(person0020);
          
          // configure faculty details
          fa01.setFirstName("Kevin");
          fa01.setLastName("Hill");
          fa01.setEmail("kevin@northeastern.edu");
          fa01.setPhoneNumber("999-999-9999");
          fa01.setPosition("Professor");
          fa01.setOfficeLocation("Ell Hall 120");
          fa02.setFirstName("Julia");
          fa02.setLastName("Green");
          fa02.setEmail("julia@northeastern.edu");
          fa02.setPhoneNumber("888-888-8888");
          fa02.setPosition("Teaching Assistant");
          fa02.setOfficeLocation("ISEC 260");
          
          
          CourseCatalog coursecatalog = department.getCoursecatalog();
          Course  course1 = coursecatalog.newCourse( "Application Engineer and Development", 4);
          Course  course2 = coursecatalog.newCourse( "Data Structures and Algorithms", 2);
          Course  course3 = coursecatalog.newCourse( "Discrete Mathematics", 2);
          Course  course4 = coursecatalog.newCourse( "Computer Organization and Architecture", 2);
          Course  course5 = coursecatalog.newCourse( "Operating Systems", 2);
          Course  course6 = coursecatalog.newCourse( "Database Management Systems", 2);
          Course  course7 = coursecatalog.newCourse( "Principles of Computer Networks", 2);
          Course  course8 = coursecatalog.newCourse( "Software Engineering", 2);
          course1.setDescription("Software application design");
          course2.setDescription("Efficient data handling");
          course3.setDescription("Logic and proofs");
          course4.setDescription("Hardware fundamentals");
          course5.setDescription("Process management");
          course6.setDescription("Data storage design");
          course7.setDescription("Network fundamentals");
          course8.setDescription("System development lifecycle");
          Course corecourse1 = department.getDegree().addCoreCourse(course1);
          Course electivecourse1 = department.getDegree().addElectiveCourse(course2);
          Course electivecourse2 = department.getDegree().addElectiveCourse(course3);
          Course electivecourse3 = department.getDegree().addElectiveCourse(course4);
          Course electivecourse4 = department.getDegree().addElectiveCourse(course5);
          Course electivecourse5 = department.getDegree().addElectiveCourse(course6);
          Course electivecourse6 = department.getDegree().addElectiveCourse(course7);
          course1.setSchedule("Mon15:00-18:00");
          course2.setSchedule("Fri12:00-13:00");
          course3.setSchedule("Sat12:10-14:00");
          course4.setSchedule("Tue09:00-10:00");
          course5.setSchedule("Fri08:00-10:30");
          course6.setSchedule("Wed12:00-13:50");
          course7.setSchedule("Thu18:00-20:00");
          course8.setSchedule("Wed14:00-16:00");
          
          
          // 2025 Spring
          Calendar calendar = department.getCalendar();
          CourseSchedule springSchedule = new CourseSchedule("2025Spring", coursecatalog);
          calendar.addCourseSchedule("2025Spring", springSchedule);
          
          CourseOffer spring_course1 = springSchedule.newCourseOffer(course1.getCourseNumber());
          spring_course1.generatSeats(30);
          spring_course1.AssignAsTeacher(fa01);                                                                       // spring01 - fa01
          spring_course1.setLocation(211, 1, 102);
          spring_course1.setTimeSchedule("Monday", 8, 10);
          spring_course1.setEnrollmentStatus(false);
          
          CourseOffer spring_course2 = springSchedule.newCourseOffer(course2.getCourseNumber());
          spring_course2.generatSeats(40);
          spring_course2.AssignAsTeacher(fa02);                                                                       // spring02 - fa02
          spring_course2.setLocation(316, 1, 105);
          spring_course2.setTimeSchedule("Thursday", 7, 9);
          spring_course2.setEnrollmentStatus(false);
          
          // 2025 Summer
          CourseSchedule summerSchedule = new CourseSchedule("2025Summer", coursecatalog);
          calendar.addCourseSchedule("2025Summer", summerSchedule);
          
          CourseOffer summer_course1 = summerSchedule.newCourseOffer(course3.getCourseNumber());
          summer_course1.generatSeats(30);
          summer_course1.AssignAsTeacher(fa01);                                                                     // summer01 - fa01
          summer_course1.setLocation(113, 3,309);
          summer_course1.setTimeSchedule("Friday", 10, 11);
          summer_course1.setEnrollmentStatus(false);   
          
          CourseOffer summer_course2 = summerSchedule.newCourseOffer(course4.getCourseNumber());
          summer_course2.generatSeats(30);
          summer_course2.AssignAsTeacher(fa02);                                                                     // summer02 - fa02
          summer_course2.setLocation(813, 7,732);
          summer_course2.setTimeSchedule("Friday", 13, 15);
          summer_course2.setEnrollmentStatus(false);
          
          // 2025 fall
          CourseSchedule fallSchedule = new CourseSchedule("2025Fall", coursecatalog);
          calendar.addCourseSchedule("2025Fall", fallSchedule);
          
          CourseOffer fall_course1 = fallSchedule.newCourseOffer(course5.getCourseNumber());
          fall_course1.generatSeats(30);
          fall_course1.AssignAsTeacher(fa01);                                                                      // fall01 - fa01
          fall_course1.setLocation(413, 3,301);
          fall_course1.setTimeSchedule("Monday", 14, 16);
          fall_course1.setEnrollmentStatus(false);
          
          CourseOffer fall_course2 = summerSchedule.newCourseOffer(course6.getCourseNumber());
          fall_course2.generatSeats(30);
          fall_course2.AssignAsTeacher(fa02);                                                                      // fall02 - fa02
          fall_course2.setLocation(513, 2,211);
          fall_course2.setTimeSchedule("Friday", 19, 20);
          fall_course2.setEnrollmentStatus(false);
          
          // 2025 winter
          CourseSchedule winterSchedule = new CourseSchedule("2025Winter", coursecatalog);
          calendar.addCourseSchedule("2025Winter", winterSchedule);
          
          CourseOffer winter_course1 = winterSchedule.newCourseOffer(course7.getCourseNumber());
          winter_course1.generatSeats(30);
          winter_course1.AssignAsTeacher(fa01);                                                                     // winter01 - fa01
          winter_course1.setTimeSchedule("Saturday", 15, 16);
          winter_course1.setLocation(111, 2, 205);
          winter_course1.setEnrollmentStatus(true);
          
          CourseOffer winter_course2 = winterSchedule.newCourseOffer(course8.getCourseNumber());
          winter_course2.generatSeats(30);
          winter_course2.AssignAsTeacher(fa02);                                                                     // winter02 - fa02
          winter_course2.setLocation(761, 6, 605); 
          winter_course2.setTimeSchedule("Sunday", 15, 17);
          winter_course2.setEnrollmentStatus(true);
          
          
          // configure trancript and courseload, connect student
          // transcrip1
          Transcript t01 = stu1.getTranscript();
          CourseLoad cl011 = t01.newCourseLoad(springSchedule.getSemester());
          CourseLoad cl013 = t01.newCourseLoad(summerSchedule.getSemester());
          CourseLoad cl015 = t01.newCourseLoad(fallSchedule.getSemester());
          
          SeatAssignment sa011 = cl011.newSeatAssignment(spring_course1, stu1);
          SeatAssignment sa012 = cl011.newSeatAssignment(spring_course2, stu1);
          SeatAssignment sa013 = cl013.newSeatAssignment(summer_course1, stu1);
          SeatAssignment sa014 = cl013.newSeatAssignment(summer_course2, stu1);
          SeatAssignment sa015 = cl015.newSeatAssignment(fall_course1, stu1);
          SeatAssignment sa016 = cl015.newSeatAssignment(fall_course2, stu1);
          cl011.setTranscript(t01);
          cl013.setTranscript(t01);
          cl015.setTranscript(t01);

          
          // transcrip2
          Transcript t02 = stu2.getTranscript();
          CourseLoad cl021 = t02.newCourseLoad(springSchedule.getSemester());
          CourseLoad cl023 = t02.newCourseLoad(summerSchedule.getSemester());
          CourseLoad cl025 = t02.newCourseLoad(fallSchedule.getSemester());
        
          SeatAssignment sa021 = cl021.newSeatAssignment(spring_course1, stu2);
          SeatAssignment sa022 = cl021.newSeatAssignment(spring_course2, stu2);
          SeatAssignment sa023 = cl023.newSeatAssignment(summer_course1, stu2);
          SeatAssignment sa024 = cl023.newSeatAssignment(summer_course2, stu2);
          SeatAssignment sa025 = cl025.newSeatAssignment(fall_course1, stu2);
          SeatAssignment sa026 = cl025.newSeatAssignment(fall_course2, stu2);
          cl021.setTranscript(t02);
          cl023.setTranscript(t02);
          cl025.setTranscript(t02);
         
          
          // transcrip3
          Transcript t03 = stu3.getTranscript();
          CourseLoad cl031 = t03.newCourseLoad(springSchedule.getSemester());
          CourseLoad cl033 = t03.newCourseLoad(summerSchedule.getSemester());
          CourseLoad cl035 = t03.newCourseLoad(fallSchedule.getSemester());
          
          SeatAssignment sa031 = cl031.newSeatAssignment(spring_course1, stu3);
          SeatAssignment sa032 = cl031.newSeatAssignment(spring_course2, stu3);
          SeatAssignment sa033 = cl033.newSeatAssignment(summer_course1, stu3);
          SeatAssignment sa034 = cl033.newSeatAssignment(summer_course2, stu3);
          SeatAssignment sa035 = cl035.newSeatAssignment(fall_course1, stu3);
          SeatAssignment sa036 = cl035.newSeatAssignment(fall_course2, stu3);
          cl031.setTranscript(t03);
          cl033.setTranscript(t03);
          cl035.setTranscript(t03);
         
          
         
          // configure assignment
          // spring
          Assignment assignment1 = new Assignment("UI Design Project", fa01, 100);
          Assignment assignment2 = new Assignment("Introduction to Java",fa01, 100);
          Assignment assignment3 = new Assignment("Sorting Analysis", fa02,100);
          Assignment assignment4 = new Assignment("Graph Traversal",fa02, 100);
          spring_course1.getFacultyassignment().assignAssignment(assignment1);
          spring_course1.getFacultyassignment().assignAssignment(assignment2);
          spring_course2.getFacultyassignment().assignAssignment(assignment3);
          spring_course2.getFacultyassignment().assignAssignment(assignment4);
          assignment1.setWeight(0.5);
          assignment2.setWeight(0.5);
          assignment3.setWeight(0.3);
          assignment4.setWeight(0.7);
          // summer
          Assignment assignment5 = new Assignment("Logic Proofs", fa01, 100);
          Assignment assignment6 = new Assignment("Set Theory Quiz",fa01, 100);
          Assignment assignment7 = new Assignment("CPU Simulation", fa02,100);
          Assignment assignment8 = new Assignment("Memory Mapping",fa02, 100);
          summer_course1.getFacultyassignment().assignAssignment(assignment5);
          summer_course1.getFacultyassignment().assignAssignment(assignment6);
          summer_course2.getFacultyassignment().assignAssignment(assignment7);
          summer_course2.getFacultyassignment().assignAssignment(assignment8);
          assignment5.setWeight(0.4);
          assignment6.setWeight(0.6);
          assignment7.setWeight(0.8);
          assignment8.setWeight(0.2);
          // fall
          Assignment assignment9 = new Assignment("Process Scheduling", fa01, 100);
          Assignment assignment10 = new Assignment("Thread Synchronization",fa01, 100);
          Assignment assignment11 = new Assignment("SQL Query Lab", fa02,100);
          Assignment assignment12 = new Assignment("ER Diagram Design",fa02, 100);
          fall_course1.getFacultyassignment().assignAssignment(assignment9);
          fall_course1.getFacultyassignment().assignAssignment(assignment10);
          fall_course2.getFacultyassignment().assignAssignment(assignment11);
          fall_course2.getFacultyassignment().assignAssignment(assignment12);
          assignment9.setWeight(0.3);
          assignment10.setWeight(0.7);
          assignment11.setWeight(0.5);
          assignment12.setWeight(0.5);
          // winter
          Assignment assignment13 = new Assignment("Packet Routing", fa01, 100);
          Assignment assignment14 = new Assignment("Network Simulation",fa01, 100);
          Assignment assignment15 = new Assignment("Agile Sprint Demo", fa02,100);
          Assignment assignment16 = new Assignment("Test Case Design",fa02, 100);
          winter_course1.getFacultyassignment().assignAssignment(assignment13);
          winter_course1.getFacultyassignment().assignAssignment(assignment14);
          winter_course2.getFacultyassignment().assignAssignment(assignment15);
          winter_course2.getFacultyassignment().assignAssignment(assignment16);
          assignment13.setWeight(0.8);
          assignment14.setWeight(0.2);
          assignment15.setWeight(0.7);
          assignment16.setWeight(0.3);
          
          // set score for past assignment
          // each student, 4 past courses, 8 past assignments
         StudentAssignment studentRecord011 = new StudentAssignment(assignment1);
         sa011.getAssignmentRecords().put("UI Design Project", studentRecord011); 
         studentRecord011.setScore(88);
         StudentAssignment studentRecord012 = new StudentAssignment(assignment2);
         sa011.getAssignmentRecords().put("Introduction to Java", studentRecord012); 
         studentRecord012.setScore(78);
         StudentAssignment studentRecord013 = new StudentAssignment(assignment3);
         sa012.getAssignmentRecords().put("Sorting Analysis", studentRecord013); 
         studentRecord013.setScore(78);
         StudentAssignment studentRecord014 = new StudentAssignment(assignment4);
         sa012.getAssignmentRecords().put("Graph Traversal", studentRecord014); 
         studentRecord014.setScore(65);
         StudentAssignment studentRecord015 = new StudentAssignment(assignment5);
         sa013.getAssignmentRecords().put("Logic Proofs", studentRecord015); 
         studentRecord015.setScore(56);
         StudentAssignment studentRecord016 = new StudentAssignment(assignment6);
         sa013.getAssignmentRecords().put("Set Theory Quiz", studentRecord016); 
         studentRecord016.setScore(89);
         StudentAssignment studentRecord017 = new StudentAssignment(assignment7);
         sa014.getAssignmentRecords().put("CPU Simulation", studentRecord017); 
         studentRecord017.setScore(79);
         StudentAssignment studentRecord018 = new StudentAssignment(assignment8);
         sa014.getAssignmentRecords().put("Memory Mapping", studentRecord018); 
         studentRecord018.setScore(69);
         
         StudentAssignment studentRecord019 = new StudentAssignment(assignment1);
         sa021.getAssignmentRecords().put("UI Design Project", studentRecord019); 
         studentRecord019.setScore(59);
         StudentAssignment studentRecord020 = new StudentAssignment(assignment2);
         sa021.getAssignmentRecords().put("Introduction to Java", studentRecord020); 
         studentRecord020.setScore(89);
         StudentAssignment studentRecord021 = new StudentAssignment(assignment3);
         sa022.getAssignmentRecords().put("Sorting Analysis", studentRecord021); 
         studentRecord021.setScore(78);
         StudentAssignment studentRecord022 = new StudentAssignment(assignment4);
         sa022.getAssignmentRecords().put("Graph Traversal", studentRecord022); 
         studentRecord022.setScore(68);
         StudentAssignment studentRecord023 = new StudentAssignment(assignment5);
         sa023.getAssignmentRecords().put("Logic Proofs", studentRecord023); 
         studentRecord023.setScore(76);
         StudentAssignment studentRecord024 = new StudentAssignment(assignment6);
         sa023.getAssignmentRecords().put("Set Theory Quiz", studentRecord024); 
         studentRecord024.setScore(79);
         StudentAssignment studentRecord025 = new StudentAssignment(assignment7);
         sa024.getAssignmentRecords().put("CPU Simulation", studentRecord025); 
         studentRecord025.setScore(56);
         StudentAssignment studentRecord034 = new StudentAssignment(assignment8);
         sa024.getAssignmentRecords().put("Memory Mapping", studentRecord034); 
         studentRecord034.setScore(56);
         
         StudentAssignment studentRecord026 = new StudentAssignment(assignment1);
         sa031.getAssignmentRecords().put("UI Design Project", studentRecord026); 
         studentRecord026.setScore(97);
         StudentAssignment studentRecord027 = new StudentAssignment(assignment2);
         sa031.getAssignmentRecords().put("Introduction to Java", studentRecord027); 
         studentRecord027.setScore(67);
         StudentAssignment studentRecord028 = new StudentAssignment(assignment3);
         sa032.getAssignmentRecords().put("Sorting Analysis", studentRecord028); 
         studentRecord028.setScore(99);
         StudentAssignment studentRecord029 = new StudentAssignment(assignment4);
         sa032.getAssignmentRecords().put("Graph Traversal", studentRecord029); 
         studentRecord029.setScore(56);
         StudentAssignment studentRecord030 = new StudentAssignment(assignment5);
         sa033.getAssignmentRecords().put("Logic Proofs", studentRecord030); 
         studentRecord030.setScore(97);
         StudentAssignment studentRecord031 = new StudentAssignment(assignment6);
         sa033.getAssignmentRecords().put("Set Theory Quiz", studentRecord031); 
         studentRecord031.setScore(67);
         StudentAssignment studentRecord032 = new StudentAssignment(assignment7);
         sa034.getAssignmentRecords().put("CPU Simulation", studentRecord032); 
         studentRecord032.setScore(56);
         StudentAssignment studentRecord033 = new StudentAssignment(assignment8);
         sa034.getAssignmentRecords().put("Memory Mapping", studentRecord033); 
         studentRecord033.setScore(66);
         
         // set assignment for current course
         StudentAssignment studentRecord035 = new StudentAssignment(assignment9);
         sa015.getAssignmentRecords().put("Process Scheduling", studentRecord035); 
         StudentAssignment studentRecord036 = new StudentAssignment(assignment10);
         sa015.getAssignmentRecords().put("Thread Synchronization", studentRecord036); 
         StudentAssignment studentRecord037 = new StudentAssignment(assignment11);
         sa016.getAssignmentRecords().put("SQL Query Lab", studentRecord037); 
         StudentAssignment studentRecord038 = new StudentAssignment(assignment12);
         sa016.getAssignmentRecords().put("ER Diagram Design", studentRecord038); 
         
         StudentAssignment studentRecord039 = new StudentAssignment(assignment9);
         sa025.getAssignmentRecords().put("Process Scheduling", studentRecord039); 
         StudentAssignment studentRecord040 = new StudentAssignment(assignment10);
         sa025.getAssignmentRecords().put("Thread Synchronization", studentRecord040); 
         StudentAssignment studentRecord041 = new StudentAssignment(assignment11);
         sa026.getAssignmentRecords().put("SQL Query Lab", studentRecord041); 
         StudentAssignment studentRecord042 = new StudentAssignment(assignment12);
         sa026.getAssignmentRecords().put("ER Diagram Design", studentRecord042); 
         
         StudentAssignment studentRecord043 = new StudentAssignment(assignment9);
         sa035.getAssignmentRecords().put("Process Scheduling", studentRecord043); 
         StudentAssignment studentRecord044 = new StudentAssignment(assignment10);
         sa035.getAssignmentRecords().put("Thread Synchronization", studentRecord044); 
         StudentAssignment studentRecord045 = new StudentAssignment(assignment11);
         sa036.getAssignmentRecords().put("SQL Query Lab", studentRecord045); 
         StudentAssignment studentRecord046 = new StudentAssignment(assignment12);
         sa036.getAssignmentRecords().put("ER Diagram Design", studentRecord046); 
          
          
          RegisterDirectory registerdirectory = department.getRegisterdirectory();//chunyan
          RegisterProfile reg1 = registerdirectory.newRegisterProfile(person0021);
          reg1.setName("Robert Clark");
          reg1.setPhoneNumber("6261234567");
          reg1.setEmail("John1234@outlook.com");
          reg1.setOfferHour("Monday/Sunday 15:00-16:00");
          
          UserAccountDirectory useraccountdirectory = department.getUseraccountdirectory();
          UserAccount   useraccount1 = useraccountdirectory.addUserAccount(stu1, "student1", "123456");
          UserAccount   useraccount2 = useraccountdirectory.addUserAccount(stu2, "student2", "123456");
          UserAccount   useraccount3 = useraccountdirectory.addUserAccount(reg1, "register1", "123456");
          // 11-20 are faculty accounts
          UserAccount   useraccount11 = useraccountdirectory.addUserAccount(fa01, "faculty1", "123456");
          UserAccount   useraccount12 = useraccountdirectory.addUserAccount(fa02, "faculty2", "123456");
          UserAccount   useraccount13 = useraccountdirectory.addUserAccount(fa03, "faculty3", "123456");
          UserAccount   useraccount14 = useraccountdirectory.addUserAccount(fa04, "faculty4", "123456");
          UserAccount   useraccount15 = useraccountdirectory.addUserAccount(fa05, "faculty5", "123456");
          UserAccount   useraccount16 = useraccountdirectory.addUserAccount(fa06, "faculty6", "123456");
          UserAccount   useraccount17 = useraccountdirectory.addUserAccount(fa07, "faculty7", "123456");
          UserAccount   useraccount18 = useraccountdirectory.addUserAccount(fa08, "faculty8", "123456");
          UserAccount   useraccount19 = useraccountdirectory.addUserAccount(fa09, "faculty9", "123456");
          UserAccount   useraccount20 = useraccountdirectory.addUserAccount(fa010, "faculty10", "123456");
          
          AdmainProfile adminProfile = new AdmainProfile(person0031);  // kailu
          UserAccount useraccount4 = useraccountdirectory.addUserAccount(adminProfile, "admin", "123456");
          
          
          return department;
     }
}
