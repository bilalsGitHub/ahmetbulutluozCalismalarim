package video2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethods {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com");

        System.out.println("Sayfanın başlığı" + driver.getTitle());

        System.out.println("url=>" + driver.getCurrentUrl());

        //driver.getPageSource();==>Kaynak kodları gösterir

        // driver.getWindowHandle();==>Unique hash kodunu gösterir
    }
}
