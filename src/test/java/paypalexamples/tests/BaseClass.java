package paypalexamples.tests;

import com.student.util.PropertyReader;
import io.restassured.RestAssured;
import org.junit.BeforeClass;

import static io.restassured.RestAssured.given;

public class BaseClass {


    public static PropertyReader propertyReader;
    public static String accessToken;
    public static String clientId;
    public static String clientSecret;

    @BeforeClass
    public static void initUrl() {
        propertyReader = PropertyReader.getInstance();
        RestAssured.baseURI = propertyReader.getProperty("paypalUrl");
        RestAssured.basePath = "/v1";
        clientId = propertyReader.getProperty("clientId");
        clientSecret = propertyReader.getProperty("clientSecret");

        accessToken = given()
                .params("grant_type", "client_credentials")
                .auth()
                .preemptive()
                .basic(clientId, clientSecret)
                .when()
                .post("oauth2/token")
                .then()
                .extract()
                .path("access_token");
        System.out.println("The accessToken is taken: " + accessToken);
    }
}