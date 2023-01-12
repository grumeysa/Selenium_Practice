package mentorpractice;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class soru1_assertion {
    WebDriver driver;


    //11."Selected currency" butonunu secin
    //12."Calculate Costs" butonuna basin sonra "purchase" butonuna basin
    //13."Foreign currency cash was successfully purchased." yazisinin ciktigini kontrol edin.
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://zero.webappsecurity.com/");
        }
        @Test
    public void test01(){
            //1.http://zero.webappsecurity.com/ Adresine gidin
            //2.Sign in butonuna basin
            driver.findElement(By.id("signin_button")).click();
            //3.Login kutusuna "username"yazin
            driver.findElement(By.id("user_login")).sendKeys("username");
            //4.Password kutusuna "password"yazin
            driver.findElement(By.id("user_password")).sendKeys("password");
            // 5.Sign in tusuna basin
            driver.findElement(By.xpath("//*[@type='submit']")).click();
            driver.navigate().back();
            // 6.Pay Bills sayfasina gidin
            driver.findElement(By.xpath("//*[text()='Online Banking']")).click();
            driver.findElement(By.id("pay_bills_link")).click();
            //7."Purchase Foreign Currency" tusuna basin
            driver.findElement(By.xpath("//*[@href='#ui-tabs-3']")).click();
            //8."Currency" drop down menusunden Eurozone'u secin
             driver.findElement(By.id("pc_currency")).sendKeys("Eurozone");
            //9."amount" kutusuna bir sayi girin
            driver.findElement(By.xpath("(//input[@class='span1'])[2]")).sendKeys("100");
            //10."US Dollars" in secilmedigini test edin
            WebElement USDolars = driver.findElement(By.id("pc_inDollars_true"));
            Assert.assertFalse(USDolars.isSelected());
        }

    }


