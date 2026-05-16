# Этап 1 - сборка проекта в jar
FROM maven:3.9-eclipse-temurin-17 AS maven
WORKDIR /eureka
COPY pom.xml checkstyle.xml ./
RUN mvn dependency:go-offline -B
COPY src/ ./src/
RUN mvn package -DskipTests

# Этап 2 - запуск приложения в Docker-контейнере
FROM eclipse-temurin:17-jre-jammy
WORKDIR /eureka
COPY --from=maven /eureka/target/*.jar eureka.jar
EXPOSE 8080
CMD ["java", "-jar", "eureka.jar"]

