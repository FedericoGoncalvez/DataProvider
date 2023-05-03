package scripts;

import dataProviders.ProductsData;
import io.qameta.allure.Attachment;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;
import static org.testng.AssertJUnit.assertEquals;

public class AddToCart {
    private static WebDriver driver;
    private static String site = "http://opencart.abstracta.us/";
    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test(dataProvider = "products", dataProviderClass = ProductsData.class)
    public void test(String product,String price, String currency) throws Exception {
        setUp();

        driver.get(site);
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        homePage.changeCurrencyForm();
        homePage.changeCurrency(currency);
        homePage.clickProduct(product);
        assertEquals(productPage.getPrice(), price);
        tearDown();
    }
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
    @Attachment(type = "image/png")
    @AfterMethod(alwaysRun = true)
    public byte[] takeScreenshot() throws Exception {
        byte[] image = new byte[0];
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            image = screenshot.getScreenshotAs(OutputType.BYTES);
            System.out.println("Successfully captured a screenshot");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }
        return image;
    }
}
