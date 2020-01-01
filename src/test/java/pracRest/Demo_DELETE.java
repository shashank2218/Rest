package pracRest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class Demo_DELETE {

    @Test
    public void testDELETE() {

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        RestAssured.basePath = "/delete/21000";

        Response response =
            when()
                .delete()
            .then()
                .statusCode(200)
                .log().all()
                .extract().response();

        String jsonResponse = response.asString();
        Assert.assertEquals(jsonResponse.contains("successfully!"), true);
    }
}
