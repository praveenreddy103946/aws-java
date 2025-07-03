FROM openjdk:17-jdk-slim

# 🛠️ Install curl
RUN apt-get update && apt-get install -y curl && apt-get clean

# Set working directory
WORKDIR /app

# Copy the jar
COPY target/product-service-0.0.1-SNAPSHOT.jar app.jar

# Entry point to set Eureka IP from ECS metadata
ENTRYPOINT sh -c '\
  ECS_TASK_IP=$(curl -s http://169.254.169.254/latest/meta-data/local-ipv4) && \
  exec java \
    -Deureka.instance.ip-address=$ECS_TASK_IP \
    -Deureka.instance.prefer-ip-address=true \
    -jar app.jar'

