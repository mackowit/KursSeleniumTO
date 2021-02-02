import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PageObjectPatternTest extends BaseSeleniumTest {
    @FindBy(name = "q")
    private WebElement searchInput;

    @FindBy(name = "q")
    private List<WebElement> searchInputs;

    @FindBys({
            @FindBy(tagName = "table"),
            @FindBy(className = "tableHeader")
    })
    private List<WebElement> foundBys;



    @Test
    public void googleSearchTest() {
        PageFactory.initElements(driver, this);
        driver.get("https://www.google.pl");
        searchInput.sendKeys("Selenium");
        searchInput.sendKeys(Keys.ENTER);
        Assert.assertEquals(driver.getTitle(), "Selenium - Szukaj w Google");
    }
}
