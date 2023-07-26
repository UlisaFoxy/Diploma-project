package api.steps;
import api.methods.*;
import static api.methods.Projects.*;

import api.objects.ProjectID;
import io.restassured.response.Response;
import api.objects.CreateProjectBody;

import static api.utils.EnvProperties.API_TOKEN;
import static api.utils.EnvProperties.API_USERNAME;
public class ProjectAPISteps extends BaseAPISteps{
    public String createProject (String project_name, String description) {
        CreateProjectBody args = CreateProjectBody.builder()
                .project_name(project_name)
                .description(description)
                .build();

        BodyArgs bodyArgs = BodyArgs.builder()
                .params(args)
                .method(CREATE_PROJECT)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        response.then().statusCode(200);
        Result result = response.as(Result.class);
        return result.getResult().toString();
    }

    public boolean deleteProject(String projectId) {

        BodyArgs bodyArgs = BodyArgs.builder().
                params(new ProjectID(Integer.valueOf(projectId)))
                .method(DELETE_PROJECT)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        return (boolean) response.as(Result.class).getResult();
    }

}
