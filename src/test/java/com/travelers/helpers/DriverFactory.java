package com.travelers.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;

import java.io.File;

public class DriverFactory {

    private static WebDriver driverInstance;

    public static WebDriver getDriver(DriverType driverType) throws NoSuchDriverException{
    if(driverInstance == null) {
        driverInstance = getSpecificDriver(driverType);
        driverInstance.manage().window().maximize();
    }
        return driverInstance;
    }

    private static WebDriver getSpecificDriver(DriverType driverType) throws NoSuchDriverException{

        switch(driverType) {
            case IE:
                File ieExe = new File("src//main//executables//drivers//IEDriverServer.exe");
                InternetExplorerDriverService ieService = new InternetExplorerDriverService.Builder()
                        .usingDriverExecutable(ieExe)
                        .usingAnyFreePort().build();
                driverInstance = new InternetExplorerDriver(ieService);
                break;

            case CHROME:
                File chromeExe = new File("src//main//executables//drivers//chromedriver.exe");
                ChromeDriverService chromeService = new ChromeDriverService.Builder()
                        .usingDriverExecutable(chromeExe)
                        .usingAnyFreePort().build();
                driverInstance = new ChromeDriver(chromeService);
                break;

            case FIREFOX:
                File ffExe = new File("src//main//executables//drivers//geckodriver.exe");
                GeckoDriverService ffService = new GeckoDriverService.Builder()
                        .usingDriverExecutable(ffExe)
                        .usingAnyFreePort().build();
                driverInstance = new FirefoxDriver(ffService);
                break;

            default:
                System.out.println("Niewłaściwy driver");
                throw new NoSuchDriverException();
        }
        return driverInstance;
    }

    public static void resetDriver() {
        driverInstance = null;
    }
}
