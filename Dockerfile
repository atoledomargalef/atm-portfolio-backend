
# https://spring.io/guides/gs/spring-boot-docker/

FROM openjdk:17-jdk-alpine

WORKDIR /usr/src/app

RUN ./mvnw package

ENTRYPOINT ["java","-jar","/usr/src/app/target/api-0.0.1-SNAPSHOT.jar"]
