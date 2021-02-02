package com.travelers.pages;

import com.travelers.helpers.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage {

    @FindBy(xpath = "//table[@class='bgwhite table table-striped']")
    private WebElement searchedHotelsTable;

    private WebDriver driver;
    private SeleniumHelper seleniumHelper;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        this.seleniumHelper = new SeleniumHelper(driver);
        PageFactory.initElements(driver, this);
    }

    public List<String> getSearchedHotelNames() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,200)");
        seleniumHelper.waitForListOfWebElements(searchedHotelsTable.findElements(By.xpath(".//h4//b")));
        List<WebElement> searchedHotelsNames = searchedHotelsTable.findElements(By.xpath(".//h4//b"));
        List<String> hotelsList = new ArrayList<>();
        for(WebElement searchedName : searchedHotelsNames) {
            hotelsList.add(searchedName.getText());
            System.out.println(searchedName.getText());
        }
        return hotelsList;
    }

    public List<String> getSearchedHotelPrices() {
        List<String> hotelPrices = new ArrayList<>();
        List<WebElement> searchedHotelPrices = searchedHotelsTable.findElements(By.xpath("//div[contains(@class,'price_tab')]//b"));
        searchedHotelPrices.stream()
                .forEach(hotelPrice -> {
                    System.out.println(hotelPrice.getText());
                    hotelPrices.add(hotelPrice.getText());
                });
        return hotelPrices;
    }
}
