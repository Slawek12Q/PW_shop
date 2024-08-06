package pl.base.pages.sections.orderDetails;

import com.github.javafaker.Faker;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.example.dto.PersonalInformationDTO;
import pl.base.pages.BasePage;

public class PersonalInformationSection extends BasePage {

    private Locator socialTitle;
    private Locator firstName;
    private Locator lastName;
    private Locator email;
    private Locator termsAndConditions;
    private Locator customerDataPrivacy;
    private Locator continueButton;
    private Faker faker = new Faker();
    public PersonalInformationSection(Page page) {
        super(page);
        this.socialTitle = page.locator("#field-id_gender-2");
        this.firstName = page.locator("#field-firstname");
        this.lastName = page.locator("#field-lastname");
        this.email = page.locator("#checkout-guest-form #field-email");
        this.termsAndConditions = page.locator("input[name='psgdpr']");
        this.customerDataPrivacy = page.locator("input[name='customer_privacy']");
        this.continueButton = page.locator("#checkout-personal-information-step #checkout-guest-form .continue");
    }

    public AddressSection fillPersonalInformationAndContinue() {
        if(!socialTitle.isChecked()) {
            socialTitle.check();
        }
        PersonalInformationDTO personalInformationDTO = createPersonalInformationDTO();

        firstName.fill(personalInformationDTO.getFirstName());
        lastName.fill(personalInformationDTO.getLastName());
        email.fill(personalInformationDTO.getEmail());
        termsAndConditions.check();
        customerDataPrivacy.check();
        continueButton.click();

        return new AddressSection(page);
    }

    private PersonalInformationDTO createPersonalInformationDTO() {
        return PersonalInformationDTO.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .build();
    }
}
