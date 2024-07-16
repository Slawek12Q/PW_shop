package pl.base.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.base.pages.sections.TopMenuAndSearchSection;

import java.util.List;

import static org.example.utils.PageUtils.waitForLoadState;

@Getter
public class ArtPage {

    private List<Locator> products;
    private TopMenuAndSearchSection topMenuAndSearchSection;

    public ArtPage(Page page) {
        waitForLoadState(page);
        this.products = page.locator(".thumbnail-top").all();
        this.topMenuAndSearchSection = new TopMenuAndSearchSection(page);
    }


}
