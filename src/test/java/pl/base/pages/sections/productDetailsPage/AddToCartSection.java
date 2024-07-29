package pl.base.pages.sections.productDetailsPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.base.pages.modals.AddToCartConfirmationModalPage;

public class AddToCartSection {

    private Locator addToCartButton;
    Page page;

    public AddToCartSection(Page page) {
        this.page = page;
        this.addToCartButton = page.locator(".add-to-cart");
    }

    public AddToCartConfirmationModalPage addToCart() {
        addToCartButton.click();
        return new AddToCartConfirmationModalPage(page);
    }
}
