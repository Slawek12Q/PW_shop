package pl.base.tests;

import com.microsoft.playwright.*;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    private static Playwright playwright;
    protected static Browser browser;

    protected BrowserContext browserContext;

    protected Page page;

    @BeforeClass
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setSlowMo(0));
    }

    @BeforeMethod
    void createBrowserContext() {
        browserContext = browser.newContext();

//        browserContext.tracing().start(new Tracing.StartOptions()
//                .setScreenshots(true)
//                .setSnapshots(true)
//                .setSources(true));

        page = browserContext.newPage();
        page.setViewportSize(1600, 900);
    }

    @AfterMethod
    void closeBrowserContext(ITestResult testInfo) {
//        String traceName = "traces/trace_"
//                +testInfo.getMethodName()
//                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"))
//                +".zip";

//        browserContext.tracing().stop(new Tracing.StopOptions().setPath(Paths.get(traceName)));
        browserContext.close();
    }

    @AfterClass
    static void closeBrowser() {
        browser.close();
        playwright.close();
    }
}
