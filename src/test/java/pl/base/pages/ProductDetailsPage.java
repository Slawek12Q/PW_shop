package pl.base.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.base.pages.sections.productDetailsPage.ProductCustomizationSection;

@Getter
public class ProductDetailsPage {

    private ProductCustomizationSection productCustomizationSection;

    public ProductDetailsPage(Page page) {
        this.productCustomizationSection = new ProductCustomizationSection(page);
    }
}
