package demos;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EndToEndTests {

    @LocalServerPort
    int port;

    @Before
    public void init(){
        RestAssured.port = port;
    }

    @Test
    public void getAllTodos() {
        given()
            .accept(ContentType.JSON)
            .contentType(ContentType.JSON)
        .when()
            .get("/todos")
        .then()
            .statusCode(200)
            .body(
                "description", hasItems("First", "Second"),
                "completedAt", hasItems(isEmptyOrNullString(), isEmptyOrNullString())
            );
    }

    @Test
    public void completeTodo() {
        given()
            .accept(ContentType.JSON)
            .contentType(ContentType.JSON)
            .pathParam("id", 1)
        .when()
            .post("/todos/{id}/complete")
        .then()
            .statusCode(200)
            .body(
                "description", equalTo("First"),
                "completedAt", not(isEmptyOrNullString())
            );
    }
}
