package pl.base.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.base.pages.sections.summary.PersonalInformationSection;

import static org.example.utils.PageUtils.waitForLoadState;

@Getter
public class SummaryPurchasePage extends BasePage {

    private PersonalInformationSection personalInformationSection;

    public SummaryPurchasePage(Page page) {
        super(page);
        waitForLoadState(page);
        this.personalInformationSection = new PersonalInformationSection(page);
    }
}
