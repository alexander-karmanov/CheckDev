FROM maven:3.9-eclipse-temurin-17 AS maven
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src/ ./src/
RUN mvn package -DskipTests

FROM eclipse-temurin:17-jre-jammy
WORKDIR /eureka
COPY --from=maven /eureka/target/eureka.jar eureka.jar
EXPOSE 8080
CMD ["java", "-jar", "eureka.jar"]

