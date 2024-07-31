package pl.base.pages.sections.summary;

import com.github.javafaker.Faker;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.base.pages.BasePage;

public class PersonalInformationSection extends BasePage {

    private Locator socialTitle;
    private Locator firstName;
    private Locator lastName;
    private Locator email;
    private Locator termsAndConditions;
    private Locator customerDataPrivacy;
    Faker faker = new Faker();
    public PersonalInformationSection(Page page) {
        super(page);
        this.socialTitle = page.locator("#field-id_gender-2");
        this.firstName = page.locator("#field-firstname");
        this.lastName = page.locator("#field-lastname");
        this.email = page.locator("#field-email").first();
        this.termsAndConditions = page.locator("input[name='psgdpr']");
        this.customerDataPrivacy = page.locator("input[name='customer_privacy']");
    }

    public void fillForm() {
        if(!socialTitle.isChecked()) {
            socialTitle.check();
        }
        firstName.fill(faker.name().firstName());
        lastName.fill(faker.name().lastName());
        email.fill(faker.internet().emailAddress());
        termsAndConditions.check();
        customerDataPrivacy.check();
    }
}
