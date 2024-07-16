package pl.base.tests;

import org.example.utils.Properties;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.base.pages.ArtPage;
import pl.base.pages.HomePage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.utils.PageUtils.waitForLoadState;

public class FilterTest extends BaseTest{

    private HomePage homePage;

    @BeforeMethod
    void setUp() {
        homePage = new HomePage(page);
        page.navigate(Properties.getProperty("app.url"));
        homePage.getTopNavigationSection().selectEnglishLanguage();
    }

    @Test
    public void shouldReturnProductWithPriceGreaterThan40() {
        ArtPage artPage = homePage.getTopMenuAndSearchSection().clickArtButton();


        assertThat(artPage.getFilterResultSection().getProducts().size()).isEqualTo(7);

        page.navigate(page.url() + "&q=Price-zł-31-44");
        waitForLoadState(page);

        assertThat(artPage.getFilterResultSection().getProducts().size()).isEqualTo(4);
    }
}
