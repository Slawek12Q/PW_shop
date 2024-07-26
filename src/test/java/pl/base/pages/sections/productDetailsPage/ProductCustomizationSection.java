package pl.base.pages.sections.productDetailsPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ProductCustomizationSection {
    private Locator customMessageInput;
    private Locator saveCustomization;
    private Locator customizationLabel;

    public ProductCustomizationSection(Page page) {
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
