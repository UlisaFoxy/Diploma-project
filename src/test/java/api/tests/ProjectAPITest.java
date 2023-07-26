package api.tests;

import api.steps.ProjectAPISteps;
import org.testng.annotations.Test;

public class ProjectAPITest extends BaseAPITest {
    private static final String PROJECT_NAME = "My API project";
    private static final String DESCRIPTION = "Here I create the API project";
    ProjectAPISteps projectApiSteps = new ProjectAPISteps();
    private String projectId;

    @Test
    public void createProjectAPItest() {
        projectId = projectApiSteps.createProject(PROJECT_NAME, DESCRIPTION);
        System.out.println(projectId);

    }

}
