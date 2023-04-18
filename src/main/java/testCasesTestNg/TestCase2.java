package testCasesTestNg;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCase2 extends BaseTest{

    @Test
    public void validateTitles() {
        String expectedTitle = "Yahoo.com";
        String actualTitle = "Gmail.com";
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void hardAssertionsExample() {
        SoftAssert softAssert = new SoftAssert();
        String expectedTitle = "Yahoo.com";
        String actualTitle = "Gmail.com";
        System.out.println("starting hard assertions");
        Assert.assertEquals(expectedTitle, actualTitle); // hard assertion
        Assert.fail();
        System.out.println("Validating Image");
        Assert.assertEquals(true, false); // hard assertion
        System.out.println("validating text box");
        Assert.assertEquals(true, false); // hard assertion
        System.out.println("ending hard assertions");
    }

    @Test
    public void softAssertionsExample() {
        SoftAssert softAssert = new SoftAssert();
        String expectedTitle = "Yahoo.com";
        String actualTitle = "Gmail.com";
        System.out.println("starting soft assertions");
        softAssert.assertEquals(expectedTitle, actualTitle); // soft assertion
        System.out.println("Validating Image");
        softAssert.assertEquals(true, false, "Image is not valid"); // hard assertion
        System.out.println("validating text box");
        softAssert.assertEquals(true, false, "Text Box is not valid"); // hard assertion
        System.out.println("ending soft assertions");
        softAssert.assertAll();
    }

    // Creating Test Dependencies (Login Tests must be dependent on User Registration, it means if user registration failed then doLogin will skip)
    @Test(priority = 2,dependsOnMethods = "doUserRegistration")
    public void doLogin() {
        System.out.println("Executing Login Test");
    }
    @Test(priority = 1)
    public void doUserRegistration() {
        System.out.println("Executing User Registration Test");
        Assert.fail("User Registration failed");
    }
    @Test(priority=3,dependsOnMethods = {"doLogin"})
    public void profileCreation(){
        System.out.println("Executing test for profile creation");
    }

    //Hard dependency example
    @Test(priority=4,dependsOnMethods = {"doLogin","profileCreation"})
    public void productListing(){
        System.out.println("Executing test for product listing");
    }

    //Soft dependency example
    @Test(priority=5,dependsOnMethods = "productListing",alwaysRun = true)
    public void navigation(){
        System.out.println("Executing test for navigation");
    }
}

