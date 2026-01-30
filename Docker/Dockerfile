# Use lightweight Java runtime
FROM eclipse-temurin:17-jre

# Set working directory inside container
WORKDIR /app

# Copy the jar file
COPY target/DevOpsLab05-0.0.1-SNAPSHOT.jar app.jar

# Expose application port (change if needed)
EXPOSE 8081

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
