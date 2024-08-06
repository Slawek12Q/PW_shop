package pl.base.pages.sections.confirmation;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.base.pages.BasePage;

public class OrderConfirmationDetailsSection extends BasePage {

    private Locator confirmationNote;

    public OrderConfirmationDetailsSection(Page page) {
        super(page);
        this.confirmationNote = page.locator("#content-hook_order_confirmation h3");
    }


    public String getConfirmationNote() {
        return confirmationNote.innerText();
    }
}
