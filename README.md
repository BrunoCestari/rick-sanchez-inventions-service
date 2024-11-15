<h1 align="center">
  Rick Sanchez Inventions Service 
</h1>


API for managing Rick Sanchez's crazy inventions (CRUD).

## Technologies

- [Spring Boot](https://spring.io/projects/spring-boot)

- [Spring Data + R2DBC](https://docs.spring.io/spring-framework/reference/data-access/r2dbc.html)




## Adopted Practices

- SOLID
- Automated testing
- Reactive API at web and database layers
- Use of DTOs for the API
- Dependency Injection
- Auditing of entity creation and updates


## How to Run

### Locally
1. Clone the git repository:
```
git clone https://github.com/BrunoCestari/rick-sanchez-inventions-service.git \
```
2. Navigate to the project directory:
```
cd rick-sanchez-inventions-service
```

3. Build the project:

```
./mvnw clean package
```
4. Change to `target` directory:
```
cd target 
```
5. Run:
```
java -jar ick-sanchez-inventions-service/target/rick-sanchez-inventions-service-0.0.1-SNAPSHOT.jar
```

The API will be accessible at [localhost:8080](http://localhost:8080).  


### Docker

1. Clone the git repository:
```
git clone https://github.com/BrunoCestari/rick-sanchez-inventions-service.git \
```
2. Navigate to the project directory:
```
cd rick-sanchez-inventions-service
```
3. Build the project:

```
./mvnw clean package
```

4. Build the Docker image:
```
./mvnw spring-boot:build-image
```

5. Run the container:
```
docker run -d -p 8080:8080 rick-sanchez-inventions-service:0.0.1-SNAPSHOT
```

The API can be accessed at [localhost:8080](http://localhost:8080).

## API Endpoints

To make the HTTP requests below, you can use a tool like [Postman](https://www.postman.com/):

### POST /api/inventions/{id}
**Request Body (JSON):**
```
{
    "name": "Portal Gun",
    "category": "Device",
    "price": 50000000,
    "description": "Allows instant travel between dimensions"
}

``` 
**Expected Response**:

```
HTTP/1.1 200 OK
Content-Length: 178
Content-Type: application/json

{
    "createdAt": "2023-04-20T19:00:07.241632",
    "name": "Portal Gun",
    "category": "Device",
    "price": 50000000,
    "description": "Allows instant travel between dimensions",
    "id": 1
}
```

### GET /api/inventions/{id}
**Expected Response (id = 1)**:

```
HTTP/1.1 200 OK
Content-Length: 178
Content-Type: application/json

{
    "createdAt": "2023-04-20T19:00:07.241632",
    "name": "Portal Gun",
    "category": "Device",
    "price": 50000000,
    "description": "Allows instant travel between dimensions",
    "id": 1
}
```

### GET /api/inventions
**Expected Response**:


```
http :8080/api/inventions

HTTP/1.1 200 OK
Content-Type: application/json
transfer-encoding: chunked

[
    {
        "createdAt": "2023-04-20T19:00:07.241632",
        "name": "Portal Gun",
        "category": "Device",
        "price": 50000000,
        "description": "Allows instant travel between dimensions",
        "id": 1
    },
    {
        "createdAt": "2023-04-21T10:00:07.241632",
        "name": "Meeseeks Box",
        "category": "Device",
        "price": 100000,
        "description": "A box that generates a helpful creature to complete tasks",
        "id": 2
    }
]
```

### PUT /api/inventions/{id}
**Request Body (JSON):**

```
{
    "name": "Updated Portal Gun",
    "category": "Advanced Device",
    "price": 55000000,
    "description": "Updated description"
}
```
**Expected Response (id = 1)**:

```
HTTP/1.1 200 OK
Content-Length: 183
Content-Type: application/json

{
    "createdAt": "2023-04-20T19:00:07.241632",
    "name": "Updated Portal Gun",
    "category": "Advanced Device",
    "price": 55000000,
    "description": "Updated description",
    "id": 1
}
```

### DELETE /api/inventions/{id}
**Expected Response (id = 1)**:


```

HTTP/1.1 200 OK
Content-Length: 0
```