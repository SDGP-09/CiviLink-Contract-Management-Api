# Stage 1: Build the application
FROM maven:3.8.6-amazoncorretto-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn package -DskipTests

# Stage 2: Create the final image
FROM openjdk:17-alpine
WORKDIR /app
COPY --from=build /app/target/civilink-contract-manager.jar .

EXPOSE 7071
CMD ["java", "-jar", "civilink-contract-manager.jar"]

# Test
