package dataProviders;

import org.testng.annotations.DataProvider;

public class ProductsData {
    @DataProvider(name = "products")
    public static Object[][] getProductsData() {
        return new Object[][]{
                {"MacBook", "$602.00", "USD"},
                {"iPhone", "$123.20", "USD"},
                {"MacBook", "472.33€", "EUR"},
                {"iPhone", "96.66€", "EUR"}
        };
    }
}