package pl.base.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.base.pages.sections.TopMenuAndSearchSection;
import pl.base.pages.sections.filter.FilterResultSection;

import java.util.List;

import static org.example.utils.PageUtils.waitForLoadState;

@Getter
public class ArtPage {

    private FilterResultSection filterResultSection;

    public ArtPage(Page page) {
        waitForLoadState(page);
        filterResultSection = new FilterResultSection(page);
    }


}
