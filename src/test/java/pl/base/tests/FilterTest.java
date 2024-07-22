package pl.base.tests;

import org.example.utils.Properties;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.base.pages.ArtPage;
import pl.base.pages.HomePage;

import static org.assertj.core.api.Assertions.assertThat;

public class FilterTest extends BaseTest{

    private HomePage homePage;

    @BeforeMethod
    void setUp() {
        homePage = new HomePage(page);
        page.navigate(Properties.getProperty("app.url"));
        homePage.getTopNavigationSection().selectEnglishLanguage();
    }

    @Test
    public void shouldReturnProductWithPriceGreaterThan40Url() {
        ArtPage artPage = homePage.getTopMenuAndSearchSection().clickArtButton();

        assertThat(artPage.getProductsSection().getProducts().size()).isEqualTo(7);

        System.out.println(artPage.getProductsSection().getProductPricesDouble());

        page.navigate(page.url() + "&q=Price-zł-30-44");

        System.out.println(artPage.getProductsSection().getProductPricesDouble());

        assertThat(artPage.getProductsSection().getProductPricesDouble().stream().allMatch(s -> s > 30)).isTrue();
    }

    @Test
    public void shouldReturnProductWithPriceGreaterThan40Mouse() {
        ArtPage artPage = homePage.getTopMenuAndSearchSection().clickArtButton();

        assertThat(artPage.getProductsSection().getProducts().size()).isEqualTo(7);

        artPage.getFilterBySection().filterProductsByPriceMouse(40.0);

        assertThat(artPage.getProductsSection().getProductPricesDouble().stream().allMatch(s -> s > 40)).isTrue();
    }

    @Test
    public void shouldReturnProductWithPriceGreaterThan40KeyBoard() {
        ArtPage artPage = homePage.getTopMenuAndSearchSection().clickArtButton();

        assertThat(artPage.getProductsSection().getProducts().size()).isEqualTo(7);

        artPage.getFilterBySection().filterProductsByPriceKeyboard(40);

        assertThat(artPage.getProductsSection().getProductPricesDouble().stream().allMatch(s -> s > 40)).isTrue();
    }
}
