# Spring Boot JWT Authentication

This is a simple Spring Boot application that demonstrates how to implement authentication and authorization using JSON Web Tokens (JWT).

## Features
- User authentication with JWT
- Stateless session management
- Secure password storage with BCrypt
- In-memory user details manager
- Secure endpoints with role-based access control

## Getting Started
### Prerequisites
- Java 11 or higher
- Maven 3.6.3 or higher
- Git (optional, for cloning the repository)

### Installation
1) Clone the repository:

	$ git clone https://github.com/NsanVarela/JWT-SpringSecurity-Auth-Application.git
	$ cd springboot-jwt-auth

2) Configure your JWT secret key:

	JWT_KEY=your_secret_key

3) Build the project

	$ mvn clean install

4) Run the application

	$ mvn spring-boot:run


## Example Request
###Authentication

Request:

	POST /login
	Content-Type: application/json
	{ "username": "user", "password": "password" }

Response:

	{ "token": "your_jwt_token" }

### Accessing Secure Endpoint

Request:

	GET /secure
	Authorization: Bearer your_jwt_token

Response:

	{ "message": "This is a secure endpoint." }
	
Configuration
The JWT key is configured via an environment variable JWT_KEY. Make sure this variable is set before running the application.

## Project Structure
- com.jwt.auth.configuration: Contains the security configuration.
- com.jwt.auth.controller: Contains the controllers for handling authentication and secure endpoints.
- com.jwt.auth.model: Contains the user model.
- com.jwt.auth.service: Contains the service layer for user details.