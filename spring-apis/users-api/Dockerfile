FROM maven:3.5-jdk-10 as build
COPY . /usr/src/maven
WORKDIR /usr/src/maven
RUN mvn package

FROM openjdk:10
WORKDIR /usr/src/users-api
COPY --from=build /usr/src/maven/target/users-api-0.0.1-SNAPSHOT.jar /usr/src/users-api
EXPOSE 8080
CMD ["java", "-jar", "/usr/src/users-api/users-api-0.0.1-SNAPSHOT.jar"]
