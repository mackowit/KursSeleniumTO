import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;

public class FileUploadTest extends BaseSeleniumTest {

    @Test
    public void fileUploadTest() {
        driver.get("file:///C:/Users/Samsung/Downloads/FileUpload.html");
        String path = new File("src/main/resources/test.png").getAbsolutePath();
        driver.findElement(By.id("myFile")).sendKeys(path);
    }
}
