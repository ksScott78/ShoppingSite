import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import com.google.common.base.Function;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import static java.util.concurrent.TimeUnit.SECONDS;

public class HomePageTest {

    private String url = "http://automationpractice.com/index.php";
    private static WebDriver webDriver;
    private HomePage home;
    private Actions builder;




   private void continueToShop(){
       Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver).withTimeout(30,SECONDS).pollingEvery(5, SECONDS).ignoring(NoSuchElementException.class);

       WebElement continueShopping = wait.until(new Function<WebDriver, WebElement>(){
           public WebElement apply(WebDriver webDriver){
               return webDriver.findElement(By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > span"));
           }
       });
       continueShopping.click();
   }


    private void moveAndClick(WebElement target){
        builder.moveToElement(target).click().release().perform();
    }


    @Before
    public void setUp() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.navigate().to(url);
        home = PageFactory.initElements(webDriver,HomePage.class);
        builder = new Actions(webDriver);
    }

    @After
    public void destroy(){ webDriver.quit(); }

    @Test
    public void testImageReel(){
        String img1 = "sample-1";
        String img2 = "sample-2";
        String img3 = "sample-3";

        Assert.assertEquals(img1, home.getImage1());

        home.nextImage();
        Assert.assertEquals(img2, home.getImage2());

        home.nextImage();
        Assert.assertEquals(img3, home.getImage3());

        home.nextImage();
        Assert.assertEquals(img1, home.getImage1());
    }



    @Test
    public void testAddToCart(){
        builder.moveToElement(home.hoverItem1()).perform();
        home.item1Add.click();
        moveAndClick(home.continueShopping);
        Assert.assertEquals("1", home.getCartSize());
    }
}
