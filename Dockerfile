FROM openjdk:8u171-jdk-alpine3.8
LABEL maintainer="lubanco@edu.unifil.br"
ENV USER_DATABASE \
    PASSWORD_DATABASE \
RUN apk add --update bash
ADD target/*.jar /app/app.jar
CMD java -jar /app/app.jar $APP_OPTIONS