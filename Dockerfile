FROM openjdk:8
ADD target/microservice-transaction.jar microservice-transaction.jar
EXPOSE 8002
ENTRYPOINT ["java", "-jar", "microservice-transaction.jar"]