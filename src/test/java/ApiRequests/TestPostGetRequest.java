package ApiRequests;

import DataRequestLibrary.LibReqResData;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPostGetRequest {
    String BaseURL = "https://reqres.in";
    String Basepath = "/api/users";
    @Test
    public void GetRequestRes(){
        String ID = "/3";
        String expectedfirstName = "Emma";


    //String BaseURL = "https://reqres.in";
   // String Basepath = "/api/users/";
        RestAssured.baseURI=BaseURL;
        RestAssured.basePath = Basepath;

        Response response = RestAssured
                .given()
                .when()
                .get(ID);
        System.out.println(response.asString());
        ResponseBody body = response.getBody();
        System.out.println(body.asString());


        //created a jason path object.. to extract/print the data
        JsonPath JsonPath = response.jsonPath();
        System.out.println(JsonPath.getString("data.id"));
        System.out.println(JsonPath.getString("data.first_name"));
        System.out.println(JsonPath.getString("data.last_name"));
        System.out.println(JsonPath.getString("data.email"));

        System.out.println(JsonPath.getString("support.url"));
        System.out.println(JsonPath.getString("support.text"));


        //data validation
        String actualFirstName = JsonPath.getString("data.first_name");

        Assert.assertEquals(actualFirstName, expectedfirstName);
        if(expectedfirstName.equals(actualFirstName)){
            System.out.println("The first name is EMMA");
        }else {
            System.out.println("Test failed");
        }

        String actualurl = JsonPath.getString("support.url");
        String expecturl = "https://reqres.in/#support-heading";
        Assert.assertEquals(actualFirstName, expectedfirstName);
        if(expecturl.equals(actualurl)){
            System.out.println("The URL is correct");
        }else {
            System.out.println("The URL is incorrect");
        }

    }
@Test
    public void PostRequestRes(){

        RestAssured.baseURI=BaseURL;
        RestAssured.basePath = Basepath;
      //  RequestSpecification given = RestAssured.given();
        //Created json object to pass the values in post request body
        JSONObject jsonObject =new JSONObject();
        jsonObject.put("name", "Asim");
        jsonObject.put("job", "QA Lead");


       Response response = RestAssured
                .given()
               .header("Content-Type", "application/json")
               .body(jsonObject.toString())
               .when()
               .post();


       System.out.println(response.getStatusCode());

       System.out.println(response.getBody().asString());
// created a json object to get the values from the body

       JsonPath jsonPath = response.jsonPath();

    System.out.println(jsonPath.getString("id"));
    System.out.println(jsonPath.getString("name"));
    System.out.println(jsonPath.getString("job"));
    System.out.println(jsonPath.getString("createdAt"));


    }
    @Test
    public void PostRequestRes2(){

        RestAssured.baseURI=BaseURL;
        RestAssured.basePath = Basepath;
        //  RequestSpecification given = RestAssured.given();
        //Created instance of Librequesnt data's instance.
LibReqResData lib = new LibReqResData();
JSONObject newuser = lib.DataJsonCreateUser();


        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(newuser.toString())
                .when()
                .post();


        System.out.println(response.getStatusCode());

        System.out.println(response.getBody().asString());
// created a json object to get the values from the body

        JsonPath jsonPath = response.jsonPath();

        System.out.println(jsonPath.getString("id"));
        System.out.println(jsonPath.getString("name"));
        System.out.println(jsonPath.getString("job"));
        System.out.println(jsonPath.getString("createdAt"));


    }


}
