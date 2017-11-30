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
    WebElement image1;
    @FindBy(css="#homeslider > li:nth-child(3) > a")
    WebElement image2;
    @FindBy(css="#homeslider > li:nth-child(4) > a")
    WebElement image3;

    @FindBy(css="#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a > span.ajax_cart_quantity.unvisible")
    WebElement cartLink;

    @FindBy(css="#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default")
    WebElement item1Add;

    @FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > span > span")
    WebElement continueShopping;
    @FindBy(css="#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.left-block > div > a.product_img_link > img")
    WebElement hoverItem1;

    @FindBy(css="#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a > span.ajax_cart_quantity")
    WebElement cartSize;

    public WebElement hoverItem1(){
        return hoverItem1;
    }


    public String getCartSize(){
        return cartSize.getAttribute("value");
    }

    public void moveToLogin(){
        signIn.click();
    }

    public void nextImage(){
        nextCarossel.click();
    }

    public String getImage1(){
        return image1.getAttribute("title");
    }

    public String getImage2(){
        return image2.getAttribute("title");
    }

    public String getImage3(){
        return image3.getAttribute("title");
    }
}
