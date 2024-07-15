package pl.base.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.base.pages.sections.searchResultsSection.SearchResultSection;

import static org.example.utils.PageUtils.waitForLoadState;

@Getter
public class SearchResultPage {

    private SearchResultSection searchResultSection;

    public SearchResultPage(Page page) {
        waitForLoadState(page);
        this.searchResultSection = new SearchResultSection(page);
    }
}
