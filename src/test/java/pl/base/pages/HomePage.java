package pl.base.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.base.pages.sections.TopMenuAndSearchSection;
import pl.base.pages.sections.TopNavigationSection;

@Getter
public class HomePage extends BasePage{

    private TopMenuAndSearchSection topMenuAndSearchSection;
    private TopNavigationSection topNavigationSection;

    public HomePage(Page page) {
        super(page);
        this.topMenuAndSearchSection = new TopMenuAndSearchSection(page);
        this.topNavigationSection = new TopNavigationSection(page);
    }
}
