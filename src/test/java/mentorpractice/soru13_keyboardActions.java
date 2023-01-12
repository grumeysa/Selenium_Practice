package mentorpractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class soru13_keyboardActions extends TestBase{
    @Test
    public void test01(){
        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        //2."Login Portal" a kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //3."Login Portal" a tiklayin
        String window1 = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[.='Login Portal']")).click();
        //4.Diger window'a gecin
        Set<String> windows =driver.getWindowHandles();
        for (String w : windows){
            if (!w.equals(window1)){
                driver.switchTo().window(w);
            }
        }
        //5."username" ve "password" kutularina deger yazdirin
        //6."login" butonuna basin
        driver.findElement(By.id("text")).sendKeys("ali",Keys.TAB,"1234",Keys.ENTER);
        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String popup = driver.switchTo().alert().getText();
        Assert.assertEquals("validation failed",popup);
        //8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();
        //9.Ilk sayfaya geri donun
        driver.switchTo().window(window1);
        //10.Ilk sayfaya donuldugunu test edin
        String ılkSayfa = driver.getCurrentUrl();
        System.out.println(ılkSayfa);
        Assert.assertEquals("http://webdriveruniversity.com/",ılkSayfa);
    }

}
