package video3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ManageMethods {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com");

        driver.manage().window().getSize();//Pixel olarak 1920,1080 olarak gönderir
        driver.manage().window().getPosition();//Pixel olarak başlangıç noktalarını gönderir
        driver.manage().window().setPosition(new Point(10, 10));//Pixel olarak başlangıç noktalarını biz belirleriz


        driver.manage().window().setSize(new Dimension(900, 900));//Pixel olarak başlangıç noktalarını biz belirleriz
        System.out.println("size" + driver.manage().window().getSize());

        driver.manage().window().setSize(new Dimension(1000, 1000));
        System.out.println("size" + driver.manage().window().getSize());

        driver.manage().window().maximize();
        System.out.println("size" + driver.manage().window().getSize());//bir tık daha büyük alıyor ekstra 8 pixel ekliyor
        driver.manage().window().fullscreen();
        System.out.println("size" + driver.manage().window().getSize());

        //driver.manage().window().minimize();//Simge durumuna küçültür

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
}
