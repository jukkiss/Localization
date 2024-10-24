# Use Maven to build the application
FROM maven:latest AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and source code
COPY pom.xml /app/
COPY src /app/src

# Package the application (this will create the JAR file in the target directory)
RUN mvn clean package

# Use a lightweight OpenJDK image for the runtime
FROM openjdk:17-jdk-slim

# Set the working directory for the runtime container
WORKDIR /app

# Copy the built JAR file from the build stage to the runtime container
COPY --from=build /app/target/test.jar /app/test.jar

# Command to run the JAR file
CMD ["java", "-jar", "/app/test.jar"]
