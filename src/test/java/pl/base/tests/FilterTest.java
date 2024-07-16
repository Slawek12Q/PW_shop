package pl.base.tests;

import org.example.utils.Properties;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;
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
    public void shouldSetPriceFilterAndReturnListOfProducts() {
        ArtPage artPage = homePage.getTopMenuAndSearchSection().pressArtButton();

        assertThat(artPage.getProducts().size()).isEqualTo(7);
    }
}
