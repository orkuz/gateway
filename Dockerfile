FROM openjdk:11
COPY target/gateway-0.0.1.jar gateway.jar
ENTRYPOINT ["java","-jar","/gateway.jar"]