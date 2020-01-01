package practice;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class P1 {

    @Test
    public void GivPract() {

        given().get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad").
        then().
                statusCode(200).
                contentType(ContentType.JSON);

    }
}
