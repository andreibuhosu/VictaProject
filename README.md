# Victa
Victa is a medical website that was created to help medical students improve their diagnosing skills.

### Victa Home Page
![victahome](/uploads/11489a211033359e49ee831f4bb73547/victahome.png)

### Victa Login Page
![login](/uploads/e1162826ffbe1fcb36b7fbcdf091e3e7/login.png)

### Victa Dashboard
![dashboard](/uploads/6c3256cdadc354448970b39c1f9a9e26/dashboard.png)

## Motivation
During lockdown students were not allowed onto campus. This meant that they also couldn't go to the hospital and treat and talk to patients.
Victa allows students to still treat patients without having to leave the safety of their bedroom. Users can view patients , treat patients and recieve a grade for their work.

## Features:
* View Patients
* Diagnose Patients
* Autogenerated Likely Diagnoseses
* Mark and Grade Student work
* View Unmarked and Marked work
* View Feedback
* Automatic Emails after New Unmarked Case Avaliable

## Prerequisites:
* Spring Boot 2.6.1
* MySQL Server > 5.7
* Gradle 7.2

## Installation:
* Download and install the prerequisites
* Clone and download this repository from GitLab
* Go to the VictawebsiteDB folder in this repository and download it
* Go to MySQL and make sure **VictawebsiteDB** is there
* Go to `src/main/resources/application.properties` add your username and password. This allows MySQL to connect to Victa.

## Test Accounts
**_Student Account_**
* Username: testdoctor
* Password: test

**_Teacher Account_**
* Username: Mr Henry
* Password: teacher

You can use the Teacher account to mark student cases or you can make your own account.
## Tests
You can test Victa by running through the whole program as a new user.
* Victa has been tested vigorously. It passes all edge cases also.

