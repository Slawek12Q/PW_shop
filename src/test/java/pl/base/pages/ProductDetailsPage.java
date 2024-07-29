package pl.base.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.base.pages.sections.productDetailsPage.AddToCartSection;
import pl.base.pages.sections.productDetailsPage.ProductCustomizationSection;

import static org.example.utils.PageUtils.waitForLoadState;

@Getter
public class ProductDetailsPage extends BasePage{

    private ProductCustomizationSection productCustomizationSection;
    private AddToCartSection addToCartSection;

    public ProductDetailsPage(Page page) {
        super(page);
        waitForLoadState(page);
        this.productCustomizationSection = new ProductCustomizationSection(page);
        this.addToCartSection = new AddToCartSection(page);
    }
}
