package br.com.alura.resource;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
class BitcoinResourceTest {
  @Test
  @DisplayName("Should return status code 200 - OK")
  void shouldReturnStatusCode200() {
    given()
            .get("bitcoins")
            .then()
            .statusCode(200);
  }
}