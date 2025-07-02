package API_A_Tests;


import BaseTest.BaseTest;
import Util.FileHandling;
import Util.JsonReader;
import Util.SoftAssertionUtil;
import com.fasterxml.jackson.databind.ser.Serializers;
import constantData.StatusCode;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
//import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

//import io.restassured.path.json.JsonPath;

import java.io.IOException;
import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class APITests extends BaseTest {
    @Test(groups="Smoke")
    public void DemoAPI() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-type", "application/json");
        headers.put("Accept", "application/json");

        //Response response=
        given().baseUri("https://reqres.in/")
                .headers(headers)
                .get("api/users?page=2")
                .then()
                .body("data[0].id", equalTo(7))
                .body("data.id", hasSize(6))
                .body("data.id", hasItems(7, 9, 10))
                .body("data.id", contains(7, 8, 9, 10, 11, 12))
        ;
        Response response=given().baseUri("https://reqres.in/")
                .headers(headers)
                .get("api/users?page=2");

        SoftAssertionUtil softassertutil=new SoftAssertionUtil();
        softassertutil.assertEquals(response.statusCode(),StatusCode.SUCCESS.code,"The status code is incorrect");

        Assert.assertEquals(response.statusCode(), StatusCode.SUCCESS.code);

        //.body("gender",equalTo("female"));
        //System.out.println(response.getBody().asString());
        //response.body("results[0].gender",equalTo("male"));


        //JsonPath jsonpath=response.jsonPath();
        //String gender=jsonpath.getString("results[0].gender");

        //assertThat(gender,equalTo("male"));

        //validate the response body

    }
    @Test(groups="Regression")
    public void RequestBodyfromFile() throws IOException {
        String filepath="C:\\Users\\Admin\\IdeaProjects\\APITesting\\src\\main\\java\\resources\\testdata\\TestData.json";

        String jsoncontent = FileHandling.ReadJson(filepath);



        String baseurl = FileHandling.ReadProperties("C:\\Users\\Admin\\IdeaProjects\\APITesting\\config.properties", "Baseurl");

        System.out.println("The base url from properties file is " + baseurl);
        System.out.println("The departments are " + JsonReader.getJsonArray("C:\\Users\\Admin\\IdeaProjects\\APITesting\\src\\main\\java\\resources\\testdata\\TestData.json","Student"));
        System.out.println("The contact are " + JsonReader.getJsonArray("C:\\Users\\Admin\\IdeaProjects\\APITesting\\src\\main\\java\\resources\\testdata\\TestData.json","contact"));
        System.out.println("The url is " + JsonReader.getJsonElement("C:\\Users\\Admin\\IdeaProjects\\APITesting\\src\\main\\java\\resources\\testdata\\TestData.json","support.url"));
        System.out.println("The username is " + JsonReader.getJsonElement("C:\\Users\\Admin\\IdeaProjects\\APITesting\\src\\main\\java\\resources\\testdata\\TestData.json","username"));

    }

}