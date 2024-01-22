FROM maven:3.8.4-openjdk-17 as builder
WORKDIR /app
COPY . /app/.

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar /app/*.jar
ENTRYPOINT ["java", "-jar", "/app/*.jar"]

