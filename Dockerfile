FROM gradle:6.6.1-jdk11
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM openjdk:11-jre-slim

COPY build/libs/rfo-api-*-all.jar rfo-api.jar
EXPOSE 0.0.0.0:8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "rfo-api.jar"]