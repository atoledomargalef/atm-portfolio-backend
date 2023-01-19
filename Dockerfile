
# https://spring.io/guides/gs/spring-boot-docker/

FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
WORKDIR /usr/scr/app
ENTRYPOINT ["java","-jar","/app.jar"]
