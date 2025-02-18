import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.logging.Logger;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class RestAsp {

    RequestSpecification specification;
    String sshKey;
    int keyID;

    @BeforeClass
    public void setup(){
        specification =  new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addHeader("Authorization" , "Bearer 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")
                .setBaseUri("https://api.github.com")
                .build();
    }

    @Test (priority = 1)
    public void postM() {
        System.out.println("Post block Executing");
        System.out.println("--------------------");

        String reqBody = """
                {
                "title": "TestAPIKey" , 
                "key": "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIDqVDjfyCAmYtXsVl4HpyZ1XpI7bhW5uO8z9UuTeHFbl"
                }
                """;
        Response response = given()
                .spec(specification)
                .body(reqBody)
                .when().post("/user/keys");

        String resBody = response.getBody().asPrettyString();
        System.out.println("The Value of Response is :" + resBody);

        keyID = response.then().extract().path("id");
        System.out.println("KeyID value of POST Method is: " + keyID);
        response.then().statusCode(201);

    }
    @Test (priority = 2)
    public void getM(){
        System.out.println("Get method executed");
        System.out.println("--------------------");

        Response response = given()
                .spec(specification)
                .when()
                .pathParams("keyID" , keyID)
                .get("/user/keys/{keyID}");

        String reqBody = response.getBody().asPrettyString();
        System.out.println("The Value of Request is :" +reqBody);

        keyID = response.then().extract().path("id");
        System.out.println("KeyID value of POST Method is: " +keyID);
        response.then().statusCode(200);

    }
    @Test (priority = 3)
    public void deleteM(){

        System.out.println("DELETing");
        System.out.println("--------------------");

        Response response =given()
                .spec(specification)
                .pathParams("keyID" , keyID)
                .when().delete("/user/keys/{keyID}");

        String reqBody = response.getBody().asPrettyString();
        System.out.println("The Value of Request is empty: " + reqBody.isBlank());

        ValidatableResponse stat = response.then().statusCode(204);
        System.out.println("Validated delete response as: " + stat);

    }

    @AfterClass
    public void tearDown(){
        System.out.println("Finally closing the process");

    }
}
