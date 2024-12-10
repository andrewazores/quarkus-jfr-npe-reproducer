package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class GreetingResourceTest {

    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Hello from Quarkus REST"));
    }

    @Test
    void testUploadEndpoint() {
        given()
          .when().get("/hello/upload")
          .then()
             .statusCode(405);
    }

    @Test
    void testHelloWithBadContentTypeEndpoint() {
        given()
        .accept("application/xml")
          .when().get("/hello")
          .then()
             .statusCode(406);
    }

}
