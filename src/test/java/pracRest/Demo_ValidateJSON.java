package pracRest;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class Demo_ValidateJSON {

    @Test
    public void validateSingleValue() {

        RestAssured.baseURI = "http://services.groupkt.com/country/get";
        RestAssured.basePath = "/iso2code/IN";
        when()
                .get()
        .then()
                .statusCode(200)
                .body("RestResponse.result.name", equalTo("India"));
    }
}
