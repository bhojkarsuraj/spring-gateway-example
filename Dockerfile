FROM openjdk:8-jre-alpine3.7
COPY /build/libs/plf-admin-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["sh", "-c", "java -jar -DKAFKA_SERVERS=172.20.36.163:32400 app.jar"]