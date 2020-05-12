FROM sfrolvlad/alpine-oraclejdk8:slim

VOLUME /tmp
ADD docker-image.jar /opt/docker-image/
EXPOSE 8080
WORKDIR /opt/docker-image/
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-Xms512m", "-Xmx1g", "-jar", "docker-image.jar"]
