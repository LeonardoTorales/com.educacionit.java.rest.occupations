FROM       openjdk:8
MAINTAINER Raul Peña (raul.pena@gmail.com)
RUN        apt-get update && apt-get upgrade -y \
           && apt-get install -y vim
VOLUME     /tmp
RUN        mkdir -p /opt/logs
ADD        target/*.jar /opt/applications/app.jar
RUN        sh -c 'touch /opt/applications/app.jar'
ENTRYPOINT [ "sh", "-c", "java -jar /opt/applications/app.jar" ]
WORKDIR    /opt/workspace/docker
