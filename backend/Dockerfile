# Backend Dockerfile
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copiar pom.xml y descargar dependencias
COPY pom.xml ./
RUN mvn dependency:go-offline

# Copiar todo el backend y compilar
COPY . ./
RUN mvn clean package -DskipTests

# Imagen final
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app

# Copiar el JAR compilado
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]