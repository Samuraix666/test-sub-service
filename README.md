## User Subscription Service

### How to run locally

1. Build project:
```bash
mvn clean package
```

2. Run Docker Compose:
```bash
docker-compose up --build
```

### Example curl requests

Create user:
```bash
curl -X POST -H "Content-Type: application/json" -d '{"name":"New User", "email":"newuser@example.com"}' http://localhost:8080/users
```

Get user:
```bash
curl http://localhost:8080/users/1
```
