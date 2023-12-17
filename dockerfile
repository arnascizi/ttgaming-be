FROM openjdk:11
COPY ttgaming-api/target/ttgaming-api-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]