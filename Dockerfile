FROM maven:3.8.5-openjdk-11 AS maven_build
EXPOSE 8089
ADD target/spring-boot-docker.jar spring-boot-docker.jar
ENTRYPOINT ["java","-jar","/spring-boot-docker.jar"]