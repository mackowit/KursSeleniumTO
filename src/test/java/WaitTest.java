import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class WaitTest extends BaseSeleniumTest {

    @Test
    public void WaitTest() {
        driver.get("C:\\Users\\Samsung\\Downloads\\Waits2.html");
        driver.findElement(By.tagName("button")).click();
        //waitForWebElement(By.tagName("p"));
        waitForWebElementCustom(By.tagName("p"));
        Assert.assertTrue(driver.findElement(By.tagName("p")).getText().equals("Dopiero się pojawiłem!"));
    }

    public void  waitForWebElement(By locator) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 10L);
        ((WebDriverWait) wait).pollingEvery(Duration.ofMillis(500));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForWebElementCustom(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10L);

        wait.until(driver1 -> {
               System.out.println("Sprawdzam czy element jest wyświetlony");
               if(driver1.findElement(By.tagName("p")).isDisplayed()) {
                   System.out.println("Element jest wyświetlony");
                   return true;
               } else {
                   System.out.println("Element nie jest wyświetlony");
                   return false;
               }
           });
    }
}
