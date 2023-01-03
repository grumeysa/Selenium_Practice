package mentorpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


    public abstract class TestBase {
        //TestBase i abstract yapmamizin sebebi bu sinifin objesini olusturmak istemiyorum
        //TestBase testBase = new TestBase(); -> YAPILAMAZ
        //Amacim bu sinifi extend etmek ve icindeki hazir metodlari kullanmak
        //Driver objesini olustur. Driver ya public yada protected olmali.Sebebi child classlarda gorulebilir olması.
        protected static WebDriver driver;
        //setUp methodunu olusturalım
        @Before
        public void setUp(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        //tearDown methodu olusturalım
//        @After
//        public void tearDown() throws Exception {
//            driver.quit();
//        }

        //    MULTIPLE WINDOW:
//    1 parametre alir : Gecis Yapmak Istedigim sayfanin Title
//    ORNEK:
//    driver.get("https://the-internet.herokuapp.com/windows");
//    switchToWindow("New Window");
//    switchToWindow("The Internet")
        public static void switchToWindow(String targetTitle) {
            String origin = driver.getWindowHandle();
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
                if (driver.getTitle().equals(targetTitle)) {
                    return;
                }
            }
            driver.switchTo().window(origin);
        }

    }




