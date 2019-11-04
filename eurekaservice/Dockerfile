FROM maven:3.5-jdk-8 AS build
WORKDIR /app
COPY pom.xml /app
RUN mvn dependency:go-offline -B
COPY src /app/src
RUN mvn clean package -DskipTests

FROM openjdk:8u131-jre-alpine
WORKDIR /app
COPY --from=build /app/target/eureka-service-0.0.1-SNAPSHOT.jar /app/eureka-service.jar
RUN chmod +x eureka-service.jar
EXPOSE 8080
CMD ["java", "-jar", "eureka-service.jar"]
