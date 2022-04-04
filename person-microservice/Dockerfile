FROM openjdk:11
VOLUME /tmp
add ./target/person-microservice-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]