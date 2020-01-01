package pracRest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Demo_GET {

    @Test
    public void getWeaterDet() {

        given()
        .when()
                .get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad")
        .then()
                .statusCode(200)
                .contentType("application/json")
                .assertThat().body("City", equalTo("Hyderabad"));

    }
}
