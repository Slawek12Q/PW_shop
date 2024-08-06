package pl.base.tests;

import org.example.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.base.pages.*;
import pl.base.pages.modals.AddToCartConfirmationModalPage;

import static org.assertj.core.api.Assertions.assertThat;

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
        assertThat(confirmationLabel).contains("Product successfully added to your shopping cart");
        SummaryPurchasePage summaryPurchasePage = shoppingCardPage.getSummarySection().proceedToCheckout();
        OrderConfirmationPage orderConfirmationPage = summaryPurchasePage.getPersonalInformationSection().fillPersonalInformationAndContinue().fillAddressAndContinue().chooseShippingMethodAndContinue().choosePaymentMethodAndContinue();
        String confirmationNote = orderConfirmationPage.getOrderConfirmationDetailsSection().getConfirmationNote();
        Assert.assertTrue(confirmationNote.contains("YOUR ORDER IS CONFIRMED"));
    }
}
