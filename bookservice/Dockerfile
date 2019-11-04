FROM maven:3.5-jdk-8 AS build
WORKDIR /app
COPY pom.xml /app
RUN mvn dependency:go-offline -B
COPY src /app/src
RUN mvn clean package -DskipTests

FROM openjdk:8u131-jre-alpine
WORKDIR /app
COPY --from=build /app/target/book-service-0.0.1-SNAPSHOT.jar /app/book-service.jar
RUN chmod +x book-service.jar
EXPOSE 8080
CMD ["java", "-jar", "book-service.jar"]
