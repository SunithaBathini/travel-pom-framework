package com.makemytrip;

import org.openqa.selenium.*;
import java.util.*;

public class SearchResultsPage {
    WebDriver driver;
    By prices = By.xpath("//div[contains(@class,'priceSection')]//p");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void printCheapestFlights() throws InterruptedException {
        Thread.sleep(8000);
        List<WebElement> priceElements = driver.findElements(prices);
        List<Integer> priceList = new ArrayList<>();

        for (WebElement price : priceElements) {
            String p = price.getText().replaceAll("[^0-9]", "");
            if (!p.isEmpty()) priceList.add(Integer.parseInt(p));
        }

        if (priceList.size() >= 2) {
            Collections.sort(priceList);
            System.out.println("Cheapest flight: ₹" + priceList.get(0));
            System.out.println("Second cheapest flight: ₹" + priceList.get(1));
        } else {
            System.out.println("Not enough flights found!");
        }
    }
}
