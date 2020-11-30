FROM openjdk:8-jdk-alpine3.9

MAINTAINER sunnySide
RUN apk add --update \
    bash

RUN mkdir /var/lib/sunapp

ADD target/sunSpringTest01.jar /opt/lib/sunapp/sunSpringTest01.jar

HEALTHCHECK --start-period=120s --interval=30s --timeout=3s CMD curl -f http://localhost:9666/actuator/health || exit 1

ENTRYPOINT ["java", "-jar", "/opt/lib/sunapp/sunSpringTest01.jar"]

EXPOSE 9666

CMD java \
 -jar /opt/lib/sunapp/sunSpringTest01.jar