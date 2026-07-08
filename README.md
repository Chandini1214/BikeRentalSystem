#  Bike Rental Management System

A Java-based web application developed to manage bike rentals efficiently. The system allows users to log in, view available bikes, and perform CRUD (Create, Read, Update, Delete) operations on bike records. The application follows the MVC architecture using JSP, Servlets, JDBC, and MySQL.



##  Features

- 🔐 User Login & Logout
- ➕ Add New Bike
- 👀 View Available Bikes
- ✏️ Update Bike Details
- ❌ Delete Bike Records
- 📂 CRUD Operations using JDBC
- 🔒 Session Management using Servlets
- 💾 MySQL Database Integration



##  Tech Stack

### Programming Language
- Java

### Backend
- JSP
- Servlets
- JDBC

### Frontend
- HTML
- CSS

### Database
- MySQL

### Server
- Apache Tomcat

### IDE
- Eclipse IDE

### Version Control
- Git & GitHub



## 📁 Project Structure
```

BikeRentalSystem
│
├── src/main/java
│   ├── Controller
│   │   ├── AddBikeServlet.java
│   │   ├── DeleteBikeServlet.java
│   │   ├── LoginServlet.java
│   │   ├── LogoutServlet.java
│   │   ├── UpdateBikeServlet.java
│   │   └── ViewBikeServlet.java
│   │
│   └── model
│       ├── Bike.java
│       └── BikeDAO.java
│
├── src/main/webapp
│   ├── css
│   │   └── style.css
│   ├── addBike.jsp
│   ├── deleteBike.jsp
│   ├── home.jsp
│   ├── login.html
│   ├── navbar.jsp
│   ├── updateBike.jsp
│   └── viewBike.jsp
│
└── README.md
```


##  How to Run the Project

1. Clone this repository

 ```bash
git clone https://github.com/Chandini1214/BikeRentalSystem.git
```

2. Import the project into Eclipse IDE.

3. Configure Apache Tomcat Server.

4. Create a MySQL database.

5. Import the SQL file.

6. Update database username and password in BikeDAO.java.

7. Run the project on Tomcat.

8. Open your browser:
```http://localhost:8080/BikeRentalSystem/```


## 🎯 Future Enhancements

- User Registration
- Online Bike Booking
- Payment Gateway Integration
- Email Notifications
- Responsive UI
- Search & Filter Bikes
- Admin Dashboard



##  Developed By

**Chandini Daneti**

B.Tech - Information Technology (2026)

LinkedIn: https://linkedin.com/in/chandinidaneti1214

GitHub: https://github.com/Chandini1214



##  License

This project is developed for educational purpose.
