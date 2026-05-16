# Этап 1 - сборка проекта в jar
FROM maven:3.9-eclipse-temurin-21 AS maven
WORKDIR /site
COPY pom.xml checkstyle.xml ./
RUN mvn dependency:go-offline -B
COPY src/ ./src/
RUN mvn package -DskipTests

# Этап 2 - запуск приложения в Docker-контейнере
FROM eclipse-temurin:21-jre-jammy
WORKDIR /site
COPY --from=maven /site/target/*.jar site.jar
EXPOSE 8080
CMD ["java", "-jar", "site.jar"]