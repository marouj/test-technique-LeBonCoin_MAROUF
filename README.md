# Ilyess MAROUF

## Technical Test -LeBonCoin

This directory contains a project that handles the REST API with spring boot.
The main functionality is to retrieve current FireFighter.


## Use it

This application can be run with this following command:
	- java -jar technical-test-0.0.1-SNAPSHOT.jar

The uri is :
	- http://localhost:9090

Swagger documentation for rest controller and rest api is available at this uri :
    - http://localhost:9090/swagger-ui.html



## Features

This Rest API have these REST routes: 

- GET -> /FireFighter/new
- GET -> /FireFighter/{id}
- GET -> /FireFighter/
- POST -> /FireFighter/new

Detail about these routes are available at this uri :

 	- http://localhost:9090/swagger-ui.html#/fire-fighter-controller


## Structure

This project follows the springboot structure :

.
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── leboncoin
│   │   │           └── technicaltest
│   │   │               ├── TechnicalTestApplication.java
│   │   │               ├── configuration
│   │   │               │   └── SwaggerConfig.java
│   │   │               ├── dao
│   │   │               │   ├── TeamDao.java
│   │   │               │   └── TeamDaoI.java
│   │   │               ├── model
│   │   │               │   ├── FireFighter.java
│   │   │               │   └── Team.java
│   │   │               └── web
│   │   │                   └── controller
│   │   │                       └── FireFighterController.java
│   │   └── resources
│   │       ├── application.properties
│   │     
│   └── test
│       └── java
│           └── com
│               └── leboncoin
│                   └── technicaltest
│                       ├── TechnicalTestApplicationTests.java
│                       ├── model
│                       │   ├── FireFighterTests.java
│                       │   └── TeamTests.java
│                       └── web
│                           └── controller
│                               └── FireFighterControllerTests.java
├── target
│   ├── technical-test-0.0.1-SNAPSHOT.jar
