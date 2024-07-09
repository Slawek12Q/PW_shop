package pl.base.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.base.pages.sections.TopMenuAndSearchSection;

@Getter
public class HomePage {

    private Page page;
    private TopMenuAndSearchSection topMenuAndSearchSection;

    public HomePage(Page page) {
        this.page = page;
        this.topMenuAndSearchSection = new TopMenuAndSearchSection(page);
    }
}
