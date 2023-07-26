package api.steps;

import api.objects.CreateUserBody;
import io.restassured.response.Response;
import api.methods.Result;
import api.methods.BodyArgs;
import api.objects.UserID;
import static api.methods.Users.*;
import static api.utils.EnvProperties.API_TOKEN;
import static api.utils.EnvProperties.API_USERNAME;
import static java.lang.Integer.valueOf;

public class UserAPISteps extends BaseAPISteps {
    public String createUser(String username, String pass) {
        CreateUserBody args = CreateUserBody.builder()
                .username(username)
                .name(username)
                .password(pass)
                .email(username + "@mail.com")
                .build();

        BodyArgs bodyArgs = BodyArgs.builder().
                params(args)
                .method(CREATE_USER)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        response.then().statusCode(200);
        Result result = response.as(Result.class);
        return result.getResult().toString();
    }
    public boolean deleteUser(String userId) {

        BodyArgs bodyArgs = BodyArgs.builder().
                params(new UserID(Integer.valueOf(userId)))
                .method(DELETE_USER)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        return (boolean) response.as(Result.class).getResult();
    }

}
