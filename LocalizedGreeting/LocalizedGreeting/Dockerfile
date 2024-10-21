FROM maven:latest

WORKDIR /app

COPY pom.xml /app/

RUN mvn package

cmd ["java", "-jar", "target/test.jar"]