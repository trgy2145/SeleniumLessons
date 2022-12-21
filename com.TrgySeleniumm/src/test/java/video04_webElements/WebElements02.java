package video04_webElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebElements02 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1-https://www.facebook.com adresine git
        driver.get("https://www.facebook.com");

        //cookies cıkarsa kabul et butonuna bas
        driver.findElement(By.xpath("//button[@title='Temel ve isteğe bağlı çerezlere izin ver']")).click();
        // e-posta kutusuna rasgele bir mail girin.
        WebElement emailBox = driver.findElement(By.xpath("//input[@id='email']"));
        emailBox.sendKeys("trtrrty");
        //sifre kısmına rasgele bir sifre girin
        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='pass']"));
        passwordBox.sendKeys("2345333");
        // giriş yap butonuna basın
        driver.findElement(By.xpath("//button[@name='login']")).click();
        // uyarı olarak "Girdiğin şifre yanlış. Şifreni mi Unuttun mesajının cektiğini test edin
        WebElement resultText = driver.findElement(By.xpath("//div[@class='_9ay7']"));
        // System.out.println(resultText.getText());
        String expectedText = "Girdiğin şifre yanlış. Şifreni mi Unuttun?";
        if (expectedText.equals(resultText)) {
            System.out.println("Test sucsessfully passed..");

        } else {
            System.out.println("test is not sucsess..");
        }
        //sayfayı kapatın
        driver.close();

    }
}
