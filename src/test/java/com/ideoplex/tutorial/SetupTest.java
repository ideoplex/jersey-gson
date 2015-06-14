package com.ideoplex.tutorial;


import java.util.concurrent.TimeUnit;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class SetupTest {

    public void addUser(WebDriver driver, String email, String givenName, String surname)
    {
        WebDriverWait  block = new WebDriverWait(driver,10);
        WebElement    search  = block.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#users_filter input")));
        search.clear();
        search.sendKeys(email);

        List<WebElement> rows = driver.findElements(By.cssSelector("#users tbody tr"));
        for ( WebElement row : rows ) {
            WebElement colEmail = row.findElement(By.cssSelector("td"));
            System.out.println("Compare " + email + " to " + colEmail.getText() );
            if ( colEmail.getText().equals(email) ) {
                driver.navigate().refresh();
                return;
            }
        }
        driver.navigate().refresh();

        WebElement openModal  = driver.findElement(By.xpath("//button[contains(text(),'Add User')]"));
        openModal.click();

        WebElement     modal = block.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-user-modal")));
        WebElement input;
        input    = modal.findElement(By.id("add-user-email"));
        input.sendKeys(email);
        input    = modal.findElement(By.id("add-user-givenName"));
        input.sendKeys(givenName);
        input    = modal.findElement(By.id("add-user-surname"));
        input.sendKeys(surname);

        input    = driver.findElement(By.id("user-post"));
        input.click();

        block.until(ExpectedConditions.invisibilityOfElementLocated(By.id("add-user-modal")));
    }

    public void addUsers( WebDriver driver )
    {
        addUser(driver, "george@example.com",  "George",   "Washington");
        addUser(driver, "john@example.com",    "John",     "Adams");
        addUser(driver, "thomas@example.com",  "Thomas",   "Jefferson");
        addUser(driver, "james@example.com",   "James",    "Madison");
        addUser(driver, "james2@example.com",  "James",    "Monroe");
        addUser(driver, "john2@example.com",   "John Q",   "Adams");
        addUser(driver, "andrew@example.com",  "Andrew",   "Jackson");
        addUser(driver, "martin@example.com",  "Martin",   "Van Buren");
        addUser(driver, "william@example.com", "William",  "Harrison");
        addUser(driver, "john3@example.com",   "John",     "Tyler");
        addUser(driver, "james3@example.com",  "James",    "Polk");
        addUser(driver, "zachary@example.com", "Zachary",  "Taylor");
        addUser(driver, "millard@example.com", "Millard",  "Fillmore");
        addUser(driver, "abraham@example.com", "Abraham",  "Lincoln");
    }

    @Parameters({"browser","baseurl"})
    @Test
    public void userCreate( String browser, String baseurl )
        throws Exception
    {
        WebDriver driver = "chrome".equalsIgnoreCase(browser)
            ? new ChromeDriver()
            : new FirefoxDriver();
        driver.get(baseurl);

        addUsers(driver);

        Thread.sleep(10000);
        driver.quit();
    }

}
