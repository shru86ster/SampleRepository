package API_B_Tests;

import BaseTest.BaseTest;
import Util.SoftAssertionUtil;
import constantData.StatusCode;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class APINewTests extends BaseTest {



    @DataProvider(name="pagenumber")
    public Object[][] apiTestDataProvider()
    {
        Hashtable<Object,Object> hashtable=new Hashtable<>();

        hashtable.put("page1",1);
        hashtable.put("page2",2);
        hashtable.put("page3",3);

        Object[][] obj=new Object[hashtable.size()][2];

        int i=0;
        for(Map.Entry<Object,Object> k:hashtable.entrySet())
        {
            obj[i][0]=k.getKey();
            obj[i][1]=k.getValue();
            i++;
        }
        System.out.println(obj[0][0]);
        System.out.println(obj[0][1]);
        System.out.println(obj[1][0]);
        System.out.println(obj[1][1]);
        System.out.println(obj[2][0]);
        System.out.println(obj[2][1]);
        return obj;
    }
    @Test(description="demofeature",dataProvider="pagenumber",groups="Smoke")
    public void samplestest()
    {

    }


    @Test(description="demo1final",dataProvider="pagenumber",groups="Smoke")
    @Parameters({"page","pagenum"})
    public void masterfinaldem(Object page,Object pagenum)
    {
        System.out.println("chekcing");
    }
    @Test(description="newtest",dataProvider="pagenumber",groups="Smoke")
    @Parameters({"page","pagenum"})
    public void DemoAPI(Object page,Object pagenum) {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-type", "application/json");
        headers.put("Accept", "application/json");

        //Response response=
        given().baseUri("https://reqres.in/")
                .headers(headers)
                .queryParam(page.toString(),pagenum) //key should always be a string
                .get("api/users")

        ;
        Response response=given().baseUri("https://reqres.in/")
                .headers(headers)
                .queryParam(page.toString(),pagenum)
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





}