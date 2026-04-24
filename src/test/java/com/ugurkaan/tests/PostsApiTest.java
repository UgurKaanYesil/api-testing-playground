package com.ugurkaan.tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class PostsApiTest {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    void simpleConnectivityTest() {
        given()
            .when()
            .get("/posts/1")
            .then()
            .statusCode(200);
    }
}