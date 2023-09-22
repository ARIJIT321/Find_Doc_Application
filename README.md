# Health care application

## Description

This appllication allows us to add and delete Doctors and Patients. This also gives
Patients suggestion about doctors that present on that location based on their symptoms

## Features

- Doctor and Patient Management: Users can add and delete doctors and patients.
- Doctor Suggestions: Patients receive suggestions about available doctors in their
  location based on their symptoms.

### Project Setup

1. Clone the repository: `git clone https://github.com/ARIJIT321/Find_Doc_Application.git`

2. Import
   <br>--I have build this assignment on spring tool suit. Our main goal here is to import the folder in any IDE.

3. Open any IDE (like STS)
4. click on the file
5. click on Project from file system/click on import
6. choose existing maven project
7. There will be an option for browse, choose the folder where you cloned the repo
8. click on finish

9. Let your IDE download all the necessary dependencies and library.
10. Open MySql database and create a database with the name "Task" Or you can choose any name.
11. If you want use any other name for your database then go to this loction -FindDoctor\src\main\resources\application.properties.
12. change the name of the database - spring.datasource.url=jdbc:mysql://localhost:3306/{Name of your database}

13. Right-click on "FindDoctor"
14. Go to run as and run it as springboot application

15. The server will start running on `http://localhost:8888`.
16. If you want to change the server you can do that in the appliction.properties file present in -FindDoctor\src\main\resources\application.properties.properties
17. There will be line "server.port=8888", here you can change the port no from 8888 to any port that is available in your system.

## API Endpoints

The Application provides the following API endpoints:

## Doctor Controller Endpoints

### Add a Doctor

- **HTTP Method:** POST
- **Endpoint:** `/doc/addDoc`
- **Description:** Add a new doctor.
- **Request Body:** JSON representation of the doctor.
- **Response:** Returns the created doctor with HTTP status code 201 (Created).

### Delete a Doctor

- **HTTP Method:** DELETE
- **Endpoint:** `/doc/deleteDoc/{id}`
- **Description:** Delete a doctor by their ID.
- **Path Variable:** `id` - The ID of the doctor to delete.
- **Response:** Returns the deleted doctor with HTTP status code 200 (OK).

## Patient Controller Endpoints

### Add a Patient

- **HTTP Method:** POST
- **Endpoint:** `/patients/addPatients`
- **Description:** Add a new patient.
- **Request Body:** JSON representation of the patient.
- **Response:** Returns the created patient with HTTP status code 201 (Created).

### Delete a Patient

- **HTTP Method:** DELETE
- **Endpoint:** `/patients/deletePatient/{id}`
- **Description:** Delete a patient by their ID.
- **Path Variable:** `id` - The ID of the patient to delete.
- **Response:** Returns the deleted patient with HTTP status code 202 (Accepted).

### Suggest Doctors for a Patient

- **HTTP Method:** GET
- **Endpoint:** `/patients/suggestDoc/{id}`
- **Description:** Get a list of doctors suggested for a patient based on their ID.
- **Path Variable:** `id` - The ID of the patient for whom doctor suggestions are required.
- **Response:** Returns a list of suggested doctors with HTTP status code 202 (Accepted).

These API endpoints allow you to manage doctors and patients and provide doctor suggestions to patients within your healthcare application.

you can test the endpoints using postman or any tool you see fit -

Postman collection link- https://www.postman.com/winter-zodiac-130206/workspace/health-care/collection/24969666-bab4b128-be12-4c65-9849-f6fb8bd70285?action=share&creator=24969666

Postman Fork link - [![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/24969666-bab4b128-be12-4c65-9849-f6fb8bd70285?action=collection%2Ffork&source=rip_markdown&collection-url=entityId%3D24969666-bab4b128-be12-4c65-9849-f6fb8bd70285%26entityType%3Dcollection%26workspaceId%3D00161edf-c2a5-4c42-930e-4299b57e8fc6)
