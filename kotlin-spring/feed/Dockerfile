FROM openjdk:17-jdk-slim

EXPOSE 8080
ENV TZ=Asia/Seoul
ARG JAR_FILE=build/libs/feed-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]