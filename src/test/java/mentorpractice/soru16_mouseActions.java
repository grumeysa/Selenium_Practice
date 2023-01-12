package mentorpractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class soru16_mouseActions extends TestBase{
    @Test
    public void test01(){
        //1 https://www.amazon.com/ adresine gidelim
        driver.get("https://www.amazon.com/");
        //2 Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirelim
        WebElement liste = driver.findElement(By.xpath("//*[@class='nav-line-2 ']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(liste).perform();
        //3 “Create a list” butonuna basalim
        driver.findElement(By.xpath("(//span[@class='nav-text'])[1]")).click();
        //4 Acilan sayfada “Your Lists” yazisi oldugunu test edelim
        WebElement text = driver.findElement(By.xpath("//*[@role='heading']"));
        Assert.assertTrue(text.getText().contains("Your Lists"));
    }

}
