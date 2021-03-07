FROM openjdk:8u171-jdk-alpine3.8
LABEL maintainer="lubanco@edu.unifil.br"
ENV SECRET_KEY \
    API_KEY_PAGARME \
    ACCESS_KEY \
RUN apk add --update bash
ADD target/*.jar /app/app.jar
CMD java -jar /app/app.jar $APP_OPTIONS