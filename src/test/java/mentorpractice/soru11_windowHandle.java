package mentorpractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;

public class soru11_windowHandle extends TestBase{

    @Test
    public void test01(){
        //●Yeni bir class olusturun:WindowHandle
        //●Amazon anasayfa adresinegidin.
        driver.get("https://www.amazon.com/");
        //●Sayfa’nin window handle degerini String bir degiskene atayin
        //●Sayfa title’nin “Amazon” icerdigini testedin
        String window1 = driver.getWindowHandle();
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Amazon"));
        //●Yeni bir tab olusturup, acilan tab’da techproeducation.com adresinegidin
        //●Sayfa title’nin “TECHPROEDUCATION” icerdigini testedin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://techproeducation.com/tr");
        String window2= driver.getTitle();
        String expectedTitle2 = "TECHPROEDUCATION";
        Assert.assertFalse(window2.contains(expectedTitle2));
        //●Yeni bir window olusturup, acilan sayfada walmart.com adresinegidin
        //●Sayfa title’nin “Walmart” icerdigini testedin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com/");
        String window3 = driver.getTitle();
        Assert.assertTrue(window3.contains("Walmart"));
        driver.switchTo().window(window1);
        //●Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu testedin
        boolean gorunum = driver.getCurrentUrl().contains("https://www.amazon.com/");
        Assert.assertTrue(gorunum);

    }
}
