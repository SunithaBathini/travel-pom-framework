package com.makemytrip;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
    WebDriver driver;
    By flightSection = By.xpath("//span[text()='Flights']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToFlights() throws InterruptedException {
        Thread.sleep(3000);
        // Close login popup if visible
        Actions act = new Actions(driver);
        act.moveByOffset(10, 10).click().build().perform();
        try {
            driver.findElement(flightSection).click();
        } catch (Exception e) {
            System.out.println("Flights tab already active.");
        }
    }
}
