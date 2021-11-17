# Code example!

Code example in Java using Spring Boot. This application has the ability to manage users and their loans through different endpoints.


## How to run
The database is created in memory with `H2` and is populated automatically by the file `import.sql`. So to run the application you only have to run:

    $ ./mvnw spring-boot:run

## Routes

|Method |Endpoint                          |Response|
|-------|----------------------------------|--------|
|GET    |/users                            |200     |
|GET    |/users/{id}                       |200     |
|POST   |/users                            |200     |
|DELETE |/users/{id}                       |200     |
|GET    |/loans?page=1&size=50             |200     |
|GET    |/loans?page=1&size=50&user_id={id}|200     |

Keep in mind that for the `/loans` routes the `page` and `size` options are **mandatory**.

## Examples
### GET /users/{id}

    {
        "id": 1,
        "email": "test@app.com.ar",
        "firstName": "Pepe"
        "lastName": "Argento"
        "loans": [
            {
                "id": 1,
                "total": 2.500
                "userId": 1
            }
        ]
    }

### GET /loans?page=1&size=50

    {
        "items":[
            {
                "id": 1,
                "total": 2500.00
                "userId": 1
            },
            {
                "id": 2,
                "total": 65120.75
                "userId": 1
            }
        ],
        "paging":{
            "page": 1,
            "size": 50,
            "total": 1500
        }
    }