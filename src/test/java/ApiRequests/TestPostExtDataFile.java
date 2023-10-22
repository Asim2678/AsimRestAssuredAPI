package ApiRequests;

import DataRequestLibrary.Lib3PostExtData;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestPostExtDataFile {

    Lib3PostExtData lib;
    RequestSpecification reqSpec;
    String BaseURL = "https://reqres.in";
    String Basepath = "/api/users";

    @BeforeClass
    public void before() {


        lib = new Lib3PostExtData();
        RestAssured.baseURI = BaseURL;
        RestAssured.basePath = Basepath;
        reqSpec = RestAssured
                .given()
                .header("Content-Type", "application/json");

    }

    @Test
    public void PostRequestRes3() {

        String userData = lib.ReadFiletoString();
        System.out.println(userData);

        Response resp = reqSpec
                .body(userData)
                .when()
                .post();
        Assert.assertEquals(resp.getStatusCode(), 201);
        JsonPath jsonPath = resp.jsonPath();
        System.out.println(resp.getBody().asString());
        System.out.println(jsonPath.getString("id"));
        System.out.println(jsonPath.getString("name"));


    }

}
