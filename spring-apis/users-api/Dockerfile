FROM openjdk:8
COPY ./target/users-api-0.0.1-SNAPSHOT.jar /usr/src/users-api/
WORKDIR /usr/src/users-api
EXPOSE 8080
CMD ["java", "-jar", "users-api-0.0.1-SNAPSHOT.jar"]