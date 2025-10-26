# Digital University System – Role-Based Access Control Implementation

## 1. Project Title
**Digital University System with Role-Based Access Control**

---

## 2. Team Information

This project was completed by a team of four members. Each team member was responsible for one specific use case and related system functionalities.

- **Kailu Chen (NUID: 002565287):** Administrator Module  
- **Lu Wang (NUID: 002503062):** Faculty Module  
- **Zuolin Sun (NUID: 002522648):** Student Module  
- **Chunyan Li (NUID: 002522119):** Registrar Module  

---

## 3. Project Overview

This project implements a Digital University System that supports multiple user roles with secure authentication and role-based access control.  
The purpose of this project is to integrate the provided Java packages and ensure the correct execution of all four use cases.

### Main objectives include:
- Enabling authentication and controlled access for different roles  
- Providing separate functionalities for Administrator, Faculty, Student, and Registrar  
- Supporting course management, enrollment, transcript, and academic record operations  

### Key features implemented:
- Login and logout authentication  
- Role-based access restrictions  
- Course management and student enrollment  
- Syllabus upload, view, and removal  
- Grade submission and GPA calculation  

---

## 4. Installation and Setup Instructions

### Prerequisites:
- Java JDK version 17 or above  
- NetBeans IDE (recommended) or IntelliJ IDEA  
- Windows, macOS, or Linux operating system  

### Setup Steps:
1. Download or clone the project repository.  
2. Open the project in NetBeans.  
3. Clean and build the project.  
4. Run the `MainJFrame` class to start the application.  

---

## 5. Authentication and Access Control

Authentication is performed through a login screen. Users must enter a valid username and password to gain access. Logging out ends the session and returns the user to the login screen.

### Authorization rules:
- **Administrator:** Create and manage users, organizations, departments, and assign roles  
- **Faculty:** Manage courses they teach, upload syllabus, view enrolled students, and submit grades  
- **Students:** Register for courses, view schedules, and check transcripts and GPA  
- **Registrar:** Manage the course catalog, master schedule, and track academic records  

Access is strictly limited to the features allowed for each role.

---

## 6. Features Implemented

### Administrator:
- Create and manage user accounts  
- Assign different user roles  
- Manage departments and organizations  

### Faculty:
- View assigned course offerings  
- Upload, view, and remove syllabus files  
- Manage and update faculty profile  
- View enrolled students  
- Submit final grades and update transcripts (Score 60 or above earns credits and counts towards GPA; below 60 earns no credits)  

### Student:
- Browse course offerings  
- Register and drop courses with credit limit validation  
- View transcript, including term GPA and cumulative GPA  

### Registrar:
- Manage semester course offerings and scheduling  
- Assign faculty and set course capacity  
- Process student enroll/drop requests  
- Track tuition payments  
- Generate financial and enrollment reports  

---

## 7. Usage Instructions

### Steps to use the system:
1. Launch the program and log in with a valid user account.  
2. The system will automatically redirect the user to the correct dashboard based on their role.  
3. Use the available menu options to perform authorized actions.  

### Example Scenarios:
- **Administrator:** Create a new Faculty user and assign them to a department  
- **Faculty:** Upload a syllabus for a course and submit student grades  
- **Student:** Register for a course and later view updated GPA  
- **Registrar:** Update master course schedule and review student academic records  

---

## 8. Testing Guide

### How to test the system:
- Test login using valid and invalid credentials  
- Log in under each role to verify role-specific screens and functions  
- Attempt to access features not permitted for that role to confirm access control works correctly  

### Example test cases:
- Student tries to modify course catalog (should be denied)  
- Faculty uploads a syllabus and verifies it can be viewed  
- After grades are entered, student transcript should update correctly  

---

## 9. Challenges and Solutions

### Challenges encountered:
- Integrating multiple use case modules into one system  
- Ensuring proper access control for all screens  
- Implementing accurate GPA and credit calculation  

### Solutions:
- Centralized login routing and access control validation  
- Built role-based UI navigation to restrict functions  
- Added clear GPA rules and validation to avoid incorrect results  

---

## 10. Future Enhancements

Possible improvements for future versions:
- Add database storage instead of in-memory data saving  
- Provide email or system notifications to users about enrollment or grade updates  
- Add a web-based or mobile UI for easier accessibility  
- Add waitlist and auto-enrollment features for full courses  

---

## 11. Contribution Breakdown

Each team member contributed to coding, testing, documentation, and integration.

- **Kailu Chen:** Admin module coding, integration testing  
- **Lu Wang:** Faculty module coding, syllabus and grading logic  
- **Zuolin Sun:** Student UI, course registration, GPA calculation  
- **Chunyan Li:** Registrar module, catalog and schedule management  

All team members participated in debugging, documentation, and final review.  

---
