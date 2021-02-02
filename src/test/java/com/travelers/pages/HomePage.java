package com.travelers.pages;

import com.travelers.helpers.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    @FindBy(xpath = "//span[text() = 'Search by Hotel or City Name']")
    private WebElement searchSpan;

    @FindBy(xpath = "//div[@id='select2-drop']//input")
    private WebElement searchCityInput;

    @FindBy(xpath = "//div[@class='select2-result-label']")
    private WebElement searchCityDrop;

    @FindBy(xpath = "//div[@id='select2-drop']//ul//ul/li")
    private List<WebElement> cityList;

    @FindBy(name = "checkin")
    private WebElement checkInInput;

    @FindBy(name = "checkout")
    private WebElement checkOutInput;

    @FindBy(id = "travellersInput")
    private WebElement travellersInput;

    @FindBy(xpath = "//form[@name='fCustomHotelSearch']//button[@type='submit']")
    private WebElement searchButton;

    private WebDriver driver;
    private SeleniumHelper seleniumHelper;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.seleniumHelper = new SeleniumHelper(driver);
        PageFactory.initElements(driver, this);
    }

    public HomePage setHotelCity(String cityName) {
        seleniumHelper.waitForElementToBeDisplayed(searchSpan);
        searchSpan.click();
        searchCityInput.sendKeys(cityName);
        seleniumHelper.waitForElementToBeDisplayed(searchCityDrop);
        cityList.get(0).click();
        return this;
    }

    public HomePage setDateRange(String checkInDate, String checkOutDate) {
        checkInInput.sendKeys(checkInDate);
        checkOutInput.sendKeys(checkOutDate);
        return this;
    }

    public HomePage setTravellers(String travellers) {
        travellersInput.clear();
        travellersInput.sendKeys(travellers);
        return this;
    }

    public SearchResultsPage submitSearch() {
        searchButton.click();
        return new SearchResultsPage(driver);
    }
}
