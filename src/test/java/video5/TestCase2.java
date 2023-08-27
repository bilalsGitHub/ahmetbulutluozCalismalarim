package video5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase2 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.facebook.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//button[@title='Allow all cookies']")).click();

        WebElement postakutusu = driver.findElement(By.id("email"));
        postakutusu.sendKeys("asdasdasd");

        WebElement sifrekutusu = driver.findElement(By.id("pass"));
        sifrekutusu.sendKeys("asdasdasdasdasd1231212");

        WebElement girisbutton = driver.findElement(By.xpath("//button[@class='_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy']"));
        girisbutton.click();

        WebElement errorElement = driver.findElement(By.xpath("//div[@id='error_box']//div[contains(text(), 'Invalid username or password')]"));
        String errorMessage = errorElement.getText();
        System.out.println(errorMessage);

        String expextedSonucYazisi = "Invalid username or password";
        if (errorMessage.equals(expextedSonucYazisi)) {
            System.out.println("Girilemedi Test successful");
        } else {
            System.out.println("Girildi Test failed");
        }
        //"//div[@id='error_box']//div[contains(text(), 'Invalid username or password')]"
    }
}
