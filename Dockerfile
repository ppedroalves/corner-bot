FROM mcr.microsoft.com/playwright/java:v1.30.0-focal
ENV TZ=America/Sao_Paulo
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 8081
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=hml","-jar", "/app.jar"]