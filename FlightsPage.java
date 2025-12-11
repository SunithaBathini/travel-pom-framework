package com.makemytrip;

import org.openqa.selenium.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FlightsPage {
    WebDriver driver;
    By fromCity = By.id("fromCity");
    By toCity = By.id("toCity");
    By searchButton = By.xpath("//a[text()='Search']");

    public FlightsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterSource(String source) throws InterruptedException {
        driver.findElement(fromCity).click();
        WebElement srcInput = driver.findElement(By.xpath("//input[@placeholder='From']"));
        srcInput.sendKeys(source);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[contains(text(),'" + source + "')]")).click();
    }

    public void enterDestination(String dest) throws InterruptedException {
        driver.findElement(toCity).click();
        WebElement destInput = driver.findElement(By.xpath("//input[@placeholder='To']"));
        destInput.sendKeys(dest);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[contains(text(),'" + dest + "')]")).click();
    }

    public void selectNextMonthDate(int day) throws InterruptedException {
        Thread.sleep(2000);
        LocalDate nextMonth = LocalDate.now().plusMonths(1);
        String dateToSelect = nextMonth.withDayOfMonth(day)
                                       .format(DateTimeFormatter.ofPattern("EEE MMM dd yyyy"));
        try {
            driver.findElement(By.xpath("//div[@aria-label='" + dateToSelect + "']")).click();
        } catch (Exception e) {
            driver.findElement(By.xpath("//div[contains(@aria-label,'next month')]")).click();
            driver.findElement(By.xpath("//div[@aria-label='" + dateToSelect + "']")).click();
        }
    }

    public void clickSearch() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(searchButton).click();
    }
}
