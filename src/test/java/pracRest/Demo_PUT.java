package pracRest;

import io.restassured.RestAssured;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Demo_PUT {

    public static HashMap map = new HashMap();
    int empId = 11254;
    String empName = "Snow"+RandomStringUtils.randomAlphabetic(1);
    String empSalary = RandomStringUtils.randomNumeric(5);
    String empAge = RandomStringUtils.randomNumeric(2);

    @BeforeClass
    public void putData() {

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        RestAssured.basePath = "/update/"+empId;

        map.put("name", empName);
        map.put("salary", empSalary);
        map.put("age", empAge);

    }

    @Test
    public void testPUT() {

        given()
                .contentType("application/json")
                .body(map)
        .when()
                .put()
        .then()
                .statusCode(200)
                .log().all();

    }
}
