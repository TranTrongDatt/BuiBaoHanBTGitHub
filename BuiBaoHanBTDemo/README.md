# BuiBaoHanBTDemo

Dự án Spring Boot học Docker & GitHub Actions của Bùi Bảo Hân.

## Công nghệ sử dụng
- Java 25 + Spring Boot 4.0.3
- Thymeleaf (giao diện web)
- MySQL 8.0 (database)
- Docker + Docker Compose
- GitHub Actions (CI/CD)

## Cách chạy với Docker

```bash
# Build và khởi chạy toàn bộ hệ thống
docker-compose up --build

# Truy cập ứng dụng
http://localhost:8080
```

## Cấu trúc dự án

```
BuiBaoHanBTDemo/
├── src/                    # Source code Java
├── Dockerfile              # Cấu hình build image
├── docker-compose.yml      # Cấu hình chạy đa container
└── .github/workflows/      # GitHub Actions CI/CD
```
