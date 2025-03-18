FROM openjdk:17-jdk-alpine

COPY ./build/libs/user-management-0.0.1-SNAPSHOT.jar /usr/app/user-management.jar

WORKDIR /usr/app

EXPOSE 8080

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","user-management.jar"]
