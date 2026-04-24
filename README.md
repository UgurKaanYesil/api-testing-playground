# API Testing Playground

A playground project for learning and experimenting with REST API test automation using REST Assured and JUnit 5. Built to establish the foundational structure of a real test infrastructure through hands-on examples.

## Tech Stack

- **Java 21**
- **REST Assured 5.5.2** — HTTP request/response validation
- **JUnit 5 (Jupiter) 5.11.4** — Test runner
- **Hamcrest 3.0** — Matcher library
- **Jackson Databind 2.18.4** — JSON serialization
- **Maven** — Build and dependency management

## Target API

[JSONPlaceholder](https://jsonplaceholder.typicode.com) — a free, no-registration fake REST API. Sends real HTTP requests and returns real HTTP responses, making it ideal for learning how to write API tests.

## Project Structure

```
api-testing-playground/
├── src/
│   └── test/
│       └── java/
│           └── com/
│               └── ugurkaan/
│                   └── tests/
│                       └── PostsApiTest.java
└── pom.xml
```

## Run Tests

```bash
mvn clean test
```

To run a single test method:

```bash
mvn clean test -Dtest=PostsApiTest#getSinglePost_shouldReturn200AndValidBody
```

## Note

This repo is actively evolving. In the next iteration, the raw `Map` structure will be replaced with POJO models and the tests will be refactored on top of an abstract base class.