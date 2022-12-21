package video7_JUnitAssertionsOrnekler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_JunitAssertion {
    @Test
    public void test02(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1.Verify that home page is visible successfully
        driver.get("https://automationexercise.com");

        //verify that home page is visible successfuly
        WebElement isVisible =  driver.findElement(By.xpath("//h2[text()='Category']"));
        Assert.assertTrue(isVisible.isDisplayed());

        //Click on products button
        driver.findElement(By.xpath(" //a[text()=' Products']")).click();

        //Verify user is navigated to All Products page successfull
        String expectedUrl = "https://automationexercise.com/products";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

        //Enter product name in search input and click search button
        WebElement inputBoxProduct = driver.findElement(By.xpath("//input[@id='search_product']"));
        inputBoxProduct.sendKeys("H&M");
        driver.findElement(By.xpath("//button[@id='submit_search']")).click();

        // verify 'SEARCHED PRODUCTS' is visible
        WebElement isVisibleOfSeatchedProducts = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(isVisibleOfSeatchedProducts.isDisplayed());
        //close driver
        driver.close();
    }
}
