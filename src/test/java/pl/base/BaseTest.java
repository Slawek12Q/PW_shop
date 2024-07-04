package pl.base;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    private static Playwright pw;
    protected static Browser browser;

    protected BrowserContext browserContext;

    protected Page page;

    @BeforeAll
    static void launchBrowser() {
        pw = Playwright.create();
        browser = pw.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setSlowMo(1000));
    }

    @BeforeEach
    void createBrowserContext() {
        browserContext = browser.newContext();
        page = browserContext.newPage();
        page.setViewportSize(1920, 1080);
    }

    @AfterEach
    void closeBrowserContext() {
        browserContext.close();
    }

    @AfterAll
    static void closeBrowser() {
        browser.close();
        pw.close();
    }
}
