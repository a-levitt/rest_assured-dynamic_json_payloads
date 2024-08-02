package alevitt;

import files.Payload;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DynamicJson {

    @Test
    public void addBook() {
        RestAssured.baseURI = "http://216.10.245.166";

        given()
                .log().all()
                .body(Payload.addBookBody())
        .when()
                .post("Library/Addbook.php")
        .then()
                .log().all()
                .assertThat()
                    .statusCode(200)
                    .body("Msg", equalTo("successfully added"))
                //.extract().response().asString()
        ;
    }
}
