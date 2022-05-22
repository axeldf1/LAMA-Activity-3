FROM maven:3-jdk-14

COPY ./target/Gateway-0.0.1-SNAPSHOT.jar /opt/spring-boot/

ENTRYPOINT ["java", "-jar", "/opt/spring-boot/Gateway-0.0.1-SNAPSHOT.jar"]
