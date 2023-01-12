package mentorpractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class soru12_mouseActions extends TestBase{

    @Test
    public void test01(){
        //1Yeni bir class olusturalim: MouseActions1
        //2https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //3- Cizili alan uzerinde sag click yapalim
        Actions actions = new Actions(driver);
        WebElement kutu = driver.findElement(By.id("hot-spot"));
        actions.contextClick(kutu).perform();
        //4 Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String alert = driver.switchTo().alert().getText();
        Assert.assertEquals("You selected a context menu",alert);
        //5 Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        //6 Elemental Selenium linkine tiklayalim
        driver.findElement(By.linkText("Elemental Selenium")).click();
        //7 Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        driver.findElement(By.xpath("//*[.='Elemental Selenium']")).getText();
        Assert.assertEquals("Elemental Selenium",driver.findElement(By.xpath("//*[.='Elemental Selenium']")).getText());
    }

}
