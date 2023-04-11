import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class WaitOperations {
    WebDriver driver ;
    Wait<WebDriver> wait;
    int explicitWait ;
    int fluentWait;
    public WaitOperations(WebDriver driver){
        this.driver = driver;
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
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void waitUntilTitleIs(String title){
        try{
            waiting().until(ExpectedConditions.titleIs(title));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void waitUntilAttributeContains(By locator, String attribute, String value){
        try{
            waiting().until(ExpectedConditions.attributeContains(locator,attribute,value));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void waitUntilAttributeContains(WebElement element, String attribute, String value){
        try{
            waiting().until(ExpectedConditions.attributeContains(element,attribute,value));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void waitUntilElementClickable(By locator){
        try{
            waiting().until(ExpectedConditions.elementToBeClickable(locator));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
