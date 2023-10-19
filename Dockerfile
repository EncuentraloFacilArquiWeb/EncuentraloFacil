FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/EncuentraloFacil-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} EncuentraloFacil.jar
ENTRYPOINT ["java","-jar","/EncuentraloFacil.jar"]