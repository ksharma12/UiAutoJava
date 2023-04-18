package testCasesTestNg;

import org.testng.Assert;

public class TestFailure {
    public void doLogin(){
        Assert.fail("Failing the login test");
    }
}
