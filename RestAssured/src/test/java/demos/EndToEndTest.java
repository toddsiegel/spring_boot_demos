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
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(
    webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT,
    classes = { Application.class }
)
public class EndToEndTest {

    @LocalServerPort
    int port;

    @Before
    public void init(){
        RestAssured.port = port;
    }

    @Test
    public void testEndpoint() {
        given()
            .accept(ContentType.JSON)
            .contentType(ContentType.JSON)
        .when()
            .get("/hello")
        .then()
            .body("name", equalTo("One"))
            .statusCode(200);
    }
}
