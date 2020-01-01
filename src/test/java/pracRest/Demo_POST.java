package pracRest;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class Demo_POST {

    public static HashMap map = new HashMap();
    @BeforeClass
    public void postData() {
        RestAssured.baseURI = "http://restapi.demoqa.com/customer";
        RestAssured.basePath = "/register";

        map.put("FirstName", "John");
        map.put("LastName", "Doe");
        map.put("UserName", "John2218");
        map.put("Password", "John1234");
        map.put("Email", "johndoe1234@gmail.com");

    }

    @Test
    public void testPost() {

        given()
                .contentType("application/json")
                .body(map)

        .when()
                .post()

        .then()
                .statusCode(201)
                .and()
                .body("SuccessCode", equalTo("OPERATION_SUCCESS"))
                .body("Message", equalTo("Operation completed successfully"));
    }
}
