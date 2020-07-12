FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD target/Spring-gateway-example.jar Spring-gateway-example.jar
# java -jar /usr/local/runme/app.jar
ENTRYPOINT ["java","-jar","Spring-gateway-example.jar"]