package mentorpractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class soru6_alert extends TestBase {
    @Test
    public void test01(){
        // go to url :http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");
        //"Alert with OK" butonuna tıklayın ve "click the button to display an  alert box:" 'a tıklayın
        WebElement alert =driver.findElement(By.xpath("//*[@onclick='alertbox()']"));
        alert.click();
        //Alert(I am an alert box!) konsolda yazdırın ve Alert'ü kabul edin.
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        //"Alert with OK & Cancel" butonuna tıklayın ve"click the button to display a confirm box " butonuna tıklayın
        driver.findElement(By.xpath("(//*[@data-toggle='tab'])[2]")).click();
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
        //Alert'ü kapatın
        driver.switchTo().alert().dismiss();
        //"Alert with Textbox" butonuna tıklayın ve "click the button to demonstrate the prompt box " butonuna tıklayın.
        driver.findElement(By.xpath("//*[@href='#Textbox']")).click();
        driver.findElement(By.xpath("//*[@class='btn btn-info']")).click();
        //Açılan alert e 'TechProEducation' (Lütfen İsminizi girin).
        driver.switchTo().alert().sendKeys("TechProEducation");
        //Gönderdiğiniz metnin isminizi içerdiğini doğrulayın
        driver.switchTo().alert().accept();
        WebElement alertCıktı = driver.findElement(By.xpath("//*[@id='demo1']"));
        String al = alertCıktı.getText();
        System.out.println(al);
        Assert.assertTrue(al.contains("TechProEducation"));

    }

}
