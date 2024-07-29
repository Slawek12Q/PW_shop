package pl.base.pages.sections.shopping;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class SummarySection {

    private Locator proceedToCheckoutButton;

    public SummarySection(Page page) {
        this.proceedToCheckoutButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Proceed to checkout"));
    }

    public void proceedToCheckout() {
        proceedToCheckoutButton.click();
    }
}
