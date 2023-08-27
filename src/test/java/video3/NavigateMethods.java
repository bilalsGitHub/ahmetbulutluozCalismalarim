package video3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateMethods {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com");

        driver.navigate().to("https://www.google.com");

        driver.navigate().to("https://www.youtube.com");

        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

        //driver.close();==>Tabı veya window acıksa onu kapatır

        //driver.quit()==>hepsini kapatır

    }
}
