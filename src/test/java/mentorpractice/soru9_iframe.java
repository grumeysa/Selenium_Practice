package mentorpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class soru9_iframe extends TestBase{

    @Test
    public void test01() throws InterruptedException {
        //1)http://demo.guru99.com/test/guru99home/sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
        //2)sayfadaki iframe sayısını bulunuz.
        int iframeSayisi = driver.findElements(By.xpath("//iframe")).size();
        System.out.println("iframeSayisi = " + iframeSayisi);
        //3)ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement requiredFrame = driver.findElement(By.xpath("//iframe[contains(@src,'https://www.youtube.com/embed/RbSlW8jZFe8')]"));
        driver.switchTo().frame(requiredFrame);
        WebElement element = driver.findElement(By.xpath("//button[@aria-label='Oynat']"));
        element.click();
        Thread.sleep(10000);
        //4)ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().parentFrame();
        //5)ikinci iframe'deki (Jmeter Made Easy) linke(https://www.guru99.com/live-selenium-project.html) tıklayınız
        driver.switchTo().frame(7);
        driver.findElement(By.xpath("//*[@href='http://www.guru99.com/live-selenium-project.html']")).click();
    }
}
