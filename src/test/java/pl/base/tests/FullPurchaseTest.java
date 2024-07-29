package pl.base.tests;

import org.example.utils.Properties;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.base.pages.HomePage;
import pl.base.pages.ProductDetailsPage;
import pl.base.pages.SearchResultPage;
import pl.base.pages.sections.productDetailsPage.ProductCustomizationSection;

public class FullPurchaseTest extends BaseTest {

    HomePage homePage;

    @BeforeMethod
    public void setUp() {
        homePage = new HomePage(page);
        page.navigate(Properties.getProperty("app.url"));
        homePage.getTopNavigationSection().selectEnglishLanguage();
    }

    @Test
    public void shouldPurchaseSelectedProductTest() {
        SearchResultPage searchResultPage = homePage.getTopMenuAndSearchSection().searchForProducts("Customizable Mug");
        ProductDetailsPage productDetailsPage = searchResultPage.getSearchResultSection().viewProductDetail("Customizable Mug");
        productDetailsPage.getProductCustomizationSection().customizeProduct("bla bla bla");
        productDetailsPage.getAddToCartSection().addToCart();
        page.waitForTimeout(5000);
    }
}
