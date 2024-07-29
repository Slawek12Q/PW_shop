package pl.base.tests;

import org.example.utils.Properties;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.base.pages.HomePage;
import pl.base.pages.SearchResultPage;

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
        String customizationLabel = searchResultPage.getSearchResultSection().viewProductDetail("Customizable Mug").customizeProduct("Bla bla bla").getCustomizationLabel();

        page.waitForTimeout(5000);
        System.out.println(customizationLabel);
    }
}
