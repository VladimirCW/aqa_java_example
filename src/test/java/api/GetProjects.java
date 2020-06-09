package test.java.api;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.utils.PropertyLoader;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Epic("Get projects API")
public class GetProjects {

    @BeforeMethod
    public void setUp() {

    }

    @Feature("With valid token")
    @Story("Get all projects")
    @Test
    public void statusCode() {
        //RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        //RestAssured.config = config().logConfig(logConfig().enableLoggingOfRequestAndResponseIfValidationFails());
        given()/*.log().method()*/
                .header("Authorization", "Bearer 3ced13d788099558737094cb488eee0524ff8517")
                .get(PropertyLoader.loadProperty("api.url") + "/projects")
                .then()
                .statusCode(201)
                .body("id", equalTo("d"));
        //response.prettyPrint();
        //System.out.println(response.asString());
        //assertEquals(200, response.statusCode());
    }

    @Test
    public void amount() {

    }
}
