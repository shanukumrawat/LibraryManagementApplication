# LibraryManagementApplication 🌱
I made a Backend Application to perform operation like Issue book & Return book from library , created RestFul APIs Service Using java, SpringBoot,postman for Library Management Application.
In this project user can Issue book from the Library and Return book to library if user return book after due date application generate fine.

___________________________________________________________________________________________________________________________________________________________

#ER Diagram

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

# User Data
![User](https://user-images.githubusercontent.com/101422764/216524757-f74c9d79-d5e0-4ff9-94c4-7a766490eea2.png)








