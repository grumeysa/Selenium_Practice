package mentorpractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Set;

public class soru8_windowHandle extends TestBase{
    @Test
    public void test01(){
        //      url'ye git: http://demo.guru99.com/popup.php
        driver.get("http://demo.guru99.com/popup.php");
        //       ilk pencereyi al
        String ilkPencere = driver.getWindowHandle();
        //       "Click Here" butonuna tıklayın
        driver.findElement(By.xpath("//*[@target='_blank']")).click();
        //       setteki tüm pencereyi al
        Set<String> tumPencere = driver.getWindowHandles();
        //       diğer pencereye geç
        for (String w : tumPencere){
            if (!w.equals(ilkPencere)){
                driver.switchTo().window(w);
                break;
            }
        }
        //       e-posta kimliğini (somepne@gmail.com) girin ve bu girişe bir şey yazın
       driver.findElement(By.xpath("//*[@type='text']")).sendKeys("somepne@gmail.com");
        //       Gönder düğmesine tıklayarak
        //       ""This access is valid only for 20 days."" ifadesinin beklendiği gibi olduğunu doğrula
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        String text = driver.findElement(By.xpath("//*[@style='color:#800080;font-size:22px;font-weight:700;']")).getText();
        Assert.assertEquals("This access is valid only for 20 days.",text);
        //       Tekrar ilk pencereye geç
        driver.switchTo().window(ilkPencere);
        //       İlk pencerede olduğunu doğrula
        String dogrulama = driver.getWindowHandle();
        Assert.assertEquals(ilkPencere,dogrulama);
    }
}
