FROM openjdk:8-jdk-alpine3.9

MAINTAINER sunnySide
RUN apk add --update \
    bash

RUN mkdir /var/lib/sunapp
ADD target/sun-gate.jar /opt/lib/sunapp/sun-gate.jar
HEALTHCHECK --start-period=120s --interval=30s --timeout=3s CMD curl -f http://localhost:9662/actuator/health || exit 1

ENTRYPOINT ["java", "-jar", "/opt/lib/sunapp/sun-gate.jar"]

EXPOSE 9662

CMD java \
 -jar /opt/lib/sunapp/sun-gate.jar