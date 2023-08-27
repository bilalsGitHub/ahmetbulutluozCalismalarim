package TestCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class TestCase012 {
    //1. Launch browser
    @Test
    public void test01() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("https://www.automationexercise.com/");
        //3. Verify that home page is visible successfully
        SoftAssert softAssert = new SoftAssert();

        String expectedUrl = "https://www.automationexercise.com/";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        String actualURL = driver.getTitle();
        //3. Verify that home page is visible successfully
        softAssert.assertEquals(expectedUrl, actualURL, "Home page is visible");
        //5. Hover over first product and click 'Add to cart'
        WebElement webElement1 = driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart' and text()='Add to cart'])[1]"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        webElement1.click();
        //6. Click 'Continue Shopping' button

        WebElement continueShoppingElement = driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        continueShoppingElement.click();
        //7. Hover over second product and click 'Add to cart'
        WebElement webElement2 = driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart' and text()='Add to cart'])[5]"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        webElement2.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        continueShoppingElement.click();

        //8. Click 'View Cart' button

        //9. Verify both products are added to Cart
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        int bekleninenurunsayisi = 2;

        WebElement webElementWarenkorb = driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        webElementWarenkorb.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        List<WebElement> webElements = driver.findElements(By.xpath("//td[@class='cart_product']"));
        System.out.println(webElements.size());
        softAssert.assertEquals(bekleninenurunsayisi, webElements.size(), "2 olması gerkeiyor");

        driver.close();

        //10. Verify their prices, quantity and total price
    }
}