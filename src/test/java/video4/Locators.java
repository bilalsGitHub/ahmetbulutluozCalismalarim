package video4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //8 tane locator vardır

        //id olabilir
        WebElement elementbyid = driver.findElement(By.id("twotabsearchtextbox"));
        WebElement elementbyname = driver.findElement(By.name("twotabsearchtextbox"));
        WebElement elementbyclassname = driver.findElement(By.className("twotabsearchtextbox"));


        //Link üzerinden de bulunabilir
        WebElement aramakutusu = driver.findElement(By.linkText("click here"));

        //Yazının bir kısmını kullanarak da bulabiliriz
        WebElement aramakutusu2 = driver.findElement(By.partialLinkText("here"));


        // en guclu locator olarak xpath kullanılır
        //tagName[@attributelsmi='attributeValue']

        WebElement aramakutusu3 = driver.findElement(By.xpath("//input[@type='text']"));

        //css selector
        WebElement aramaKutusu4 = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        WebElement aramaKutusu5 = driver.findElement(By.cssSelector(".nav-input"));
        WebElement firstName = driver.findElement(By.cssSelector("input[name='first_name']"));
        //driver.findElement(By.cssSelector("input#firstname"));
        //driver.findElement(By.cssSelector("#firstname"));
        //driver.findElement(By.cssSelector(".myForm"));
        //driver.findElement(By.cssSelector("input.myForm"));

    }

}

