# Use a lightweight Java runtime
FROM eclipse-temurin:21-jre-jammy

# set working Directory
WORKDIR /app

# Copy the already-built jar from host into container
COPY target/multirole-auth-0.0.1-SNAPSHOT.jar multiRoleAuth.jar

# Expose the application port
EXPOSE 8081

# start spring boot application
ENTRYPOINT ["java", "-jar", "multiRoleAuth.jar"]
