package pl.base.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.base.pages.sections.orderDetails.AddressSection;
import pl.base.pages.sections.orderDetails.PersonalInformationSection;

import static org.example.utils.PageUtils.waitForLoadState;

@Getter
public class SummaryPurchasePage extends BasePage {

    private PersonalInformationSection personalInformationSection;
    private AddressSection addressSection;

    public SummaryPurchasePage(Page page) {
        super(page);
        waitForLoadState(page);
        this.personalInformationSection = new PersonalInformationSection(page);
        this.addressSection = new AddressSection(page);
    }
}
