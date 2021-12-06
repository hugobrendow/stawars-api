FROM amazoncorretto:11-alpine-jdk
MAINTAINER hugobrendow97@gmail.com

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} api.jar

ENTRYPOINT ["java","-jar","/api.jar"]