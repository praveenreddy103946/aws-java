FROM openjdk:17-jdk-slim

# 🛠️ Install curl
RUN apt-get update && apt-get install -y curl && apt-get clean

# Set working directory
WORKDIR /app

# Copy the jar file
COPY target/product-service-0.0.1-SNAPSHOT.jar app.jar

# Copy entrypoint script
COPY entrypoint.sh /app/entrypoint.sh
RUN chmod +x /app/entrypoint.sh

# Run the entrypoint script
ENTRYPOINT ["/app/entrypoint.sh"]
