package pl.base.pages.sections.orderDetails;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.base.pages.BasePage;

public class ShippingMethodSection extends BasePage {

    private Locator continueButton;
    public ShippingMethodSection(Page page) {
        super(page);
        this.continueButton = page.locator("#checkout-delivery-step .continue ");
    }

    public PaymentSection chooseShippingMethodAndContinue() {
        continueButton.click();
        return new PaymentSection(page);
    }
}
