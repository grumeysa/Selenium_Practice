package automatiomexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class soru3 {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationexercise.com");
    }
    @Test
    public void test1(){
        WebElement anaSayfa = driver.findElement(By.xpath("//*[@lang='en']"));
        Assert.assertTrue(anaSayfa.isDisplayed());
        driver.findElement(By.xpath("//*[@href='/login']")).click();
        WebElement yazi = driver.findElement(By.xpath("//*[text()='Login to your account']"));
        String yazi1 = yazi.getText();
        Assert.assertEquals("Login to your account", yazi1);
        driver.findElement(By.xpath("//*[@type='email']")).sendKeys("ali@gmail.com", Keys.TAB,"12345",Keys.ENTER);
        WebElement sonucYazisi = driver.findElement(By.xpath("//*[text()='Your email or password is incorrect!']"));
//    String sonucYazisi1 = sonucYazisi.getText();
//    Assert.assertEquals("Your email or password is incorrect!",sonucYazisi1);
        Assert.assertTrue(sonucYazisi.isDisplayed());
    }
    @After
    public void tearDown(){
        driver.close();
    }

}
