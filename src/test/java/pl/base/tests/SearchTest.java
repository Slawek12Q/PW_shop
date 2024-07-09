package pl.base.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.base.pages.HomePage;
import pl.base.pages.SearchResultPage;

class SearchTest extends BaseTest{

    private HomePage homePage;

    @BeforeEach
    void setUp() {
        homePage = new HomePage(page);
    }

    @Test
    void shouldReturnProductsBySearchNameMug() {
        page.navigate("https://skleptestera.pl/index.php");
        SearchResultPage searchResultPage = homePage.getTopMenuAndSearchSection().searchForProducts("mug");

        int numberOfProducts = searchResultPage.getSearchResultSection().returnNumberOfProducts();
        Assertions.assertEquals(5, numberOfProducts);
    }
}
