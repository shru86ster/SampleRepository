package Util;



import com.fasterxml.jackson.core.JsonParseException;
import io.restassured.path.json.JsonPath;
import net.minidev.json.JSONArray;


import java.util.List;

import static Util.FileHandling.ReadJson;

public class JsonReader {

    public static void newfun()
    {}

    //Read from the filepath provided
    public static List<Object> getJsonArray(String jsonfilepath, String arrayJsonPath)
    {
        String jsoncontent=FileHandling.ReadJson(jsonfilepath);
        JsonPath jsonpath=new JsonPath(jsoncontent);
        List<Object> jsonarray=jsonpath.getList(arrayJsonPath);
        //JsonArray jsonarray = JsonPath.read(jsoncontent, arrayJsonPath);
        return jsonarray;
    }

    public static Object getJsonElement(String jsonfilepath, String elementJsonPath)
    {
        String jsoncontent=FileHandling.ReadJson(jsonfilepath);
        JsonPath jsonpath=new JsonPath(jsoncontent);
        Object jsonelement=jsonpath.get(elementJsonPath);
        //JsonArray jsonarray = JsonPath.read(jsoncontent, arrayJsonPath);
        return jsonelement;
    }

    public static Object getJsonElementfromJsonString(String jsonString, String elementJsonPath)
    {
        JsonPath jsonpath=new JsonPath(jsonString);
        Object jsonelement=jsonpath.get(elementJsonPath);
        //JsonArray jsonarray = JsonPath.read(jsoncontent, arrayJsonPath);
        return jsonelement;
    }
}
