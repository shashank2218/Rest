package practice;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Get {

    @Test
    public void GetWeatherDetails()
    {
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification httpReq = RestAssured.given();
        Response response = httpReq.request(Method.GET, "/Hyderabad");

        String responseBody = response.getBody().asString();
        System.out.println("Response" + responseBody);

//        int statusCode = response.getStatusCode();
//        String statusLine = response.getStatusLine();
//        System.out.println(statusCode);
//        System.out.println(statusLine);
//        Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
//        Assert.assertEquals(statusCode,200);
//
//
//        String server = response.header("server");
//        System.out.println(server);

        JsonPath jsonPathEvaluator = response.jsonPath();
        String city = jsonPathEvaluator.get("City");

        System.out.println("City received from Response " + city);
        Assert.assertEquals(city, "Hyderabad", "Correct city name received in the Response");


    }
}
