package paypalexamples.tests;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostAsString extends BaseClass {

    @Test
    public void createAPayment() {
        String body = "";
        given().contentType(ContentType.JSON)
                .auth()
                .oauth2(accessToken)
                .when()
                .body(body)
                .post("payments/payment")
                .then()
                .log()
                .all();
    }

}
