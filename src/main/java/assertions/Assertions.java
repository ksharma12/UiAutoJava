package assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class Assertions {
    public void assertingBooleanValues(int a, int a1){
        try{
            Assert.assertEquals(a,a1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
