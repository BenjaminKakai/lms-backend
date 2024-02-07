**LMSBackend README**

Welcome to the LMSBackend project, a comprehensive backend solution designed using Java and Spring Boot, tailored for managing a Learning Management System (LMS) with a focus on book management, user authentication, and interactions with a PostgreSQL database. This project leverages the Eureka client for service discovery, making it an integral part of microservice-based architectures.

**Project Overview**

LMSBackend provides a robust set of functionalities for user management, authentication, and book management, enabling users to register, login, manage books, and track current reads. It's built on Spring Boot, utilizing Spring Security for authentication and JWT for secure token management.

**Key Features**

User registration and authentication

JWT token generation and validation

Book management (add, fetch, delete)

Current reads management (assign, fetch, return)

PostgreSQL as the database backend

Eureka client integration for service discovery


**Getting Started**

**Prerequisites**

JDK 17

PostgreSQL

Gradle (compatible with the project's Gradle wrapper)

**Setup and Installation**

**Clone the repository:**

git clone https://github.com/yourusername/lmsbackend.git

cd lmsbackend

**Configure PostgreSQL:**

Ensure you have PostgreSQL running and create a database named lmsbackend. Update src/main/resources/application.properties with your database username and password.


**Run the application:**

**Refresh project dependencies:**

./gradlew --refresh-dependencies

**Build the project:**

./gradlew clean build

./gradlew build # Redundant if the previous command was successful

**Start the application:**

./gradlew bootRun

**Using the Application**

**User and Authentication**

**Register a new user:**

curl -X POST http://localhost:8081/api/auth/register -H "Content-Type: application/json" -d '{"username":"Naomi","password":"Naomi1234"}'

**Login and generate JWT Token:**

# Use the correct JWT token received upon logging in
curl -X GET http://localhost:8081/api/users/profile -H "Authorization: Bearer <Your_JWT_Token>" -H "Content-Type: application/json"

**Book Management**

**Fetch all books:**

curl http://localhost:8081/api/books

**Add a new book:**

curl -X POST -u Benjamin:co37x74bob -H "Content-Type: application/json" -d '{"isbn":"9780142437209","name":"To Kill a Mockingbird","author":"Harper Lee","available":true}' http://localhost:8081/api/books

**Current Reads Management**

**Assign a book to a user:**

curl -X POST http://localhost:8081/api/currentReads/assign -H "Content-Type: application/json" -H "Authorization: Bearer <Your_JWT_Token>" -d '{"userId": 22, "bookId": 8, "startDate": "2024-01-01", "endDate": "2024-02-01"}'

**Database Interaction**

Direct database interactions can be performed using PostgreSQL commands:**

sql**

**-- Select a specific user by username**

SELECT id, username FROM users WHERE username = 'Linda';

**-- Check usernames and passwords**

SELECT username, password FROM users;

**Development and Maintenance**

This project is open for contributions. Please ensure you follow the coding standards and write tests for new features. For bugs or feature requests, open an issue in the repository.

**Additional Utility Commands**

**Generate a random Base64 encoded string for JWT secret or other purposes:**

openssl rand -base64 32

**Contact**

For any queries or further assistance with LMSBackend, please open an issue in the project's GitHub repository.

**Simple Illustration of calling the Books from the Frontend**
![image](https://github.com/BenjaminKakai/lms-backend/assets/114109979/a09c1303-31bb-43ac-b5b3-18b32e289eb0)


You can Check the Entire Frontend Code from here; https://github.com/BenjaminKakai/LibrarymanagementSystem-frontend.git
