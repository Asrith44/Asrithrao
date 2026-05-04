# Library Management System (LMS)

**DevOps-Based Lab Project** — CVR College of Engineering  
**Student:** G.Asrith Rao | **Roll No:** 24B81A6675 | **Branch:** CSM-B  
**Faculty:** Mr. U. Naresh | **Academic Year:** 2025–2026  

---

## Project Overview

A Java-based Library Management System demonstrating full CRUD operations
integrated with a complete DevOps CI/CD pipeline.

## Tech Stack

| Tool      | Version   | Purpose                    |
|-----------|-----------|----------------------------|
| Java JDK  | 11        | Application development    |
| Maven     | 3.9.x     | Build & dependency mgmt    |
| JUnit     | 4.13.2    | Automated unit testing     |
| Git       | 2.x       | Version control            |
| Jenkins   | LTS 2.x   | CI/CD pipeline             |
| Docker    | 24.x      | Containerization           |
| Ansible   | 2.x       | Configuration management   |

## Project Structure

```
library-management-system/
├── src/
│   ├── main/java/com/lms/
│   │   ├── Book.java               # Model class
│   │   ├── LibraryService.java     # Business logic
│   │   └── Main.java               # Entry point
│   └── test/java/com/lms/
│       └── LibraryServiceTest.java # 11 JUnit tests
├── pom.xml                         # Maven build config
├── Dockerfile                      # Container definition
├── Jenkinsfile                     # CI/CD pipeline (6 stages)
├── deploy.yml                      # Ansible deployment playbook
└── README.md
```

## How to Run

### 1. Clone
```bash
git clone https://github.com/karthikeya2425/lms.git
cd lms
```

### 2. Build & Test
```bash
mvn clean compile test package
```

### 3. Run JAR
```bash
java -jar target/library-management-system-1.0-SNAPSHOT.jar
```

### 4. Docker
```bash
docker build -t library-management-system:latest .
docker run --name lms-app library-management-system:latest
```

### 5. Ansible Deploy
```bash
ansible-playbook deploy.yml
```

## CI/CD Pipeline (Jenkins — 6 Stages)

1. Clone Repository
2. Build with Maven
3. Run JUnit Tests
4. Package
5. Docker Build
6. Docker Run

## Test Results

11 JUnit tests — **100% pass rate**
