package mentorpractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class soru15_keyboardActions extends TestBase {
    @Test
    public void test01(){
        //1 https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //2 “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions = new Actions(driver);
        WebElement kaynak = driver.findElement(By.id("draggable"));
        WebElement hedef = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(kaynak,hedef).perform();
        //3 “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement text = driver.findElement(By.xpath("//p[text()='Dropped!']"));
        Assert.assertTrue(text.getText().contains("Dropped!"));


    }

}
