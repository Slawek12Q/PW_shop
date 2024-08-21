package pl.base.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.base.pages.sections.TopMenuAndSearchSection;
import pl.base.pages.sections.TopNavigationSection;

@Getter
public class BasePage {

    protected Page page;

    protected TopMenuAndSearchSection topMenuAndSearchSection;
    protected TopNavigationSection topNavigationSection;

    public BasePage(Page page) {
        this.page = page;
        this.topMenuAndSearchSection = new TopMenuAndSearchSection(page);
        this.topNavigationSection = new TopNavigationSection(page);
    }

    public SearchResultPage searchForProducts(String productName) {
        return topMenuAndSearchSection.searchForProducts(productName);
    }

    public void selectEnglishLanguage() {
        topNavigationSection.selectEnglishLanguage();
    }
}
