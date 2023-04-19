package seleniumOperations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test extends SeleniumOperations{
    static WebDriver driver;
    public Test(WebDriver driver) {
        super(driver);
    }

    public static void main(String[] args) {
        driver = new ChromeDriver();
        Test test = new Test(driver);
        test.getUrl("https://www.google.com/");
    }
}
