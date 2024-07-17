package pl.base.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.base.pages.sections.filter.FilterBySection;
import pl.base.pages.sections.filter.ProductsSection;

import static org.example.utils.PageUtils.waitForLoadState;

@Getter
public class ArtPage {

    private ProductsSection productsSection;
    private FilterBySection filterBySection;

    public ArtPage(Page page) {
        waitForLoadState(page);
        productsSection = new ProductsSection(page);
        filterBySection = new FilterBySection(page);
    }
}
