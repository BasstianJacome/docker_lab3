
FROM openjdk:17

EXPOSE 8080

COPY target/dockerfile.jar dockerfile.jar

ENTRYPOINT ["java", "-jar", "/dockerfile.jar"]
