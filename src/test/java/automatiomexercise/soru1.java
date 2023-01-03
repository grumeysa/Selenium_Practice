package automatiomexercise;

import mentorpractice.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class soru1 extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement anasayfa = driver.findElement(By.xpath("//*[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(anasayfa.isDisplayed());
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@href='/login']")).click();
        //5. Verify 'New User Signup!' is visible
        WebElement signUp = driver.findElement(By.xpath("(//h2)[3]"));
        Assert.assertTrue(signUp.isDisplayed());
        //6. Enter name and email address
        //7. Click 'Signup' button
        driver.findElement(By.xpath("//*[@name='name']")).sendKeys("asd", Keys.TAB,"asd@hotmail.com",Keys.TAB,Keys.ENTER);
        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement gorunum = driver.findElement(By.xpath("(//b)[1]"));
        Assert.assertTrue(gorunum.isDisplayed());
        //9. Fill details: Title, Name, Email, Password, Date of birth
        WebElement bilgiler = driver.findElement(By.xpath("(//*[@name='title'])[2]"));
        bilgiler.click();
        Thread.sleep(5000);
        bilgiler.sendKeys(Keys.TAB,"asde",Keys.TAB,"asde@hotmail.com",Keys.TAB,"1234",Keys.TAB,"01",Keys.TAB, "January",Keys.TAB,"2000");
        //10. Select checkbox 'Sign up for our newsletter!'
        //11. Select checkbox 'Receive special offers from our partners!'
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        //13. Click 'Create Account button'
        //14. Verify that 'ACCOUNT CREATED!' is visible
        //15. Click 'Continue' button
        //16. Verify that 'Logged in as username' is visible
        //17. Click 'Delete Account' button
        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
    }


}
