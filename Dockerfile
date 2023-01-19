
# https://spring.io/guides/gs/spring-boot-docker/

FROM openjdk:17-jdk-alpine

WORKDIR /usr/src/app

COPY .

# Run as non-root
RUN addgroup -g 8080 -S appuser && adduser -u 1001 -S appuser -G appuser
# RUN mkdir /logs && chown -R 1001:1001 /logs
RUN chown -R 8080:8080 /usr/src/app
USER 1001

RUN ./mvnw package

ENTRYPOINT ["java","-jar","/usr/src/app/target/api-0.0.1-SNAPSHOT.jar"]
