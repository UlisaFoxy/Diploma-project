package api.steps;

import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import api.objects.BoardInfo;
import api.methods.Result;
import api.methods.BodyArgs;
import api.objects.ProjectID;

import java.util.List;

import static api.methods.Boards.GET_BOARD;
import static api.utils.EnvProperties.API_TOKEN;
import static api.utils.EnvProperties.API_USERNAME;


public class BoardAPISteps extends BaseAPISteps {
    public Result<List<BoardInfo>> getBoardForProject(Integer projectId) {

        BodyArgs bodyArgs = BodyArgs.builder().
                params(new ProjectID(projectId))
                .method(GET_BOARD)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        return response.as(new TypeRef<Result<List<BoardInfo>>>() {});

//        return response.as(Result.class);
    }
}


