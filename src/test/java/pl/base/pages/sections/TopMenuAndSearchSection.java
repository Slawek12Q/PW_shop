package pl.base.pages.sections;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.base.pages.ArtPage;
import pl.base.pages.SearchResultPage;

public class TopMenuAndSearchSection {

    private Page page;
    private Locator searchInput;
    private Locator artButton;

    public TopMenuAndSearchSection(Page page) {
        this.page = page;
        this.searchInput = page.locator("input[name=s]");
        this.artButton = page.locator("#category-9");
    }

    public SearchResultPage searchForProducts(String productName) {
        searchInput.fill(productName);
        searchInput.press("Enter");
        return new SearchResultPage(page);
    }

    public ArtPage pressArtButton() {
        artButton.click();
        return new ArtPage(page);
    }
}
