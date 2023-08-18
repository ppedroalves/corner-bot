

FROM openjdk:17
RUN apt-get update && apt-get install -yq \
    curl \
    libnss3 \
    libxkbcommon-x11-0 \
    libgbm1 \
    && rm -rf /var/lib/apt/lists/*
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 8081
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]