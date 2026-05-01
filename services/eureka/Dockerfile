# Temporary file, which will be deleted later

FROM eclipse-temurin:17-jre-jammy

# Создаём директорию для приложения
WORKDIR /eureka

# Копируем JAR‑файл
COPY target/eureka-0.0.1-SNAPSHOT.jar eureka.jar

# Открываем порт
EXPOSE 9009

# Запускаем приложение
ENTRYPOINT ["java", "-jar", "eureka.jar"]