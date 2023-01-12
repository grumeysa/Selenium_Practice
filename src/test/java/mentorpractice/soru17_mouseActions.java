package mentorpractice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class soru17_mouseActions extends TestBase{
    @Test
    public void test01(){
        //#url'ye gidin: http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        //  #Ülkeye göre başkentleri doldurun
        Actions actions = new Actions(driver);
        for (int i=1; i<8; i++){
            actions.dragAndDrop(driver.findElement(By.id("box"+i)), driver.findElement(By.id("box10"+i))).perform();
        }
    }

    }


