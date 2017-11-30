import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SelectorDocument;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(css="#header > div.nav > div > div > nav > div.header_user_info > a")
    WebElement signIn;

    @FindBy(css="#homepage-slider > div > div.bx-controls.bx-has-controls-direction > div > a.bx-next")
    WebElement nextCarossel;

    @FindBy(css="#homeslider > li:nth-child(2) > a")
    WebElement imageReel;

    public void moveToLogin(){
        signIn.click();
    }

    public void nextImage(){
        nextCarossel.click();
    }

    public String getCurrentImg(){
        return imageReel.getAttribute("title");
    }
}
