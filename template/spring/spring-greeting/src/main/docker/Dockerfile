FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY ./*.jar my-greeter-app.jar
ENTRYPOINT ["java","-jar","/my-greeter-app.jar"]