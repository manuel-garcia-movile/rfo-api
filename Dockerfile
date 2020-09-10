FROM openjdk:14-alpine
COPY build/libs/rfo-api-*-all.jar rfo-api.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "rfo-api.jar"]