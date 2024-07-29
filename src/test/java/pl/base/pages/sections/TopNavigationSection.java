package pl.base.pages.sections;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.base.pages.BasePage;

@Getter
public class TopNavigationSection extends BasePage {

    private Locator languageSelector;
    private Locator english;
    private Locator selectedLanguage;

    public TopNavigationSection(Page page) {
        super(page);
        this.languageSelector = page.locator(".language-selector");
        this.english = page.locator("a[data-iso-code=en]");
        this.selectedLanguage = page.locator("span[class=expand-more]");
    }

    public void selectEnglishLanguage() {
        if (!getSelectedLanguage().equalsIgnoreCase("english")) {
            languageSelector.click();
            english.click();
        }
    }

    private String getSelectedLanguage() {
        return selectedLanguage.innerText();
    }
}
