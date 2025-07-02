package Util;
import org.testng.asserts.SoftAssert;
public class SoftAssertionUtil {

    SoftAssert softassert=null;
    public SoftAssertionUtil()
    {
        softassert=new SoftAssert();
    }

    public void assertTrue(boolean condition,String message)
    {
        try
        {
           softassert.assertTrue(condition);
        }catch(Exception e)
        {
            softassert.fail(message);
        }
    }

    public void assertEquals(Object expected,Object actual,String message)
    {
        try
        {
            softassert.assertEquals(expected,actual);
        }catch(Exception e)
        {
            softassert.fail(message);
        }
    }

    public void assertAll()
    {
        softassert.assertAll();
    }

}
