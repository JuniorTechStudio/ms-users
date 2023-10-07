FROM bellsoft/liberica-openjdk-alpine:21
ARG JAR_FILE=build/libs/ms-users-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]