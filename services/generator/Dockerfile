# Этап 1 - сборка проекта в jar
FROM maven:3.9-eclipse-temurin-21 AS maven
WORKDIR /generator
COPY pom.xml checkstyle.xml ./
RUN mvn dependency:go-offline -B
COPY src/ ./src/
RUN mvn package -DskipTests

# Этап 2 - запуск приложения в Docker-контейнере
FROM eclipse-temurin:21-jre-jammy
WORKDIR /generator
COPY --from=maven /generator/target/*.jar generator.jar
EXPOSE 8080
CMD ["java", "-jar", "generator.jar"]
