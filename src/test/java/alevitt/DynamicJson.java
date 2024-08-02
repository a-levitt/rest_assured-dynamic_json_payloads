package alevitt;

import files.Payload;

import files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.equalTo;

public class DynamicJson {

    @Test(dataProvider = "BooksData")
    public void addBook(String isbn, String aisle) {
        RestAssured.baseURI = "http://216.10.245.166";

        String response =
        given()
                //.log().all()
                .header("Content-Type", "application/json")
                .body(Payload.addBookBody(isbn, aisle))
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
        System.out.println("New book created with ID: " + newBookID);
    }

    @DataProvider(name="BooksData")
    public Object[][] getData() {
        return new Object[][] {{"bdd", "666o510"}, {"tdd", "667o510"}, {"grpc", "668o51o"}};
    }
}
