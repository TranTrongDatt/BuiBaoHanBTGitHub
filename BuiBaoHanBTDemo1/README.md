# BuiBaoHan Spring Boot Demo

Demo project để học Spring Boot, Docker và MySQL.

## Yêu cầu hệ thống

- **Java 25** hoặc cao hơn
- **Maven** (hoặc dùng Maven Wrapper có sẵn)
- **Docker Desktop** (nếu muốn chạy bằng Docker)
- **MySQL** (chỉ cần khi dùng profile `prod`)

## Cách chạy

### Cách 1: Chạy trực tiếp (Development mode - H2 Database)

```powershell
# Set JAVA_HOME (chỉ cần làm 1 lần mỗi session)
$env:JAVA_HOME = "C:\Program Files\Java\jdk-25.0.2"

# Chạy app
.\mvnw.cmd spring-boot:run
```

Truy cập: http://localhost:8080

### Cách 2: Chạy với Docker

```bash
# Build image
docker build -t buibaohan-demo .

# Chạy container
docker run -p 8080:8080 buibaohan-demo
```

### Cách 3: Chạy với MySQL (Production mode)

1. Tạo database MySQL:
```sql
CREATE DATABASE demo_db;
```

2. Chạy với profile prod:
```powershell
$env:JAVA_HOME = "C:\Program Files\Java\jdk-25.0.2"
.\mvnw.cmd spring-boot:run -Dspring-boot.run.profiles=prod
```

Hoặc với biến môi trường cho password:
```powershell
$env:MYSQL_PASSWORD = "your_mysql_password"
.\mvnw.cmd spring-boot:run -Dspring-boot.run.profiles=prod
```

## Cấu trúc Project

```
BuiBaoHanBTDemo1/
├── src/main/java/com/example/BuiBaoHanBTDemo1/
│   ├── BuiBaoHanBtDemo1Application.java    # Main class
│   └── controller/
│       └── HomeController.java              # Controller xử lý request
├── src/main/resources/
│   ├── application.properties               # Config chung
│   ├── application-dev.properties           # Config cho Development (H2)
│   ├── application-prod.properties          # Config cho Production (MySQL)
│   └── templates/
│       ├── index.html                       # Trang chủ
│       └── about.html                       # Trang giới thiệu
├── Dockerfile                               # Docker multi-stage build
├── .dockerignore                            # Files bỏ qua khi build Docker
└── pom.xml                                  # Maven dependencies
```

## Endpoints

| URL | Mô tả |
|-----|-------|
| http://localhost:8080/ | Trang chủ |
| http://localhost:8080/about | Trang giới thiệu |
| http://localhost:8080/h2-console | H2 Database Console (chỉ dev mode) |

## Tech Stack

- Spring Boot 4.0.4
- Java 25
- Thymeleaf (Template Engine)
- Spring Data JPA + Hibernate
- H2 Database (Development)
- MySQL (Production)
- Docker

## Các lệnh hữu ích

```powershell
# Build project (không chạy test)
.\mvnw.cmd package -DskipTests

# Chạy tests
.\mvnw.cmd test

# Clean và rebuild
.\mvnw.cmd clean package

# Xem dependency tree
.\mvnw.cmd dependency:tree
```

## Troubleshooting

### Lỗi "JAVA_HOME is not defined"
```powershell
$env:JAVA_HOME = "C:\Program Files\Java\jdk-25.0.2"
```

### Lỗi kết nối MySQL
1. Kiểm tra MySQL đang chạy
2. Kiểm tra database `demo_db` đã được tạo
3. Kiểm tra username/password trong `application-prod.properties`

### Port 8080 đã bị dùng
Thay đổi port trong `application.properties`:
```properties
server.port=8081
```
