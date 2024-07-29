package pl.base.pages.sections.productDetailsPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.base.pages.BasePage;

public class ProductCustomizationSection extends BasePage {
    private Locator customMessageInput;
    private Locator saveCustomization;
    private Locator customizationLabel;

    public ProductCustomizationSection(Page page) {
        super(page);
        this.customMessageInput = page.locator("#field-textField1");
        this.saveCustomization = page.locator("//button[@name='submitCustomizedData']");
        this.customizationLabel = page.locator(".customization-message");
    }

    public ProductCustomizationSection customizeProduct(String text) {
        customMessageInput.fill(text);
        saveCustomization.click();
        return this;
    }

    public String getCustomizationLabel() {
        return customizationLabel.innerText();
    }
}
