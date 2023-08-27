package video5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class TestCase3 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.ebay.de/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        WebElement searchBar = driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']"));
        searchBar.sendKeys("Baba neydirsen bunu test ile yaziram hahaha :D ");

        //kaç tane button oldugunu bulmak ıcın ==>
        List<WebElement> liste = driver.findElements(By.tagName("li"));
        System.out.println(liste.size());

        for (WebElement each : liste) {
            System.out.println(each.getText());
        }
    }
}
