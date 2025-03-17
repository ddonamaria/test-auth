# Compilation
FROM eclipse-temurin:21-jdk AS builder
LABEL authors="ddonamaria"
WORKDIR /app
COPY . .
RUN ./mvnw clean package

# Run
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=builder /app/target/auth-app*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]