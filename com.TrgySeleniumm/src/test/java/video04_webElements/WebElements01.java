package video04_webElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebElements01 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =  new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- https:www.amazon.com sayfasına gidin
        driver.get("https:www.amazon.com");
        //2- arama cubuguna Nutella yazdırın.
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox")); // locate ettik.
        searchBox.sendKeys("Nutella");
        //3- nutella yazdıktan sonra enter a basıp arama işlemi yapın..
        searchBox.submit();
        //4-bulunan sonuc sayısını getirin..
        WebElement resultElement = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(resultElement.getText());
        driver.close();
    }
}
