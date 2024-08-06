package pl.base.pages.sections.orderDetails;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.base.pages.BasePage;

@Getter
public class OrderConfirmationSection extends BasePage {

    private Locator confirmationNote;

    public OrderConfirmationSection(Page page) {
        super(page);
        this.confirmationNote = page.locator("#content-hook_order_confirmation h3");
    }

    public String getConfirmationNote() {
        return confirmationNote.innerText();
    }


}
