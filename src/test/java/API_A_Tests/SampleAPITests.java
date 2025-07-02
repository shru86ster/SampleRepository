package API_A_Tests;

import BaseTest.BaseTest;
import Util.FileHandling;
import Util.JsonReader;
import constantData.StatusCode;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import static io.restassured.RestAssured.when;

public class SampleAPITests extends BaseTest {

    @Test(groups="Regression")

    public void testdataextraction() throws IOException {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-type", "application/json");
        headers.put("Accept", "application/json");
        String jsoncontent = FileHandling.ReadJson("C:\\Users\\Admin\\IdeaProjects\\APITesting\\src\\main\\java\\resources\\testdata\\Requests\\reqres_request1.json");
        Response response= RestAssured
                .given()
                .baseUri("https://reqres.in/")
                .basePath("/api/users")
                .headers(headers)
                .body(jsoncontent)
                .when()
                .post();

        Allure.addAttachment("Response","application/json",response.getBody().asString(),".json");
        Allure.step("Validate job",()->Assert.assertEquals(JsonReader.getJsonElementfromJsonString(response.getBody().asString(),"job"),"leader","The job is not matching with the expected result"));
        Allure.step("Validate status code",()->Assert.assertEquals(response.statusCode(), StatusCode.CREATED.code,"The status code is not matching with the expected result"));



    }

    @Test(groups="Regression")
    public void testFileUploadForRequest() throws IOException {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-type", "application/json");
        headers.put("Accept", "application/json");
        //String jsoncontent = FileHandling.ReadJson("C:\\Users\\Admin\\IdeaProjects\\APITesting\\src\\main\\java\\resources\\testdata\\Requests\\reqres_request1.json");
        File file=new File("C:\\Users\\Admin\\IdeaProjects\\APITesting\\src\\main\\java\\resources\\testdata\\Requests\\reqres_request1.json");
        Response response= RestAssured
                .given()
                .baseUri("https://postman-echo.com")
                .basePath("/post")
                .headers(headers)
                .multiPart("file",file,"application/json")
                .contentType("multipart/form-data")
                //.body(jsoncontent)
                .when()
                .post();

        System.out.println(response.getBody().asString());
        System.out.println(response.statusCode());
       // Assert.assertEquals(JsonReader.getJsonElementfromJsonString(response.getBody().asString(),"job"),"leader","The job is not matching with the expected result");
        //Assert.assertEquals(response.statusCode(), StatusCode.CREATED.code,"The status code is not matching with the expected result");


    }
}
