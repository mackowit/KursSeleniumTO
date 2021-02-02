import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DoubleClickTest extends BaseSeleniumTest {

    @Test
    public void doubleClickTest(){
        SeleniumHelper seleniumHelper = new SeleniumHelper(driver);
        driver.get("file:///C:/Users/Samsung/Downloads/DoubleClick.html");
        WebElement button = driver.findElement(By.id("bottom"));
        Actions actions = new Actions(driver);
        actions.moveToElement(button).doubleClick().perform();
        seleniumHelper.takeScreenshot();
        Assert.assertTrue(driver.getWindowHandles().size() > 1);
    }
}
