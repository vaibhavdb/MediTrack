FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /app

# Copy pom first for caching
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy proto files (needed for stub generation)
COPY src/main/proto ./src/main/proto

# Copy the rest of the source code
COPY src ./src

# Build the project (generate stubs + package)
RUN mvn clean package -DskipTests

# ============================
FROM openjdk:21-jdk AS runner

WORKDIR /app

COPY --from=builder /app/target/billing-service-0.0.1-SNAPSHOT.jar ./app.jar

EXPOSE 4001
EXPOSE 9001

ENTRYPOINT ["java", "-jar", "app.jar"]
