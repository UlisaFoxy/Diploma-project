package api.steps;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import api.methods.BodyArgs;

import static api.utils.EnvProperties.API_URL;

public class BaseAPISteps {
    public Response postRequest(String username, String token, BodyArgs bodyArgs) {
        return RestAssured.given()
                .auth().basic(username, token)
                .body(bodyArgs)
                .when()
                .post(API_URL);
    }
}