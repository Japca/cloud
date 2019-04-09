FROM  openjdk:11.0.3-jdk-slim-stretch

VOLUME /tmp
WORKDIR /opt/spring
COPY target/db-service.jar .
CMD ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/opt/spring/db-service.jar"]
