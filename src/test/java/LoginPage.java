import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(css="#email")
    WebElement emailInput;

    @FindBy(css="#passwd")
    WebElement passwordInput;

    @FindBy(css="#SubmitLogin > span")
    WebElement attemptLoginClick;

    @FindBy(css="#center_column > div.alert.alert-danger > ol > li")
    WebElement loginWarning;

    public void attemptLogin(){
        attemptLoginClick.click();
    }

    public String returnWarning(){
        return loginWarning.getText();
    }


}
