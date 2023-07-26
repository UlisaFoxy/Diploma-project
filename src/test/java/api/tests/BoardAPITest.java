package api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import api.objects.BoardInfo;
import api.methods.Result;
import api.steps.BoardAPISteps;

import java.util.List;
public class BoardAPITest {
    @Test
    public void checkBoardApi() {
        BoardAPISteps boardApiSteps = new BoardAPISteps();
        Result<List<BoardInfo>> boardInfoResult = boardApiSteps.getBoardForProject(2);
        Assert.assertTrue(boardInfoResult.getResult().size() > 0, "Board request doesn't contain records");
        System.out.println(boardInfoResult.getResult().get(0).getName());
    }
}