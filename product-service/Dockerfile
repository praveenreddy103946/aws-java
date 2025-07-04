FROM openjdk:17-jdk-slim

# 🛠️ Install curl
RUN apt-get update && apt-get install -y curl && apt-get clean

# Set working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/product-service-0.0.1-SNAPSHOT.jar app.jar

# Use shell form ENTRYPOINT to allow inline IP detection and fail-safe logic
ENTRYPOINT ["/bin/sh", "-c", "\
  ECS_TASK_IP=$(curl -s http://169.254.169.254/latest/meta-data/local-ipv4) && \
  if [ -z \"$ECS_TASK_IP\" ]; then \
    echo '❌ Failed to get ECS task IP. Exiting...'; \
    exit 1; \
  fi && \
  echo \"✅ Starting app with IP: $ECS_TASK_IP\" && \
  exec java \
    -Deureka.instance.ip-address=$ECS_TASK_IP \
    -Deureka.instance.prefer-ip-address=true \
    -Dspring.profiles.active=ci \
    -jar /app/app.jar \
"]
