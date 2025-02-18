
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;


public class TestDetails {

    @Test
    public void GetPetDetails() {
        // Specify the base URL to the RESTful web service
        baseURI = "https://petstore.swagger.io/v2/pet";

        // Make a request to the server by specifying the method Type and
        // resource to send the request to.
        // Store the response received from the server for later use.
        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .when().get(baseURI + "/findByStatus?status=sold"); // Run GET request

        // Now let us print the body of the message to see what response
        // we have received from the server
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is =>  " + responseBody);

        // Assertions
        response.then().statusCode(200);
        //response.then().statusCode(anyOf(is(200), is(201), is(202), is(203), is(204)));
        System.out.println("Check for Status code response: " + response.then().body("[0].status", equalTo("sold")));

        String responseBody1 = response.getBody().prettyPrint();
        System.out.println("Response Body1 is =>  " + responseBody1);

        List<Header> responseHeaders = response.getHeaders().asList();
        Headers responseHeaders1 = response.then().extract().headers();
        response.then().extract().headers().hasHeaderWithName("Date");


    }

}
