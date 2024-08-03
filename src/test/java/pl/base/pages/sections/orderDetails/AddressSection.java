package pl.base.pages.sections.orderDetails;

import com.github.javafaker.Faker;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.base.pages.BasePage;

public class AddressSection extends BasePage {

    private Locator address;
    private Locator zipCode;
    private Locator city;
    private Locator continueButton;
    private Faker faker = new Faker();
    public AddressSection(Page page) {
        super(page);
        this.address = page.locator("#field-address1");
        this.zipCode = page.locator("#field-postcode");
        this.city = page.locator("#field-city");
        this.continueButton = page.locator("#delivery-address .continue");
    }

    public void fillAddressAndContinue() {
        address.fill(faker.address().streetAddress());
        zipCode.fill(faker.address().zipCode());
        city.fill(faker.address().city());
        continueButton.click();
    }
}
