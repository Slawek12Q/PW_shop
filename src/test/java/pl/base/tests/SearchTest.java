package pl.base.tests;

import org.example.utils.Properties;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.base.pages.HomePage;
import pl.base.pages.SearchResultPage;

import static org.assertj.core.api.Assertions.assertThat;


public class SearchTest extends BaseTest{

    private HomePage homePage;

    @BeforeMethod
    void setUp() {
        homePage = new HomePage(page);
        page.navigate(Properties.getProperty("app.url"));
    }

    @Test(dataProvider = "testData")
    void shouldReturnProductsBySearchNameProduct(String productName, int productCount) {
        SearchResultPage searchResultPage = homePage.getTopMenuAndSearchSection().searchForProducts(productName);

        assertThat(searchResultPage.getSearchResultSection().getProducts().size()).isEqualTo(productCount);
    }

    @DataProvider(name = "testData")
    public Object [][] testDataProvider() {
        return new Object[][] {
                {"mug", 5},
                {"frame", 4},
                {"t-shirt", 1}
        };
    }
}
