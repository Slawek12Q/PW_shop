package pl.base.tests;

import org.assertj.core.api.Assertions;
import org.example.utils.Properties;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.base.pages.*;
import pl.base.pages.modals.AddToCartConfirmationModalPage;

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
        AddToCartConfirmationModalPage addToCartConfirmationModalPage = productDetailsPage.getAddToCartSection().addToCart();
        String confirmationLabel = addToCartConfirmationModalPage.getConfirmationLabel();
        ShoppingCardPage shoppingCardPage = addToCartConfirmationModalPage.proceedToCheckout();
        Assertions.assertThat(confirmationLabel).contains("Product successfully added to your shopping cart");
        SummaryPurchasePage summaryPurchasePage = shoppingCardPage.getSummarySection().proceedToCheckout();
        summaryPurchasePage.getPersonalInformationSection().fillPersonalInformationAndContinue().fillAddressAndContinue().chooseShippingMethodAndContinue().choosePaymentMethodAndContinue();
        page.waitForTimeout(20000);
    }
}
