# User Management API

A simple Spring Boot REST API to perform CRUD operations on users using H2 in-memory database.

## Technologies Used

- Java 21+
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Maven
- Lombok

## API Endpoints

Base URL: `/user-management/v1/`

### Create User
**POST** `/users`

Request Body:
```json
{
  "name": "faisal",
  "email": "faltuwayli@gmail.com",
  "createdAt": "github.com"
}
```

### Get All Users
**GET** `/users`

### Get User by ID
**GET** `/users/{id}`

### Update User
**PUT** `/users/{id}`

Request Body:
```json
{
  "name": "faisal",
  "email": "faltuwayli@gmail.com",
  "createdAt": "github.com"
}
```

### Delete User
**DELETE** `/users/{id}`

## H2 Console

- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:userdb`
- Username: `admin`
- Password: `admin123`

## Running the App

```bash
./mvnw spring-boot:run
```

or

```bash
mvn clean install
java -jar target/user-management-0.0.1-SNAPSHOT.jar
```
