package TestNg01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class TestDeneme01 {
    @Test
    public void test01() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        String expectedUrl = "https://www.automationexercise.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);

        driver.findElement(By.xpath("//a[text()=' Products']"));
        WebElement allProductsYazisi = driver.findElement(By.xpath("//h2[text()='Category']"));
        Assert.assertTrue(allProductsYazisi.isDisplayed());

        List<WebElement> webElements = driver.findElements(By.xpath("//a[text()='View Product']"));
        Assert.assertTrue(webElements.size() > 0);

        //belli bir elemanı alırsak bir listeden o zaman ==> (//*[text()='View Product'])[3]
        driver.findElement(By.xpath("(//*[text()='View Product'])[1]")).click();
        WebElement productname = driver.findElement(By.xpath("(//h2)[3]"));
        Assert.assertTrue(productname.isDisplayed());

        WebElement webElement2 = driver.findElement(By.xpath("//*[text()='Category: Women > Tops']"));
        Assert.assertTrue(webElement2.isDisplayed());

        driver.close();
    }


}
