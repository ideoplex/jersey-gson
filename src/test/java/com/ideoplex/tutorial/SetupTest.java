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

    @Parameters({"baseurl"})
    @Test
    public void userCreate( String baseurl )
        throws Exception
    {
        WebDriver driver = new ChromeDriver();
        driver.get(baseurl);

        WebDriverWait  block  = new WebDriverWait(driver,10);
        WebElement openModal  = block.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Add User')]")));
        openModal.click();

        block.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-user-modal")));
        WebElement input;
        input    = driver.findElement(By.id("add-user-email"));
        input.sendKeys("abe@example.com");
        input    = driver.findElement(By.id("add-user-givenName"));
        input.sendKeys("Abraham");
        input    = driver.findElement(By.id("add-user-surName"));
        input.sendKeys("Lincoln");

        input    = driver.findElement(By.id("user-post"));
        input.click();

        Thread.sleep(10000);
        driver.quit();
    }
}
