# 🔐 SQL Injection AND Prevention Demo

A full-stack web application that demonstrates how **SQL Injection** can compromise authentication when SQL queries are built using `Statement`, and how **PreparedStatement** prevents these attacks by using parameterized queries.

This project is built using **React**, **Spring Boot**, **JDBC**, and **MySQL**, making it an excellent learning resource for understanding secure database programming and authentication.

---

## 📖 Project Overview

SQL Injection is one of the most common web application security vulnerabilities. It occurs when user input is directly concatenated into SQL queries, allowing attackers to manipulate the query and potentially bypass authentication or access sensitive data.

This project demonstrates both:

* ❌ An insecure login implementation using `Statement`
* ✅ A secure login implementation using `PreparedStatement`

Users can compare the behavior of both approaches using the same login interface.

---

## 🚀 Features

* 👤 User Registration
* 🔐 User Login
* ❌ Vulnerable authentication using `Statement`
* ✅ Secure authentication using `PreparedStatement`
* 💻 React frontend with a clean user interface
* 🌐 REST APIs built with Spring Boot
* 🗄️ MySQL database integration using JDBC
* ⚠️ Live SQL Injection demonstration
* 🛡️ Secure coding example using parameterized queries

---

## 🛠️ Tech Stack

### Frontend

* React
* Axios
* CSS

### Backend

* Spring Boot
* Java
* JDBC
* Lombok

### Database

* MySQL

---

## 📁 Project Structure

```
SQLInjectionDemo
│
├── Frontend (React)
│   ├── components
│   │   ├── Register.jsx
│   │   └── Login.jsx
│   ├── services
│   │   └── api.js
│   ├── App.jsx
│   └── App.css
│
└── Backend (Spring Boot)
    ├── controller
    ├── service
    ├── dao
    ├── model
    ├── config
    └── application.properties
```

---

## 🗄️ Database Schema

Create the following database and table before running the project.

```sql
CREATE DATABASE sql_injection_demo;

USE sql_injection_demo;

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL
);
```

---

## ⚙️ Backend Configuration

Configure your MySQL credentials in `application.properties`.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/sql_injection_demo
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

Replace `YOUR_PASSWORD` with your MySQL password.

---

## ▶️ Running the Project

### Backend

1. Open the Spring Boot project.
2. Configure MySQL credentials.
3. Run the application.

The backend starts on:

```
http://localhost:8081
```

> Update the port if your project uses a different one.

---

### Frontend

Install dependencies:

```bash
npm install
```

Start the React application:

```bash
npm run dev
```

The frontend will be available at:

```
http://localhost:5173
```

---

## 📡 REST API Endpoints

### Register User

```
POST /user/register
```

Example Request

```json
{
  "username": "jyothish",
  "password": "1234"
}
```

---

### Login Using Statement (Vulnerable)

```
POST /user/login-statement
```

Example Request

```json
{
  "username": "jyothish",
  "password": "1234"
}
```

---

### Login Using PreparedStatement (Secure)

```
POST /user/login-prepared
```

Example Request

```json
{
  "username": "jyothish",
  "password": "1234"
}
```

---

# 💥 SQL Injection Demonstration

## Vulnerable Login

The vulnerable endpoint constructs SQL queries by concatenating user input.

Example payload:

```
Username:
' OR '1'='1' --

Password:
anything
```

Generated SQL query:

```sql
SELECT * FROM users
WHERE username=''
OR '1'='1' -- '
AND password='anything';
```

Since the injected condition evaluates to true and the remaining part of the query is commented out, authentication is bypassed.

---

## Secure Login

The secure endpoint uses `PreparedStatement`.

```java
String sql =
"SELECT * FROM users WHERE username=? AND password=?";
```

User input is treated strictly as data rather than executable SQL, preventing the injected text from modifying the SQL query.

The same payload therefore results in:

```
Invalid Credentials
```

---

## 🔍 Statement vs PreparedStatement

| Statement                             | PreparedStatement                                      |
| ------------------------------------- | ------------------------------------------------------ |
| Builds SQL by concatenating strings   | Uses parameterized queries                             |
| Vulnerable to SQL Injection           | Resistant to SQL Injection                             |
| SQL query changes based on user input | Query structure remains fixed                          |
| Not recommended for user input        | Recommended for authentication and database operations |

---

## 📸 Demonstration Flow

1. Register a new user.
2. Log in with valid credentials using both login methods.
3. Test the vulnerable login with a SQL Injection payload.
4. Observe that authentication is bypassed.
5. Test the same payload with the secure login.
6. Observe that authentication fails because `PreparedStatement` treats the input as plain text.

---

## 📚 Learning Outcomes

This project helps you understand:

* SQL Injection attacks
* JDBC `Statement`
* JDBC `PreparedStatement`
* Parameterized queries
* REST API development using Spring Boot
* React form handling
* Axios HTTP requests
* Authentication flow
* Secure database programming
* Full-stack application development

---

## ⚠️ Disclaimer

This project intentionally includes a vulnerable login endpoint for educational purposes only. It is designed to demonstrate how SQL Injection works and how it can be prevented. The vulnerable implementation should **never** be used in production applications.

---

## 👨‍💻 Author

**Jyothish R**

If you found this project helpful, feel free to ⭐ star the repository and use it as a learning resource for understanding SQL Injection prevention and secure coding practices.
