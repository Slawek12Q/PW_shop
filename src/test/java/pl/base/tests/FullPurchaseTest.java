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
    private static final String productName = "Customizable Mug";

    @BeforeMethod
    public void setUp() {
        homePage = new HomePage(page);
        page.navigate(Properties.getProperty("app.url"));
        homePage.getTopNavigationSection().selectEnglishLanguage();
    }

    @Test
    public void shouldPurchaseSelectedProductTest() {
        SearchResultPage searchResultPage = homePage.getTopMenuAndSearchSection().searchForProducts(productName);
        ProductDetailsPage productDetailsPage = searchResultPage.getSearchResultSection().viewProductDetail(productName);
        productDetailsPage.getProductCustomizationSection().customizeProduct("bla bla bla");
        AddToCartConfirmationModalPage addToCartConfirmationModalPage = productDetailsPage.getAddToCartSection().addToCart();
        String confirmationLabel = addToCartConfirmationModalPage.getConfirmationLabel();
        ShoppingCardPage shoppingCardPage = addToCartConfirmationModalPage.proceedToCheckoutOnModal();
        assertThat(confirmationLabel).contains("Product successfully added to your shopping cart");

        SummaryPurchasePage summaryPurchasePage = shoppingCardPage.getSummarySection().proceedToCheckout();
        OrderConfirmationPage orderConfirmationPage = summaryPurchasePage.getPersonalInformationSection().fillPersonalInformationAndContinue().fillAddressAndContinue().chooseShippingMethodAndContinue().choosePaymentMethodAndContinue();
        String confirmationNote = orderConfirmationPage.getOrderConfirmationDetailsSection().getConfirmationNote();

        Assert.assertTrue(confirmationNote.contains("YOUR ORDER IS CONFIRMED"));
    }

    @Test
    public void shouldPurchaseSelectedProductTest_v2() {
        AddToCartConfirmationModalPage confirmationModalPage =
                homePage
                        .searchForProducts(productName)
                        .viewProductDetail(productName)
                        .customizeProduct("bla bla bla")
                        .addToCart();

        assertThat(confirmationModalPage.getConfirmationLabel()).contains("Product successfully added to your shopping cart");

        OrderConfirmationPage orderConfirmationPage =
                confirmationModalPage
                        .proceedToCheckoutOnModal()
                        .proceedToCheckout()
                        .fillAllDataAndGo();

        String confirmationNote = orderConfirmationPage.getOrderConfirmationDetailsSection().getConfirmationNote();

        Assert.assertTrue(confirmationNote.contains("YOUR ORDER IS CONFIRMED"));
    }
}
