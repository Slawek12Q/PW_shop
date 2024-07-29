package pl.base.pages.sections.shopping;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import pl.base.pages.BasePage;

public class SummarySection extends BasePage {

    private Locator proceedToCheckoutButton;

    public SummarySection(Page page) {
        super(page);
        this.proceedToCheckoutButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Proceed to checkout"));
    }

    public void proceedToCheckout() {
        proceedToCheckoutButton.click();
    }
}
