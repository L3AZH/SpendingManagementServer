# SpendingManagementServer

## Installation on local

Use the ERDMysqlDiagram file to init database of Mysql server ( google it)

Create a application.properties at the path 
```bash
SpendingManagement\SpendingManagement\src\main\resources\application.properties
```
Content of the file should be like below:

```bash
#Server port configuration
server.port=<portnumber> (ex: server.port=123456)

#Basic Auth configuration
basic.auth.name=<your username> (ex: basic.auth.name=john)
basic.auth.password=<your password> (ex: basic.auth.name=john123)

#Database configuration (the project is config for mysql server)
spring.datasource.drive-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/<your db name> (ex: spring.datasource.url=jdbc:mysql://localhost:3306/spendingmanagementdb)
spring.datasource.username=root
spring.datasource.password=1234

#JPA / HIBERNATE configuration
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.properties.hibernate.dialect.storage_engine=innodb
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl

#JWT configuration
jwt.credential=<your credential> (ex: jwt.credential=96d9632f363564cc3032521409cf22a852f2032eec099ed5967c0d000cec607a)
jwt.expiration=86400000
```

## Build project

1. Use cmd( or gist bash) navigate to project path( ex: D:/SpendingManagementServer)
2. Use gradle to build project via cmd( or git bash), if your local machine already have gradle 
  ```bash
  $ gradle build
  ```
  If not
  ```bash
  $ ./gradlew build
  ```
  **note: after running comamnd above, the file jar should be generated at path SpendingManagementServer/build/libs

3. Navigate to path which the file jar was generated, use cmd( or git bash) with comamnd below:
  ```bash
  $ java -jar ./filejarname.jar
  ```
  **note: filejarname example: SpendingManagement-0.0.1-SNAPSHOT.jar, after you run the file jar, the server will running on the port you setup
  
 
