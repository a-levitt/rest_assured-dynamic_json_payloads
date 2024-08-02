package alevitt;

import files.Payload;

import files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DynamicJson {

    @Test
    public void addBook() {
        RestAssured.baseURI = "http://216.10.245.166";

        String response =
        given()
                //.log().all()
                .header("Content-Type", "application/json")
                .body(Payload.addBookBody())
        .when()
                .post("Library/Addbook.php")
        .then()
                //.log().all()
                .assertThat()
                    .statusCode(200)
                    //.body("Msg", equalTo("successfully added"))
                .extract().response().asString()
        ;

        JsonPath js = ReusableMethods.rawToJson(response);

        String newBookID = js.getString("ID");
        System.out.println(newBookID);
    }
}
