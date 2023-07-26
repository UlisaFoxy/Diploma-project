package api.steps;

import api.methods.*;
import static api.methods.Tasks.*;

import api.objects.CreateTaskBody;
import api.objects.TaskID;
import io.restassured.response.Response;

import static api.utils.EnvProperties.API_TOKEN;
import static api.utils.EnvProperties.API_USERNAME;

public class TaskAPISteps extends BaseAPISteps {
    public String createTask(String tittle, String description, Integer project_id,Integer priority) {
        CreateTaskBody args = CreateTaskBody.builder()
                .tittle(tittle)
                .description(description)
                .project_id(project_id)
                .priority(priority)
                .build();

        BodyArgs bodyArgs = BodyArgs.builder().
                params(args)
                .method(CREATE_TASK)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        response.then().statusCode(200);
        Result result = response.as(Result.class);
        return result.getResult().toString();
    }
    public boolean deleteTask(String taskId) {

        BodyArgs bodyArgs = BodyArgs.builder().
                params(new TaskID(Integer.valueOf(taskId)))
                .method(DELETE_TASK)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        return (boolean) response.as(Result.class).getResult();
    }

}
