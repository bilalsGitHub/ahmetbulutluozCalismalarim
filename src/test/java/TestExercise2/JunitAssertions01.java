package TestExercise2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.KeyInput;

import java.security.Key;
import java.time.Duration;

public class JunitAssertions01 {

    @Test
    public void test01() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement signupElement = driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
        Actions actions = new Actions(driver);
        actions.click(signupElement).perform();

        WebElement nameKutusu = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        actions.click(nameKutusu).sendKeys("Ahmet").sendKeys(Keys.TAB).sendKeys("avba@gmail.com").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        WebElement genderkutusu = driver.findElement(By.xpath("//div[@id='uniform-id_gender1']"));
        actions.click(genderkutusu)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys("3")
                .sendKeys(Keys.TAB)
                .sendKeys("March")
                .sendKeys(Keys.TAB)
                .sendKeys("1990 ")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("Ahmet")
                .sendKeys(Keys.TAB)
                .sendKeys("Bulut")
                .perform();


    }

}
