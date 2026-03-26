# =============================================================
# GIAI ĐOẠN 1: BUILD - Dùng Maven + Java 25 để compile code
# =============================================================
FROM maven:3.9-eclipse-temurin-25 AS builder

WORKDIR /app

# Copy pom.xml trước để tận dụng Docker layer cache
# (Nếu code thay đổi nhưng pom.xml không đổi, Maven sẽ không tải lại thư viện)
COPY pom.xml .
RUN mvn dependency:go-offline -q

# Copy toàn bộ source code rồi build
COPY src ./src
RUN mvn package -DskipTests -q

# =============================================================
# GIAI ĐOẠN 2: RUN - Chỉ cần JRE nhỏ gọn để chạy file .jar
# =============================================================
FROM eclipse-temurin:25-jre

WORKDIR /app

# Chỉ lấy file .jar đã build từ giai đoạn 1 (không kéo theo source code)
COPY --from=builder /app/target/BuiBaoHanBTDemo1-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
