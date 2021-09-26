package br.com.alura.resource;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class UsersResourceTest {

  @Test
  @DisplayName("Users resource should return status code 204 when post a user json to '/users'")
  void testCreate() {
    given()
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .post("/users")
            .then()
            .statusCode(204);
  }
}