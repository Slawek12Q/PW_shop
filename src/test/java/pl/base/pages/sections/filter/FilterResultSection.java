package pl.base.pages.sections.filter;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;

import java.util.List;

@Getter
public class FilterResultSection {

    private List<Locator> products;

    public FilterResultSection(Page page) {
        this.products = page.locator(".thumbnail-top").all();
    }
}
