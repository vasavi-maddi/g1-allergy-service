from openjdk:17
expose 8080
ADD target/g1-allergy-service-0.0.1-SNAPSHOT.jar g1-allergy-service.jar
ENTRYPOINT ["java","-jar","/g1-allergy-service.jar"]