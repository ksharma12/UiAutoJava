package testCasesTestNg;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase3 extends BaseTest{
    @Test(priority = 1,groups = {"functional","smoke"})
    public void doUserRegistration() {
        System.out.println("Executing User Registration Test");
        Assert.fail("User Registration failed");
    }
    @Test(priority = 2,dependsOnMethods = "doUserRegistration",groups = {"functional","smoke"})
    public void doLogin() {
        System.out.println("Executing Login Test");
    }
    @Test(priority=3,dependsOnMethods = {"doLogin"},groups = {"functional","smoke"},alwaysRun = true)
    public void profileCreation(){
        System.out.println("Executing test for profile creation");
    }

    //Hard dependency example
    @Test(priority=4,groups = "bvt")
    public void productListing(){
        System.out.println("Executing test for product listing");
    }

    //Soft dependency example
    @Test(priority=5,dependsOnMethods = "productListing",alwaysRun = true)
    public void navigation(){
        System.out.println("Executing test for navigation");
    }
}
