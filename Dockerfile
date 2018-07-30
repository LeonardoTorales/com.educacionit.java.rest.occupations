FROM       openjdk:8
MAINTAINER Raul Peña (raul.pena@gmail.com)
RUN        apt-get update && apt-get upgrade -y \
           && apt-get install -y vim
VOLUME     /tmp
RUN        mkdir -p /opt/setup/ru/services/meta/logs
ADD        target/*.jar /opt/setup/ru/services/meta/app.jar
RUN        sh -c 'touch /opt/setup/ru/services/meta/app.jar'
ENTRYPOINT [ "sh", "-c", "java -jar -Dapp.setup=/opt/setup/ru/services/meta -Dspring.profiles.active=prod /opt/setup/ru/services/meta/app.jar" ]
WORKDIR    /opt/workspace/docker