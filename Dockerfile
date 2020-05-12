FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} product-app.jar
ENTRYPOINT ["java","-jar","/product-app.jar"]