package TestExercise1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.time.Duration;

public class JunitAssertions02 {
    @Test
    public void test01() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.automationexercise.com/");

        WebElement logoelementi = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logoelementi.isDisplayed());

        driver.findElement(By.xpath("//a[@href='/products']")).click();

        String expectedUrl = "https://www.automationexercise.com/products";
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());

        WebElement searchbar = driver.findElement(By.xpath("//input[@placeholder='Search Product']"));
        searchbar.sendKeys("tshirt");
        driver.findElement(By.xpath("//button[@id='submit_search']")).click();

        WebElement aramaYapildiElementi = driver.findElement(By.xpath("//h2[text()='Searched Products']"));

        Assert.assertTrue(aramaYapildiElementi.isDisplayed());
        driver.close();

    }
}
