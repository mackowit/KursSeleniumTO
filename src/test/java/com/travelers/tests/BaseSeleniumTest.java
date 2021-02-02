package com.travelers.tests;

import com.travelers.helpers.DriverFactory;
import com.travelers.helpers.DriverType;
import com.travelers.helpers.NoSuchDriverException;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public abstract class BaseSeleniumTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() throws NoSuchDriverException {
        driver = DriverFactory.getDriver(DriverType.CHROME);
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
        DriverFactory.resetDriver();
    }
}
