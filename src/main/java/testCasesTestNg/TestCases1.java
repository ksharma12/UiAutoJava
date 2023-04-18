package testCasesTestNg;

import org.testng.annotations.*;

public class TestCases1 extends BaseTest{
    @BeforeTest
    public void creatingDBConnection(){
        System.out.println("Before Test Creating DB Connection");
    }
    @BeforeMethod
    public void launchBrowser(){
        System.out.println("Before Method Execution launch browser");
    }
    @Test(priority=2)
    public void doLogin(){
        System.out.println("Executing Login Test");
    }
    @Test(priority=1)
    public void doUserRegistration(){
        System.out.println("Executing User Registration Test");
    }
    @Test(priority=3)
    public void profileCreation(){
        System.out.println("Executing test for profile creation");
    }
    @Test(priority=4)
    public void productListing(){
        System.out.println("Executing test for product listing");
    }
    @Test(priority=5)
    public void navigation(){
        System.out.println("Executing test for navigation");
    }
    @Test(priority=6)
    public void multipleProductSelection(){
        System.out.println("Executing test for multiple product selection");
    }
    @Test(priority=7)
    public void dynamicPageLoad(){
        System.out.println("Executing test for dynamic page load");
    }
    @Test(priority=8)
    public void shoppingCart(){
        System.out.println("Executing test for shopping cart");
    }
    @Test(priority=9)
    public void productSelection(){
        System.out.println("Executing test for product selection");
    }
    @Test(priority=10)
    public void paymentGateway(){
        System.out.println("Executing test for payment gateway");
    }
    @AfterMethod
    public void closeBrowser(){
        System.out.println("After Method Execution close browser");
    }
    @AfterTest
    public void closingDBConnection(){
        System.out.println("After Test closing DB Connection");
    }
}
