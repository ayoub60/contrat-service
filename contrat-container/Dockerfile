# Use a base image with Java 17 installed
FROM openjdk:17-oracle

# Set the working directory in the container
WORKDIR /app

# Copy the Spring Boot application JAR file to the container
COPY target/*.jar app.jar

# Expose the port on which the Spring Boot application runs
EXPOSE 8080

# Specify the command to run the Spring Boot application
CMD ["java", "-jar", "app.jar"]