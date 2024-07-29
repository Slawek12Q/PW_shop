package pl.base.pages.modals;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import pl.base.pages.ShoppingCardPage;

import static org.example.utils.PageUtils.waitForLoadState;

public class AddToCartConfirmationModalPage {

    Page page;
    private Locator confirmationLabel;
    private Locator proceedToCheckoutButton;
    public AddToCartConfirmationModalPage(Page page) {
        waitForLoadState(page);
        this.page = page;
        this.confirmationLabel = page.locator("#myModalLabel");
        this.proceedToCheckoutButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Proceed to checkout"));
    }

    public String getConfirmationLabel() {
        return confirmationLabel.innerText();
    }

    public ShoppingCardPage proceedToCheckout() {
        proceedToCheckoutButton.click();
        return new ShoppingCardPage(page);
    }
}
