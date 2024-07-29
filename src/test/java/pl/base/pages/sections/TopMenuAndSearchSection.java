package pl.base.pages.sections;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import pl.base.pages.ArtPage;
import pl.base.pages.BasePage;
import pl.base.pages.SearchResultPage;

public class TopMenuAndSearchSection extends BasePage {

    private Locator searchInput;
    private Locator artButton;

    public TopMenuAndSearchSection(Page page) {
        super(page);
        this.searchInput = page.locator("input[name=s]");
        this.artButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Art").setExact(true));
    }

    public SearchResultPage searchForProducts(String productName) {
        searchInput.fill(productName);
        searchInput.press("Enter");
        return new SearchResultPage(page);
    }

    public ArtPage clickArtButton() {
        artButton.click();
        return new ArtPage(page);
    }
}
