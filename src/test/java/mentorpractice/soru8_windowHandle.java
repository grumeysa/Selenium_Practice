package mentorpractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Set;

public class soru8_windowHandle extends TestBase{
    //      url'ye git: http://demo.guru99.com/popup.php
    //       ilk pencereyi al
    //       "Click Here" butonuna tıklayın
    //       setteki tüm pencereyi al
    //       diğer pencereye geç
    //       e-posta kimliğini (somepne@gmail.com) girin ve bu girişe bir şey yazın
    //       Gönder düğmesine tıklayarak
    //       ""This access is valid only for 20 days."" ifadesinin beklendiği gibi olduğunu doğrula
    //       Tekrar ilk pencereye geç
    //       İlk pencerede olduğunu doğrula
    @Test
    public void test01(){
        driver.get("http://demo.guru99.com/popup.php");
        String ilkPencere = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[@target='_blank']")).click();
        Set<String> tumPencere = driver.getWindowHandles();
        for (String w : tumPencere){
            if (!w.equals(ilkPencere)){
                driver.switchTo().window(w);
                break;
            }
        }
       driver.findElement(By.xpath("//*[@type='text']")).sendKeys("somepne@gmail.com");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        String text = driver.findElement(By.xpath("//*[@style='color:#800080;font-size:22px;font-weight:700;']")).getText();
        Assert.assertEquals("This access is valid only for 20 days.",text);
        driver.switchTo().window(ilkPencere);
        String dogrulama = driver.getWindowHandle();
        Assert.assertEquals(ilkPencere,dogrulama);
    }
}
