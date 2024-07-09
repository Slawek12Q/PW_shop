package pl.base.pages.sections.searchResultsSection;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;

import java.util.List;

@Getter
public class SearchResultSection {

    private List<Locator> products;

    public SearchResultSection(Page page) {
        this.products = page.locator(".js-product").all();
    }

    public int returnNumberOfProducts() {
        return products.size();
    }
}
