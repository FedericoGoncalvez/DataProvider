package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage{
    private static WebDriver driver;

    public ProductPage(WebDriver driver){
        ProductPage.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "li h2")
    private WebElement value;

    @FindBy(id = "button-cart")
    private static WebElement buttonCart;

    @FindBy(id = "cart-total")
    private static WebElement cart;
    @Step("Obteniendo precio del producto")
    public String getPrice(){
        return value.getText();
    }

    public String getValue(){
        return cart.getText();
    }

    public static ProductPage addToCart(){
        buttonCart.click();
        return null;
    }



}