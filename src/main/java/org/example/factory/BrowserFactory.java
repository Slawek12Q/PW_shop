package org.example.factory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import lombok.NoArgsConstructor;
import org.example.utils.Properties;

@NoArgsConstructor
public class BrowserFactory {
    private Browser browser;
    private Playwright playwright;

    public Playwright getPlaywright() {
        if (playwright == null) {
            playwright = Playwright.create();
        }
        return playwright;
    }

    public Browser getBrowser() {

        String browserName = Properties.getProperty("browser");

        playwright = getPlaywright();

        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions()
                .setHeadless(Boolean.parseBoolean(Properties.getProperty("browser.headless")))
                .setSlowMo(Double.parseDouble(Properties.getProperty("browser.slow.mo")));

        switch (browserName) {
            case "chromium" -> browser = playwright.chromium().launch(launchOptions);
            case "firefox" -> browser = playwright.firefox().launch(launchOptions);
            case "webkit" -> browser = playwright.webkit().launch(launchOptions);
            case "chrome" -> browser = playwright.chromium().launch(launchOptions.setChannel("chrome"));
            case "msedge" -> browser = playwright.chromium().launch(launchOptions.setChannel("msedge"));
            default -> throw new IllegalStateException("Unexpected value: " + browserName);
        }

        return browser;
    }
}
