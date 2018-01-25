# spring-routing-datasources
Sample project to demonstrate programmatically routing datasource with spring. 
This project was implemmented with spring mvc, spring rest and spring security. 
It´s just a example of how to make a routing datasource programmatically.
The authorization is a basic http and MySQL5 that was used as database, but any database can be used to.    

## Getting Started

Import the eclipse project as Existing Maven Project and install it.   

### Prerequisites

* [Maven](https://maven.apache.org/) - Dependency Management
* [TomCat](https://tomcat.apache.org/download-70.cgi) - Server Application 
* [MySQL5] (https://www.mysql.com/downloads/)- Database

### Installing

- Run mvn install in maven command line (e.g. mvn install) or IDE
- Execute the dump files company and companyone on src/main/resources in your database
- Configure the database informations like url, username and password in src/main/resources/application.properties
- Deploy the project in Server Application

## Deployment

To build the project just package with maven command line or IDE (like Eclipse) e.g. mvn clean package

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

For the versions available, see the [tags on this repository](https://github.com/FilipeSoares/spring-routing-datasources/tags). 

## Authors

* **Filipe Oliveira** - *All sample* - [FilipeSoares](https://github.com/FilipeSoares)

See also the list of [contributors](https://github.com/FilipeSoares/spring-routing-datasources/contributors) who participated in this project.
