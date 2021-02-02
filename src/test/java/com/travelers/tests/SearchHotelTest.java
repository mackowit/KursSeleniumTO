package com.travelers.tests;

import com.travelers.helpers.ExcelHelper;
import com.travelers.helpers.TestListener;
import com.travelers.pages.HomePage;
import com.travelers.pages.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class SearchHotelTest extends BaseSeleniumTest {

    @Test(dataProvider = "getData")
    public void searchHotelTest(String city, String arrDate, String depDate, String hotel1, String price1, String hotel2, String price2, String hotel3, String price3)
    {
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.kurs-selenium.pl/demo/");
        HomePage homePage = new HomePage(driver);
        SearchResultsPage resultsPage = homePage.setHotelCity(city)
                .setDateRange(arrDate, depDate)
                .setTravellers("1 Adult 1 Child")
                .submitSearch();

        List<String> hotelNames = resultsPage.getSearchedHotelNames();
        Assert.assertEquals(hotel1, hotelNames.get(0));
        List<String> hotelPrices = resultsPage.getSearchedHotelPrices();
        Assert.assertEquals(price2, hotelPrices.get(1));
    }

    @DataProvider
    public Object[][] getData() {
        Object[][] data = null;
        try {
            data = ExcelHelper.readExcelFile(new File("src/main/resources/Dane.xlsx"));
        } catch (IOException e) {
        }
        return data;
    }
}
