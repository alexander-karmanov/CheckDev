# Этап 1 - сборка проекта в jar
FROM maven:3.9-eclipse-temurin-17 AS maven
WORKDIR /auth
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src/ ./src/
RUN mvn package -DskipTests

# Этап 2 - указание как запустить проект
FROM eclipse-temurin:17-jre-jammy
WORKDIR /auth
COPY --from=maven /auth/target/auth.jar auth.jar
EXPOSE 8080
CMD ["java", "-jar", "auth.jar"]
