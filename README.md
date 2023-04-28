# SpringBootAssignmentFirst

A sample spring boot application to create CRUD API's.Created this application using spring Initializr And implemented Spring security JWT token based authentication.

Technology used 
   1. Spring boot
   2. Spring  Data JPA
   3. Mysql database
   4. Spring Security ( JWT token based Authentication)

Description

   This application have four entity Employee,Department,User,Roles. And department id is foreign key in Employee table. The relation between Department to Employee is One To Many and between Employee to Department is Many To One.And relation between user and roles is many to many.And This application has two public API : login and user creation.
using created User APi, we can create user and using these credential we can login this will generate a JWT token. using this token user can access authorized private API.


Depedency

   1. Model Mapper : To mapping Dto object to entity or entity to Dto object
   2. spring-boot-starter-validation : Used to validate entity class property
   3. lombok : used for getter, setter, constructor, toString() 
   4. mysql-connector-j : used for mysql driver dependency
   5. spring-boot-devtools: used for live reload , faster application restart
   6. spring-boot-starter-data-jpa : used for spring data JPA support
   7. spring-boot-starter-web : used for creating web application
   8. spring-boot-starter-security: used for Spring Security
   9. jjwt-api : used for JWT token based Authentication API
   10. jjwt-impl : used for JWT token based Authentication API implementation class
   11. jjwt-jackson : used for JWT token based Authentication and handle serialzer exception

version:
   1. spring boot version is 2.7.11
   2. JDK version is 17
   3. MySql version is 8
   4. JWT version 0.11.5

MySql Database detail:
   
    Port : 9090
    username : root
    Database name : emp_dept_detail
    table : emp,dept

Note: To run this application, Mysql Database should be connected and database 'emp_dept_detail' should be created.
 
