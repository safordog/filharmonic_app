# Philharmonic app
### About
This is an imitation of service for booking tickets to the philharmonic.
### Functionality
- user registration and authentication
- adding information about philharmonic halls to the database
- event creation
- look up an event information
- adding orders to the custom cart and confirming orders
- a user with the role *"USER"* is able to read the data, *"ADMIN"* can read, add and change it
### Technologies:
- Java 8
- Hibernate  
- Spring MVC
- Spring Security
- MySQL
- Log4j  
- Maven
- Git
### How to use
- clone the repository
- configure the database connection file - *"src/main/resources/db.properties"*:
  {<br/>
    - db.url="jdbc:mysql://localhost:3306/**your database name**?serverTimezone=GMT";<br/>
    - db.user="**your database username**";<br/>
    - db.password="**your database password**";<br/>
      }<br/>
- configure Tomcat:
  {<br/>
  **IntellijIdea:**
    - Run –>> Edit Configurations…
    - Clicks **+** icon, select Tomcat Server –>> Local<br/>
    - Clicks on the **fix** icon and choose the exploded war version
    - On the **deployment** tab in **application context** field remove data and put **"/"**;
    - Press **OK**.
      }<br/>
- to log in as admin: *{"name":"bob@i.ua", "password":"123"}* or as user: *{"name":"alice@i.ua", "password":"1234"}*;
- use [Postman](https://www.postman.com/) or something similar to create queries:
  {<br/>
  you can see all current URLs in the corresponding controllers: *"src/main/java/spring/controller"*<br/>
  For example:
  - HTTP's method GET + *http://localhost:8080/concerts* - returns information about all events;
  - HTTP's method POST + *http://localhost:8080/concerts* + 
    request body: {"concertTitle":"some title", "concertDescription":"some description"} - adds information about new event.<br/>
    }<br/>