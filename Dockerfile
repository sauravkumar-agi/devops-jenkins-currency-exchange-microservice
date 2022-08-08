FROM openjdk:11
EXPOSE 8100
ADD */**.jar spring-boot-microservice-currency-conversion.jar 
ENTRYPOINT ["java","-jar","/spring-boot-microservice-currency-conversion.jar"]
