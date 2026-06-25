FROM ubuntu:latest
LABEL authors="KoushikKolla(Ext)"

# Use Java 21 Runtime as the base image
FROM eclipse-temurin:21-jre

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot JAR into the container
COPY target/AccountManagementService-0.0.1-SNAPSHOT.jar app.jar

# Expose the application's port
EXPOSE 8080

# Start the Spring Boot application
ENTRYPOINT ["java","-jar","app.jar"]