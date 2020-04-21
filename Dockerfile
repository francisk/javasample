FROM openjdk:8
MAINTAINER Jinrui "jinrui01@aliyun.com"
WORKDIR /SERVICE
EXPOSE 8081
ADD ./target/dof-0.0.1-SNAPSHOT.jar /SERVICE/
ENTRYPOINT ["java","-jar","dof-0.0.1-SNAPSHOT.jar"]