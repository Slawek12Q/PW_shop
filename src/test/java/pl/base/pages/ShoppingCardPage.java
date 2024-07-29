package pl.base.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.base.pages.sections.shopping.SummarySection;

import static org.example.utils.PageUtils.waitForLoadState;

@Getter
public class ShoppingCardPage {

    private SummarySection summarySection;

    public ShoppingCardPage(Page page) {
        waitForLoadState(page);
        this.summarySection = new SummarySection(page);
    }
}
