#!/bin/bash

echo "Select environment to deploy:"
echo "1) Development"
echo "2) UAT"
echo "3) Production"
echo "-----------------------------"
read -p "Enter your choice (1-3): " CHOICE

case $CHOICE in
  1)
    PROFILE="dev"
    PORT=8081
    ;;
  2)
    PROFILE="uat"
    PORT=8082
    ;;
  3)
    PROFILE="prod"
    PORT=8083
    ;;
  *)
    echo "❌ Invalid option. Please choose 1, 2, or 3."
    exit 1
    ;;
esac

echo ""
echo "🛠  Building Spring Boot application..."
./mvnw clean package -DskipTests

if [ $? -ne 0 ]; then
  echo "❌ Build failed. Exiting."
  exit 1
fi

echo ""
echo "🐳 Building Docker image: demo-app:$PROFILE"
docker build -t demo-app:$PROFILE .

echo ""
echo "🧹 Cleaning up any existing container named demo-$PROFILE..."
docker rm -f demo-$PROFILE 2>/dev/null || true

echo ""
echo "🚀 Starting container with Spring profile: $PROFILE on port $PORT"

VOLUME_NAME="h2-data-$PROFILE"
docker run -d \
  -p $PORT:8080 \
  -e SPRING_PROFILES_ACTIVE=$PROFILE \
  -v $VOLUME_NAME:/data \
  --name demo-$PROFILE \
  demo-app:$PROFILE

echo ""
echo "✅ Application for '$PROFILE' is running at: http://localhost:$PORT"
