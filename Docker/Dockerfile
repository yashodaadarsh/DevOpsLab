# Use lightweight Java runtime
FROM eclipse-temurin:17-jre

# Set working directory inside container
WORKDIR /app

# Copy the jar file
COPY target/app.jar app.jar

# Expose application port (change if needed)
EXPOSE 8081

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
