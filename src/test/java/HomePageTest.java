import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePageTest {

    private String url = "http://automationpractice.com/index.php";
    private static WebDriver webDriver;
    private HomePage home;
    private LoginPage login;
    private SpreadSheetReader spreadSheetReader;

    @Before
    public void setUp() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.navigate().to(url);
        home = PageFactory.initElements(webDriver,HomePage.class);
    }

    @After
    public void destroy(){ webDriver.quit(); }

    @Test
    public void testImageReel(){
        String img1 = "sample-1";
        String img2 = "sample-2";
        String img3 = "sample-3";

        Assert.assertEquals(img1, home.getCurrentImg());

        home.nextImage();
        Assert.assertEquals(img2, home.getCurrentImg());

        home.nextImage();
        Assert.assertEquals(img3, home.getCurrentImg());

        home.nextImage();
        Assert.assertEquals(img1, home.getCurrentImg());


    }
}
