package pl.base.tests;

import com.microsoft.playwright.*;
import org.example.factory.BrowserFactory;
import org.example.utils.Properties;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTest {

    private static Playwright playwright;
    private Browser browser;

    private BrowserFactory browserFactory;

    protected BrowserContext browserContext;

    protected Page page;

    @BeforeClass
    void launchBrowser() {

        browserFactory = new BrowserFactory();
        browser = browserFactory.getBrowser();
    }

    @BeforeMethod
    void createBrowserContext() {
        browserContext = browser.newContext();

        if (isTracingEnable()) {
            browserContext.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(true));
        }

        page = browserContext.newPage();
        page.setViewportSize(1600, 900);
    }

    @AfterMethod
    void closeBrowserContext(ITestResult testInfo) {

        if (isTracingEnable()) {
            String traceName = "traces/trace_"
                    + testInfo.getMethod().getMethodName()
                    + LocalDateTime.now().format(DateTimeFormatter.ofPattern(Properties.getProperty("tracing.date.format")))
                    + ".zip";

            browserContext.tracing().stop(new Tracing.StopOptions().setPath(Paths.get(traceName)));
        }

        browserContext.close();
    }

    @AfterClass
    void closeBrowser() {
        browser.close();
        browserFactory.getPlaywright().close();
    }

    boolean isTracingEnable() {
        return Boolean.parseBoolean(Properties.getProperty("tracing.enable"));
    }
}
