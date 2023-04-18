package testCasesTestNg;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestSkip {
    @Test
    public void ForceFullSkipTest(){
        System.out.println("Testcase forcefully skipping");
        throw new SkipException("Skipping the test forcefully if condition not met");
    }
}
