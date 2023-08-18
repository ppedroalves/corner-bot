
FROM openjdk:11

RUN apt-get update && apt-get install -yq \
    curl \
    libnss3 \
    libxkbcommon-x11-0 \
    libgbm1 \
    && rm -rf /var/lib/apt/lists/*

WORKDIR /app

COPY target/seu-app.jar app.jar


CMD ["java", "-jar", "app.jar"]