#!/bin/bash

echo "Select environment to deploy:"
echo "1) Development"
echo "2) UAT"
echo "3) Production"
echo "-----------------------------"
# shellcheck disable=SC2162
read -p "Enter your choice (1-3): " CHOICE

case $CHOICE in
  1)
    PROFILE="dev"
    ;;
  2)
    PROFILE="uat"
    ;;
  3)
    PROFILE="prod"
    ;;
  *)
    echo "❌ Invalid option. Please choose 1, 2, or 3."
    exit 1
    ;;
esac

echo ""
echo "🛠  Building Spring Boot application..."
./mvnw clean package -DskipTests

# shellcheck disable=SC2181
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
echo "🚀 Starting container with Spring profile: $PROFILE"

if [ "$PROFILE" == "dev" ] || [ "$PROFILE" == "prod" ] || [ "$PROFILE" == "uat" ]; then
  VOLUME_NAME="h2-data-$PROFILE"
  docker run -d \
    -p 8080:8080 \
    -e SPRING_PROFILES_ACTIVE=$PROFILE \
    -v $VOLUME_NAME:/data \
    --name demo-$PROFILE \
    demo-app:$PROFILE
else
  docker run -d \
    -p 8080:8080 \
    -e SPRING_PROFILES_ACTIVE=$PROFILE \
    --name demo-$PROFILE \
    demo-app:$PROFILE
fi

echo ""
echo "✅ Application is running with '$PROFILE' profile at: http://localhost:8080"
