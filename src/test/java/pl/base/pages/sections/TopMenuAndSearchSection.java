package pl.base.pages.sections;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.base.pages.SearchResultPage;

public class TopMenuAndSearchSection {

    private Page page;
    private Locator searchInput;

    public TopMenuAndSearchSection(Page page) {
        this.page = page;
        this.searchInput = page.locator("input[name=s]");
    }

    public SearchResultPage searchForProducts(String productName) {
        searchInput.fill(productName);
        searchInput.press("Enter");
        return new SearchResultPage(page);
    }
}
