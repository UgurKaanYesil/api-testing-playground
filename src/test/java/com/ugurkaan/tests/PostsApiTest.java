package com.ugurkaan.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.notNullValue;

public class PostsApiTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    @DisplayName("GET /posts/1 should return 200 with valid id, userId, title and body fields")
    public void getSinglePost_shouldReturn200AndValidBody() {
        given()
            .when()
            .get("/posts/1")
            .then().log().all()
            .statusCode(200)
            .body("id", equalTo(1))
            .body("userId", notNullValue())
            .body("title", not(emptyString()))
            .body("body", not(emptyString()));
    }

    @Test
    @DisplayName("GET /posts should return 200 with at least 100 items and valid first element")
    public void getAllPosts_shouldReturnAtLeast100Items() {
        given()
            .when()
            .get("/posts")
            .then().log().all()
            .statusCode(200)
            .body("size()", greaterThanOrEqualTo(100))
            .body("[0].id", notNullValue())
            .body("[0].userId", notNullValue());
    }

    @Test
    @DisplayName("POST /posts should return 201 with echoed title and a generated id")
    public void createPost_shouldReturn201AndEchoData() {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("userId", 1);
        requestBody.put("title", "Test Title");
        requestBody.put("body", "Test Body Content");

        given()
            .contentType(ContentType.JSON)
            .body(requestBody)
            .when()
            .post("/posts")
            .then().log().all()
            .statusCode(201)
            .body("title", equalTo("Test Title"))
            .body("id", notNullValue());
    }
}