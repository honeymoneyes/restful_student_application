Technologies Used:

--- Spring Boot
--- Spring Data JPA
--- PostgreSQL Database
Configuration Steps:

Clone the Application:

Clone the repository using the following command:
git clone https://github.com/honeymoneyes/restful_student_application

Create a PostgreSQL Database:
Create a new PostgreSQL database named "student_repository".

Configure PostgreSQL Username and Password:
Open the file server/src/main/resources/application.properties and update the following properties with your PostgreSQL installation details:

spring.datasource.username=YOUR_POSTGRESQL_USERNAME
spring.datasource.password=YOUR_POSTGRESQL_PASSWORD

Run the Application Using Maven:
Open a terminal, navigate to the project root directory (restful_student_application), and run the following command:

mvn spring-boot:run

The application will start running at http://localhost:8080/api/v1/student.
