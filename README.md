# LibraryManagementApplication 🌱
I made a Backend Application to perform operation like Issue book & Return book from library , created RestFul APIs Service Using java, SpringBoot,postman for Library Management Application.
In this project user can Issue book from the Library and Return book to library if user return book after due date application generate fine.

___________________________________________________________________________________________________________________________________________________________

# ER Diagram - Library Management Application

![Er](https://user-images.githubusercontent.com/101422764/216533447-d67995e3-b676-45c8-8be1-82b5147e2419.png)

___________________________________________________________________________________________________________________________________________________________


# Tech Stacks: 🌱

* Java
* Spring Boot
* Maven
* Postman
* Lombok
* MySql
* SpringData Jpa
* Hibernate

___________________________________________________________________________________________________________________________________________________________

# Modules 🌱

* User Module
* Book Module

___________________________________________________________________________________________________________________________________________________________

# Features 🌱

* User & Book validation 

# User Features:

* Pre filled data in the data base
* User can Issue Book from the library only if it contains less than 5 books.
* User can return the book to the library if user return book after due date application raise fine amount to user.

___________________________________________________________________________________________________________________________________________________________

# Installation & Run

* Before running the API server, you should update the database config inside the [application.properties]() file. 
* Update the port number, username and password as per your local database config.

```
    server.port=9090

    spring.datasource.url=jdbc:mysql://localhost:3306/libraryManagementApplication
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root

```

___________________________________________________________________________________________________________________________________________________________

# API Root Endpoint

* General API  `https://localhost:8888/`
* Issue Book API http://localhost:9090/bookIssue/
* Return Book API http://localhost:9090/bookReturn/{userId}/{bookId}

___________________________________________________________________________________________________________________________________________________________

# Following pictures will help to understand flow of the Application and API's of Library Management Application

# Start tomcat Server
![tomcatServer](https://user-images.githubusercontent.com/101422764/216525231-72c5bf27-35e4-4d9b-b608-722df4c90fa3.png)

# User Data
![User](https://user-images.githubusercontent.com/101422764/216524757-f74c9d79-d5e0-4ff9-94c4-7a766490eea2.png)

# Book Data
![BookData](https://user-images.githubusercontent.com/101422764/216524852-8fae7595-634b-431b-af97-4d3fc207c744.png)

# Issue Book
* Issue Book API http://localhost:9090/bookIssue/
 ![IssueBook](https://user-images.githubusercontent.com/101422764/216524947-06e33535-1685-41d3-8661-e010e89ebb8e.png)

# Return Book 
* Return Book API http://localhost:9090/bookReturn/{userId}/{bookId}
![ReturnBook](https://user-images.githubusercontent.com/101422764/216525118-e2083199-4b00-4e88-b1b0-c391102579de.png)



