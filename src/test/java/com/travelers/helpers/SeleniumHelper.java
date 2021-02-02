package com.travelers.helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

public class SeleniumHelper {
    private WebDriver driver;

    public SeleniumHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementToBeDisplayed(By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(15))        //sumarycznie czekaj 15 sekund
                .pollingEvery(Duration.ofSeconds(1)) //sprawdzaj co sekundę
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementToBeDisplayed(WebElement element) {   //taka sama nazwa ale inny argument - przeciązenie metody
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(15))        //sumarycznie czekaj 15 sekund
                .pollingEvery(Duration.ofSeconds(1)) //sprawdzaj co sekundę
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForListOfWebElements(List<WebElement> elementList) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(15))        //sumarycznie czekaj 15 sekund
                .pollingEvery(Duration.ofSeconds(1)) //sprawdzaj co sekundę
                .ignoring(NoSuchElementException.class);
        wait.until(driver1 ->
                elementList.size() > 0);
    }

    public static void takeScreenshot(WebDriver driver) {
        try {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File screenshotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
            File destinationFile = new File("src/main/resources/" + LocalTime.now().getNano() + ".png");
            Files.copy(screenshotFile.toPath(), destinationFile.toPath());
        } catch(IOException e) {
            System.out.println("Nie znaleziono pliku");
        }
        }

}
