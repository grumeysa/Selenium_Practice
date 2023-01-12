package mentorpractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class soru14 extends TestBase{
    @Test
    public void test01(){
        //Go to https://www.amazon.com.tr/
        driver.get("https://www.amazon.com.tr/");
        //Search iPhone13 512
        driver.findElement(By.xpath("//*[@id='sp-cc-accept']")).click();
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("iPhone13 512", Keys.ENTER);
        //Check that the results are listed
        WebElement result = driver.findElement(By.xpath("//*[text()='iphone 13 512']"));
        Assert.assertTrue(result.isDisplayed());
        //Click iPhone13 at the top of the list
        driver.findElement(By.xpath("(//*[@class='a-size-base-plus a-color-base a-text-normal'])[1]")).click();
        //Log the following values for each size .Size information .Price .Color .Stock status
        //Isim - Renk - Stok - Boyut - Fiyat
    }
    //Go to https://www.amazon.com.tr/
    //Search iPhone13 512
    //Check that the results are listed
    //Click iPhone13 at the top of the list
    //Log the following values for each size .Size information .Price .Color .Stock status
    //Isim - Renk - Stok - Boyut - Fiyat
}
