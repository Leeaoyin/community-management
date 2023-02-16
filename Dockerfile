FROM openjdk:8-jdk-slim
MAINTAINER Lee
COPY community-management-1.0-SNAPSHOT.jar /app.jar
ENV TZ=Asia/Shanghai
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]