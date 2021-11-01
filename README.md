# default-stack

A proof-of-concept microservice with basic entities and mapping layer. Built with
Spring boot/Hibernate/Mapstruct

##How to run
Just update spring:datasource:url with the jdbc url `jdbc:h2:~/test`, then 
execute `gradlew bootJar` task and run the uberjar!

##Check the Script!
 * [swagger-ui](http://localhost:8080/swagger-ui/)
 * check `test/resources/static` to have some example requests