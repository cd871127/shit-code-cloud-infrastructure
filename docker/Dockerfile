FROM cd871127/container:jdk11-consul1.8.2
MAINTAINER Anthony
ARG GIT_POSTFIX
ARG APP_NAME

ENV JAR_NAME=app.jar
RUN mkdir -p /app/config &&\
    mkdir -p /app/log

COPY docker-entrypoint.sh /bin

WORKDIR /app
COPY app.jar /app/app.jar
COPY docker-entrypoint.sh /bin

VOLUME /app/config
VOLUME /app/log

EXPOSE 8080

ENTRYPOINT ["docker-entrypoint.sh"]
