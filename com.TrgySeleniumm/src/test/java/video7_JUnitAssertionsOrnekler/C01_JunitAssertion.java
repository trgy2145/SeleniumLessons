package video7_JUnitAssertionsOrnekler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_JunitAssertion {
    @Test
    public void test01(){
        // 1- launcher browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. navigate to url "https://automationexercise.com"

        driver.get("https://automationexercise.com");
        //3.verify that home page is visible successfully
        WebElement logoElement = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logoElement.isDisplayed());  // logo görünp görünmediğini kontrol eder..

        //4. click signup or login
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        //verify 'Login to your account' is visible
        // //h2[text()='Login to your account'] atribute yoksa text alıyorsan böyle ara

        WebElement verifyLoginVisible = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(verifyLoginVisible.isDisplayed());

        //6.Enter correct email  address abd password
        WebElement emailInput = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        emailInput.sendKeys("mansaay3434@gmail.com");
        WebElement passwordInput = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        passwordInput.sendKeys("54321");
        //7.Click login button
        driver.findElement(By.xpath("//button[text()='Login']")).click();

        //8.verify that "Logged in as username " is visible
        WebElement loggedIsVisible = driver.findElement(By.xpath(" //a[text()=' Logged in as ']"));
        // System.out.println(loggedIsVisible.getText());
        Assert.assertTrue(loggedIsVisible.isDisplayed());

        //9. Click Logout button
        driver.findElement(By.xpath(" //a[text()=' Logout']")).click();

        //10.Verify that user is navigated to login page
        String expectedUrl = "https://automationexercise.com/login";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);



        //11.Close driver
        driver.close();
    }
}
