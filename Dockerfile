FROM openjdk:17
ADD /target/Project2Boot-0.0.1-SNAPSHOT.jar backend.jar
ENTRYPOINT ["java","-jar","backend.jar"]