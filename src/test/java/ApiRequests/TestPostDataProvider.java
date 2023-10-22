package ApiRequests;

import DataRequestLibrary.Lib2PostReqData;
import DataRequestLibrary.LibReqResData;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestPostDataProvider {

    Lib2PostReqData lib;
    RequestSpecification reqSpec;
    String BaseURL = "https://reqres.in";
    String Basepath = "/api/users";

    @BeforeClass
    public void before() {
        //LibReqResData lib = new LibReqResData();

        lib = new Lib2PostReqData();
        RestAssured.baseURI=BaseURL;
        RestAssured.basePath=Basepath;
        //RequestSpecification reqSpec = RestAssured
        reqSpec = RestAssured
                .given()
                .header("Content-Type", "application/json");

    }

    @Test (dataProvider = "dp")
    public void PostRequestRes2(String strName, String strRole) {


            lib.setStrName(strName);
            lib.setStrRole(strRole);
            JSONObject user = lib.DataJsonCreateUser();
            System.out.println(user.toString());

            Response resp = reqSpec
                    .body(user.toString())
                    .when()
                    .post();
            Assert.assertEquals(resp.getStatusCode(), 201);
            JsonPath jsonPath = resp.jsonPath();

            Assert.assertEquals(jsonPath.getString("name"), strName);
            Assert.assertEquals(jsonPath.getString("job"), strRole);
    }
    @DataProvider
    public String[][] dp() {
        return new String[][]{
                new String[]{"Asim", "QL"},
                new String[]{"Bassra", "TM"},
                new String[]{"Sharyar", "TM"},
        };
    }


}
