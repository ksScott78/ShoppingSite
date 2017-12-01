import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;


public class HomePageTest {

    private String url = "http://automationpractice.com/index.php";
    private static WebDriver webDriver;
    private HomePage home;
    private Actions builder;

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
    public void testAddToCart() throws InterruptedException{
        builder.moveToElement(home.hoverItem1()).perform();
        home.item1Add.click();
        Thread.sleep(2000);
        Assert.assertEquals("1", home.getCartSize());
        builder.moveByOffset(-400,0).click().release().perform();
        Thread.sleep(2000);
        builder.moveToElement(home.hoverItem2()).perform();
        home.item2Add.click();
        Thread.sleep(2000);
        Assert.assertEquals("2", home.getCartSize());
        Thread.sleep(2000);
    }
}
