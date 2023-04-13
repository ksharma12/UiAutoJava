import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class WaitOperations {
    private static List<WebElement> elements;
    private static WebElement element;
    private static WebDriver driver ;
    private static By selector;
    private static Wait<WebDriver> wait;
    private static int explicitWait;
    private static int fluentWait;

    public WaitOperations(WebDriver driver){
        WaitOperations.driver = driver;
    }
    public By selector(String locator) {
        try {
            String locatorSignature = locator.split("__")[1];
            String locatorValue = locator.split("__")[0];
            switch (locatorSignature) {
                case "xpath":
                    selector = By.xpath(locatorValue);
                    break;
                case "id":
                    selector = By.id(locatorValue);
                    break;
                case "cssSelector":
                    selector = By.cssSelector(locatorValue);
                    break;
                case "name":
                    selector = By.name(locatorValue);
                    break;
                case "partialLinkText":
                    selector = By.partialLinkText(locatorValue);
                    break;
                case "className":
                    selector = By.className(locatorValue);
                    break;
                case "tagName":
                    selector = By.tagName(locatorValue);
                    break;
                default:
                    selector = By.linkText(locatorValue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return selector;
    }
    public WebElement findElement(String locator){
        try {
            element = driver.findElement(selector(locator));
            System.out.println("successfully found element "+element);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return element;
    }
    public List<WebElement> findElements(String locator){
        try {
            elements = driver.findElements(selector(locator));
            System.out.println("successfully found elements "+elements);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return elements;
    }
    public Wait<WebDriver> waiting() {
        if (wait == null) {
            try {
                wait = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(explicitWait))
                        .pollingEvery(Duration.ofSeconds(fluentWait))
                        .ignoring(NoSuchElementException.class);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return wait;
    }
    public void waitUntilAlertIsPresent(){
        try{
            waiting().until(ExpectedConditions.alertIsPresent());
            System.out.println("Waited till alert is present");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void waitUntilTitleIs(String title){
        try{
            waiting().until(ExpectedConditions.titleIs(title));
            System.out.println("waited till title is "+title);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void waitUntilAttributeContains(String locator, String attribute, String value){

        try{
            waiting().until(ExpectedConditions.attributeContains(selector(locator),attribute,value));
            System.out.println("waited till locator "+locator+" attribute "+attribute+" contains "+value);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void waitUntilAttributeContains(WebElement element, String attribute, String value){
        try{
            waiting().until(ExpectedConditions.attributeContains(element,attribute,value));
            System.out.println("waited till web element "+element+" attribute "+attribute+" contains "+value);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void waitUntilElementClickable(String locator){
        try{
            waiting().until(ExpectedConditions.elementToBeClickable(selector(locator)));
            System.out.println("waited till locator "+locator+" will be clickable");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void waitUntilElementClickable(WebElement element){
        try{
            waiting().until(ExpectedConditions.elementToBeClickable(element));
            System.out.println("waited till web element "+element+"is clickable");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void waitUntilAttributeToBe(String locator,String attribute,String value){
        try{
            waiting().until(ExpectedConditions.attributeToBe(selector(locator),attribute,value));
            System.out.println("waited till attribute "+attribute+" value to be "+value);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void waitUntilVisible(String locator){
        try{
            WebElement element = findElement(locator);
            waiting().until(ExpectedConditions.visibilityOf(element));
            System.out.println("waited till element "+ element +" is visible");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WaitOperations obj = new WaitOperations(driver);
        driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
        driver.manage().window().maximize();
        obj.waitUntilElementClickable(ObjectRepository.checkBox_1);
        obj.findElement(ObjectRepository.checkBox_1).click();
        Thread.sleep(2000);
        driver.quit();
    }
}
