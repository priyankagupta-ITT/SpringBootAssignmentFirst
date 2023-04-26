# SpringBootAssignmentFirst

A sample spring boot application to create CRUD API's.Created this application using spring Initializr

Technology used 
   1. Spring boot
   2. Spring  Data JPA
   3. Mysql database

Description

   This application have two entity Employee and Department. And department id is foreign key in Employee table. The relation between Department to Employee is One To Many and between Employee to Department is Many To One.

Depedency

   1. Model Mapper : To mapping Dto object to entity or entity to Dto object
   2. spring-boot-starter-validation : Used to validate entity class property
   3. lombok : used for getter, setter, constructor, toString() 
   4. mysql-connector-j : used for mysql driver dependency
   5. spring-boot-devtools: used for live reload , faster application restart
   6. spring-boot-starter-data-jpa : used for spring data JPA support
   7. spring-boot-starter-web : used for creating web application

version:
   1. spring boot version is 2.7.11
   2. JDK version is 17
 
