package pl.base.pages.sections.orderDetails;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.base.pages.BasePage;

public class PaymentSection extends BasePage {

    private Locator paymentMethod;
    private Locator termsOfService;
    private Locator placeOrderButton;
    public PaymentSection(Page page) {
        super(page);
        this.paymentMethod = page.locator("#payment-option-1");
        this.termsOfService = page.locator("input[id='conditions_to_approve[terms-and-conditions]']");
        this.placeOrderButton = page.locator("#checkout-payment-step #payment-confirmation button");
    }

    public OrderConfirmationSection choosePaymentMethodAndContinue() {
        paymentMethod.check();
        termsOfService.check();
        placeOrderButton.click();

        return new OrderConfirmationSection(page);
    }
}
