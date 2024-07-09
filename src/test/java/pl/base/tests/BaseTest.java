package pl.base.tests;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTest {

    private static Playwright playwright;
    protected static Browser browser;

    protected BrowserContext browserContext;

    protected Page page;

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setSlowMo(1000));
    }

    @BeforeEach
    void createBrowserContext() {
        browserContext = browser.newContext();

//        browserContext.tracing().start(new Tracing.StartOptions()
//                .setScreenshots(true)
//                .setSnapshots(true)
//                .setSources(true));

        page = browserContext.newPage();
        page.setViewportSize(1600, 900);
    }

    @AfterEach
    void closeBrowserContext(TestInfo testInfo) {
//        String traceName = "traces/trace_"
//                +testInfo.getDisplayName().replace("()", "")
//                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"))
//                +".zip";

//        browserContext.tracing().stop(new Tracing.StopOptions().setPath(Paths.get(traceName)));
        browserContext.close();
    }

    @AfterAll
    static void closeBrowser() {
        browser.close();
        playwright.close();
    }
}
