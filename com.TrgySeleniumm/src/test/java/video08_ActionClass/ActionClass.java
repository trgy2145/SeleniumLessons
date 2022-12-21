package video08_ActionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionClass {
    @Test
    public void test(){
        //1. Launch browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Click on 'Signup / Login' button
        WebElement signupElementi=driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
        Actions actions=new Actions(driver);
        actions.click(signupElementi).perform();
        //4. Enter name and email address
        //5. Click 'Signup' button
        WebElement nameKutusu= driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        actions.click(nameKutusu)
                .sendKeys("trgy")
                .sendKeys(Keys.TAB)
                .sendKeys("mans13@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();
        //6. Fill details: Title, Name, Email, Password, Date of birth
        //7. Select checkbox 'Sign up for our newsletter!'
        //8. Select checkbox 'Receive special offers from our partners!'
        //9. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        //10. Click 'Create Account button'
        WebElement titleRadiButton= driver.findElement(By.xpath("//div[@id='uniform-id_gender1']"));
        actions.click(titleRadiButton)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys("3")
                .sendKeys(Keys.TAB)
                .sendKeys("March")
                .sendKeys(Keys.TAB)
                .sendKeys("1990")
                .sendKeys(Keys.TAB)
                .click(driver.findElement(By.xpath("//input[@id='newsletter']")))
                .sendKeys(Keys.TAB)
                .click(driver.findElement(By.xpath("//input[@id='optin']")))
                .sendKeys(Keys.TAB)
                .sendKeys("trg")
                .sendKeys(Keys.TAB)
                .sendKeys("prc")
                .sendKeys(Keys.TAB)
                .sendKeys("kendim")
                .sendKeys(Keys.TAB)
                .sendKeys("ulu cadde no 95")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("Canada")
                .sendKeys(Keys.TAB)
                .sendKeys("Dallas")
                .sendKeys(Keys.TAB)
                .sendKeys("manisa")
                .sendKeys(Keys.TAB)
                .sendKeys("05100")
                .sendKeys(Keys.TAB)
                .sendKeys("5551254568")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();






        //11. Verify that 'ACCOUNT CREATED!' is visible

        String expectedText = "ACCOUNT CREATED!";
        String actualText = driver.findElement(By.xpath("//h2[@data-qa='account-created']")).getText();
        Assert.assertEquals(expectedText,actualText);

        driver.close();


    }
}
