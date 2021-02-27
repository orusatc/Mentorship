package tests.lesson2.restAssured;

 /*Good tutorial for beginners
https://www.youtube.com/watch?v=iXQimBnjgfc&list=RDCMUCTt7pyY-o0eltq14glaG5dg&index=5&ab_channel=AutomationStepbyStep-RaghavPal
*/

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RestAssuredTest {

    String baseUrl = "https://reqres.in/api/users?page=2";

    @BeforeSuite
    public void setPresonditions() {
        baseURI = "https://reqres.in";
    }

    @Test
    public void restTest1() {
        Response responce = get(baseUrl);
        System.out.println(responce.getStatusCode());
        System.out.println(responce.getTime());
        System.out.println(responce.getBody().asString());
        System.out.println(responce.getStatusLine());
        System.out.println(responce.getHeader("content-type"));
        Assert.assertEquals(responce.getStatusCode(), 200);
    }

    @Test
    public void restTest2() {
        given().get(baseUrl).then().statusCode(200).body("page", is(2));
    }

    @Test
    public void restTest3() {
        given().get(baseUrl).then().statusCode(200).body("data[2].id", equalTo(9)).log().all();
    }

    @Test
    public void restTest4() {
        given().
                get("/api/users?page=2").
                then().
                statusCode(200).
                body("data[0].email", equalTo("michael.lawson@reqres.in")).
                body("data[0].email", containsString("michael"));
    }

    @Test
    public void restTest5() {

        JSONObject request = new JSONObject();
        request.put("name", "Orysia");
        request.put("job", "learner");

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("/api/users").
                then().
                statusCode(201).
                log().all();
    }

    @Test
    public void restTest6() {

        JSONObject request = new JSONObject();
        request.put("name", "Orysia Rusanovska");
        request.put("job", "learner");

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                put("/api/users/2").
                then().
                statusCode(200).
                log().all();
    }

    @Test
    public void restTest7() {

        JSONObject request = new JSONObject();
        request.put("name", "Rusanovska Orysia");
        request.put("job", "learner");

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                patch("/api/users/2").
                then().
                statusCode(200).
                log().all();
    }


    @Test
    public void restTest8() {
        when().
                delete("/api/users/2").
                then().
                statusCode(204).
                log().all();
    }
}
