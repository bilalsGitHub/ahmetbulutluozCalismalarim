package TestExercise1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class JunitAssertions01 {
    @Test
    public void test01() {
        //Setup kısmı
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //logo var mı yok mu
        WebElement logoElementi = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logoElementi.isDisplayed());

        //sign up button'una tıkla
        WebElement loginButtonu = driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
        loginButtonu.click();

        //login to your account kısmı var mı yok mu kontrol et
        WebElement logintoyouraccounttext = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(logintoyouraccounttext.isDisplayed());

        //input a email and a password
        WebElement email = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        email.sendKeys("bilalhinis@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        password.sendKeys("12345");
        WebElement loginbutton = driver.findElement(By.xpath("//button[@data-qa='login-button']"));
        loginbutton.click();

        WebElement loggedinYazisi = driver.findElement(By.xpath("//a[text()=' Logged in as ']"));
        Assert.assertTrue(loggedinYazisi.isDisplayed());

        WebElement logoutbutton = driver.findElement(By.xpath("//i[@class='fa fa-home']"));
        logoutbutton.click();

        String expectedUrl = "https://www.automationexercise.com/login";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);


    }

}
