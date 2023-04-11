import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;

public class SeleniumOperations extends WaitOperations{
    WebElement element;
    WebElement sourceElement;
    WebElement targetElement;
    List<WebElement> elements;
    WebDriver driver ;
    Actions actions;
    public SeleniumOperations(WebDriver driver){
        super(driver);
        this.driver = driver;
        this.actions = new Actions(driver);
    }
    public WebElement findElement(By locator){
        if (element == null){
            try{
                element = driver.findElement(locator);
                System.out.println("Successfully find element: "+element);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return element;
    }
    public List<WebElement> findElements(By locator){
        if (elements == null){
            try{
                elements = driver.findElements(locator);
                System.out.println("Successfully find elements: "+elements);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return elements;
    }
    public void getUrl(String url){
        try{
            driver.get(url);
            System.out.println("Successfully get url: "+url);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public WebElement click(By locator){
        if (elements == null){
            try{
                element  = findElement(locator);
                element.click();
                System.out.println("Successfully perform click at locator: "+element);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return element;
    }
    public Actions clickAction(){
        if (elements == null){
            try{
                actions.click();
                System.out.println("Successfully perform click");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return actions;
    }
    public Actions clickActionWebElement(By locator){
        if (elements == null){
            try{
                element = findElement(locator);
                actions.click(element);
                System.out.println("Successfully perform click on element: "+element);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return actions;
    }
    public Actions contextClick(){
        if (elements == null){
            try{
                actions.contextClick();
                System.out.println("Successfully perform right click");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return actions;
    }
    public Actions clickAndHold(){
        try{
            actions.clickAndHold();
            System.out.println("Successfully perform click and hold");
        }catch (Exception e){
            e.printStackTrace();
        }
        return actions;
    }
    public Actions doubleClick(){
        try{
            actions.doubleClick();
            System.out.println("Successfully perform double click");
        }catch (Exception e){
            e.printStackTrace();
        }
        return actions;
    }
    public Actions doubleClick(By locator){
        try{
            element = findElement(locator);
            actions.doubleClick(element);
            System.out.println("Successfully perform double click");
        }catch (Exception e){
            e.printStackTrace();
        }
        return actions;
    }
    public Actions dragAndDrop(By sourceLocator, By targetLocator){
        try{
            sourceElement = findElement(sourceLocator);
            targetElement = findElement(targetLocator);
            actions.dragAndDrop(sourceElement,targetElement);
            System.out.println("Successfully drag and drop from source"+sourceElement+" to "+"target "+targetElement);
        }catch (Exception e){
            e.printStackTrace();
        }
        return actions;
    }
    public Actions dragAndDropByAxis(By sourceLocator, int xAxis, int yAxis){
        try{
            sourceElement = findElement(sourceLocator);
            actions.dragAndDropBy(sourceElement,xAxis,yAxis);
            System.out.println("Successfully drag and drop from source "+sourceElement+" to "+xAxis+" and "+yAxis);
        }catch (Exception e){
            e.printStackTrace();
        }
        return actions;
    }
    public Actions moveToElement(By sourceLocator){
        try{
            sourceElement = findElement(sourceLocator);
            actions.moveToElement(sourceElement);
            System.out.println("Successfully moved to element: "+sourceElement);
        }catch (Exception e){
            e.printStackTrace();
        }
        return actions;
    }
    public Actions moveToElementByAxis(By sourceLocator, int xAxis, int yAxis){
        try{
            sourceElement = findElement(sourceLocator);
            actions.moveToElement(sourceElement,xAxis,yAxis);
            System.out.println("Successfully moved to element: "+sourceElement+" to "+xAxis+" and "+yAxis);
        }catch (Exception e){
            e.printStackTrace();
        }
        return actions;
    }
    public void perform(){
        try{
            actions.perform();
            System.out.println("Successfully perform action");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        SeleniumOperations obj = new SeleniumOperations(driver);
        String url = "http://www.tizag.com/htmlT/htmlcheckboxes.php";
        driver.get(url);
        obj.findElement(ObjectRepository.checkBox_1__xpath).click();
        try {
            driver.manage().timeouts().wait(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
