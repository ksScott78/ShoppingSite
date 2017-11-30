import com.gargoylesoftware.htmlunit.Page;
import org.apache.poi.ss.SpreadsheetVersion;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class LoginTest {


    private String url = "http://automationpractice.com/index.php";
    private static WebDriver webDriver;
    private HomePage home;
    private LoginPage login;
    private SpreadSheetReader spreadSheetReader;

    @Before
    public void setUp() {
        spreadSheetReader = new SpreadSheetReader("shoppingSiteInfo.xlsx");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.navigate().to(url);
        home = PageFactory.initElements(webDriver,HomePage.class);
        login = PageFactory.initElements(webDriver,LoginPage.class);
    }

    @After
    public void destroy(){ webDriver.quit(); }

    @Test
    public void testMoveToLogin(){
        String expectedUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
        home.moveToLogin();
        Assert.assertEquals(expectedUrl,webDriver.getCurrentUrl());
    }

    @Test
    public void testLogin(){
        List<String> row = new ArrayList<String>();
        row = spreadSheetReader.readRow(1,"Sheet1");
        String email = row.get(0);
        String pass = row.get(1);
        String badEmail = row.get(2);
        String noEntries = row.get(3);
        String noPass = row.get(4);
        String noAccount = row.get(5);
        String emailFormat = row.get(6);

        home.moveToLogin();

        login.attemptLogin();
        Assert.assertEquals(noEntries, login.returnWarning());

        login.emailInput.sendKeys(badEmail);
        login.attemptLogin();
        Assert.assertEquals(emailFormat,login.returnWarning());

        login.emailInput.clear();
        login.emailInput.sendKeys(email);
        login.attemptLogin();
        Assert.assertEquals(noPass,login.returnWarning());

        login.passwordInput.sendKeys(pass);
        login.attemptLogin();
        Assert.assertEquals(noAccount,login.returnWarning());
    }
}
