FROM openjdk:8-jdk-alpine3.9

MAINTAINER sunnySide
RUN apk add --update \
    bash

RUN mkdir /var/lib/sunapp
ADD target/sunSpringAdmin01.jar /opt/lib/sunapp/sunSpringAdmin01.jar

ENTRYPOINT ["java", "-jar", "/opt/lib/sunapp/sunSpringAdmin01.jar"]

EXPOSE 9665

CMD java \
 -jar /opt/lib/sunapp/sunSpringAdmin01.jar