package pl.base.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.base.pages.sections.confirmation.OrderConfirmationDetailsSection;

import static org.example.utils.PageUtils.waitForLoadState;

@Getter
public class OrderConfirmationPage extends BasePage {

    private OrderConfirmationDetailsSection orderConfirmationDetailsSection;

    public OrderConfirmationPage(Page page) {
        super(page);
        waitForLoadState(page);
        this.orderConfirmationDetailsSection = new OrderConfirmationDetailsSection(page);
    }
}
