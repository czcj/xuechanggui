FROM openjdk:11-jdk-slim
WORKDIR .
#COPY target/jeesns.war paas-application.jar
ADD xuechanggui-0.0.1.jar .
#RUN chown -R /application
EXPOSE 8080
CMD java -jar xuechanggui-0.0.1.jar
