package mentorpractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class soru10_windowHandle extends TestBase{
    @Test
    public void test01(){
        //https://demoqa.com/ url'ine gidin.
        driver.get("https://demoqa.com/");
        //Alerts, Frame & Windows Butonuna click yap
        driver.findElement(By.xpath("(//*[@class='card mt-4 top-card'])[3]")).click();
        //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
        WebElement text =driver.findElement(By.xpath("//*[@class='col-12 mt-4 col-md-6']"));
        Assert.assertTrue(text.isDisplayed());
        //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
        driver.findElement(By.xpath("//span[text()='Browser Windows']")).click();
        //New Tab butonunun görünür olduğunu doğrula
        WebElement newTab = driver.findElement(By.xpath("//*[@id='tabButton']"));
        Assert.assertTrue(newTab.isDisplayed());
        //New Tab butonuna click yap
        driver.findElement(By.xpath("//*[@id='tabButton']")).click();
        //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
        String window1 = driver.getWindowHandle();
        Set<String> pencereler = driver.getWindowHandles();
        for (String w: pencereler){
            if (!w.equals(window1)){
                driver.switchTo().window(w);
            }
        }
        WebElement text2 = driver.findElement(By.xpath("//*[@id='sampleHeading']"));
        Assert.assertTrue(text2.isDisplayed());
        //İlk Tab'a geri dön
        driver.switchTo().window(window1);
        //New Tab butonunun görünür olduğunu doğrula
        WebElement newTab2 = driver.findElement(By.xpath("//*[@id='tabButton']"));
        Assert.assertTrue(newTab2.isDisplayed());
    }

}
