package TestNg01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Konu1 {
    @Test(priority = 1)
    public void test01() {
        System.out.println("Test 01");
    }

    @Test(dependsOnMethods = "test01")
    public void test02() {
        System.out.println("Test 01");
    }

    @Test(priority = 3)
    public void test03() {
        System.out.println("Test 01");
    }

}
