# Use a lightweight JDK image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy built jar into image
COPY target/app.jar app.jar

# Run the JAR – Spring profile will be passed at runtime
ENTRYPOINT ["java", "-jar", "app.jar"]
