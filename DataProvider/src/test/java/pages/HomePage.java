package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

        private static WebDriver driver;

        public HomePage(WebDriver driver){
            HomePage.driver = driver;
            PageFactory.initElements(driver, this);
        }


        @FindBy(id = "form-currency")
        private WebElement currencyForm;

        @FindBy(name = "USD")
        private WebElement usdButton;

        @FindBy(name = "EUR")
        private WebElement eurButton;

        public ProductPage changeCurrencyForm(){
        currencyForm.click();
        return null;
        }

    public ProductPage changeCurrency(String currency) {
        switch (currency) {
            case "USD":
                usdButton.click();
                break;
            case "EUR":
                eurButton.click();
                break;
        }
        return null;
    }
    @Step("Haciendo click en el producto")
    public ProductPage clickProduct(String product){
        WebElement productLink = driver.findElement(By.linkText(product));
        productLink.click();
        return new ProductPage(driver);
    }

}

