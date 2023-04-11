import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementOperations {
    WebElement element;
    WebDriver driver ;
    public WebElement findElement(String locator){
        if (element == null){
            try{
                element = driver.findElement(By.id(locator));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return element;
    }
}
