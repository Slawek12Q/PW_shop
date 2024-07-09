package pl.base.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import lombok.Getter;
import org.example.utils.PageUtils;
import pl.base.pages.sections.searchResultsSection.SearchResultSection;

import static org.example.utils.PageUtils.*;

@Getter
public class SearchResultPage {

    private SearchResultSection searchResultSection;

    public SearchResultPage(Page page) {
        waitForLoadState(page);
        this.searchResultSection = new SearchResultSection(page);
    }
}
