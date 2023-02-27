FROM gradle:8.0.1-jdk11-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM openjdk:11-jdk-slim

COPY --from=build /home/gradle/src/build/libs/consumer-1.0-SNAPSHOT.jar /consumer-app.jar

ENTRYPOINT ["java","-jar","/consumer-app.jar"]
