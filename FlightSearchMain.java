package com.makemytrip;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;

public class FlightSearchMain extends BaseTest {

    public static void main(String[] args) throws InterruptedException {
        FlightSearchMain test = new FlightSearchMain();
        test.setup();

        HomePage home = new HomePage(test.driver);
        FlightsPage flights = new FlightsPage(test.driver);
        SearchResultsPage results = new SearchResultsPage(test.driver);

        home.goToFlights();
        flights.enterSource("Mumbai");
        flights.enterDestination("Delhi");
        flights.selectNextMonthDate(10);
        flights.clickSearch();
        results.printCheapestFlights();

        // Open new tab -> Google
        test.driver.switchTo().newWindow(WindowType.TAB);
        test.driver.get("https://www.google.com");
        test.driver.findElement(By.name("q")).sendKeys("Best time to visit Delhi" + Keys.ENTER);

        Thread.sleep(4000);
        test.tearDown();
    }
}
