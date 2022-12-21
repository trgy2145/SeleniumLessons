package video04_webElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class WebElement03 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1- https://bestbuy.com adresine gidin
        driver.get("https://bestbuy.com");
        // cookies cıkarsa kabul et
        //sayfada kac adet link bulunduğunu yazdırın..
        List<WebElement> linkList =  driver.findElements(By.tagName("button"));
        System.out.println(linkList.size());
        //icerikleri yazdır
        for (WebElement each: linkList) {
            System.out.println(each.getText());
        }
    }
}
