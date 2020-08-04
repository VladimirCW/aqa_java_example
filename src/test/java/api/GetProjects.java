package test.java.api;

import edu.emory.mathcs.backport.java.util.Arrays;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.utils.PropertyLoader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.testng.Assert.assertTrue;

@Epic("Get projects API")
public class GetProjects {
    long createdId;

    @BeforeMethod
    public void setUp() {

    }

    @Feature("With valid token")
    @Story("Get all projects")
    @Test
    public void get() {
        List<String> gendersExpected = Arrays.asList(new String[] {"male", "female", "n/a"});
        //RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        //RestAssured.config = config().logConfig(logConfig().enableLoggingOfRequestAndResponseIfValidationFails());
        Response response = given()/*.log().method()*/
                .header("Authorization", "Bearer 3ced13d788099558737094cb488eee0524ff8517")
                .param("page", "3")
        .when()
                //.get(PropertyLoader.loadProperty("api.url") + "/projects/2237619831")
                .get("https://swapi.dev/api/people/");
        JsonPath path = response.jsonPath();
        System.out.println((Integer) path.get("count"));
        System.out.println((String) path.get("next"));
        Map<String, Object> map = (Map<String, Object>) path.getList("results").get(0);
        System.out.println(map.get("name"));
        List<Map> list = path.getList("results");
        List<String> gendersActual = new ArrayList<>();
        for (Map map1: list) {
            System.out.println((String) map1.get("gender"));
            gendersActual.add((String) map1.get("gender"));
        }
        for (String gender: gendersActual) assertTrue(gendersExpected.contains(gender), String.format("Found gender: '%s'", gender));

        /*response
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("C:\\Users\\Volodymyr_Dmytriukhi\\itea\\group4\\lesson2\\src\\test\\resources\\getProjectsSchema.json"));*/

        //System.out.println((Object) path.getMap("results").size());
        //System.out.println((Object) path.getMap("results[0]").size());
        //assertEquals(actualResponse, 82);
        //response.prettyPrint();
        //System.out.println(response.asString());
        //assertEquals(200, response.statusCode());
    }

    @Test
    public void getWithValidationJson() {
        given()
                .header("Authorization", "Bearer 3ced13d788099558737094cb488eee0524ff8517")
        .when()
                .get(PropertyLoader.loadProperty("api.url") + "/projects")
        .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("getProjectsSchema.json"));
    }

    @Feature("With valid token")
    @Story("Get all projects")
    @Test
    public void create() {
        /*String bodyString = "{" +
                "\"name\": \"Movies to watch\"," +
                "\"comment_count\": 0," +
                "\"color\": 47," +
                "\"shared\": false," +
                " \"sync_id\": 0," +
                " \"order\": 1" +
                "}";*/
        /*HashMap<String, String> map = new HashMap<>();
        map.put("name", "Movies to watch");
        map.put("comment_count", "0");
        map.put("color", "47");
        map.put("shared", "false");
        map.put("sync_id", "0");
        map.put("order", "1");*/
        Object newId = given()/*.log().method()*/
            .header("Authorization", "Bearer 3ced13d788099558737094cb488eee0524ff8517")
            //.contentType(ContentType.JSON)
            .header("Content-Type", "application/json")/*.log().all()*/
            //.body(bodyString)
            .body(new File("C:\\Users\\Volodymyr_Dmytriukhi\\itea\\group4\\lesson2\\src\\test\\java\\api\\createProjectBody.json"))
            /*.formParam("name", "Movies to watch")
            .formParam("comment_count", "0")
            .formParam("color", "4https://github.com/Olha2805/Artefacts/
            7")
            .formParam("shared", false)
            .formParam("sync_id", 0)
            .formParam("order", 1)*/
        .when()
            .post(PropertyLoader.loadProperty("api.url") + "/projects")
        .then()
            .statusCode(200)
            .extract()
            .path("id");
        System.out.println("ID = " + newId);
        createdId = (long) newId;
    }

    @Test(dependsOnMethods = "create")
    public void delete() {
        given()
            .header("Authorization", "Bearer 3ced13d788099558737094cb488eee0524ff8517")
        .when()
            .delete(PropertyLoader.loadProperty("api.url") + "/projects/" + createdId)
        .then()
            .statusCode(204);
    }
}
