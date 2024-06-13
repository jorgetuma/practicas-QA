package com.jorgetuma.practica_2;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.nio.file.Paths;

public class PlaywrightIT {
    private static Playwright playwright;
    private static Browser browser;
    protected Page page;
    private BrowserContext browserContext;

    @BeforeAll
    static void beforeAll() {
        playwright = Playwright.create();
        BrowserType browserType = playwright.chromium();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.headless = false;
        browser = browserType.launch(launchOptions);
    }

    @AfterAll
    static void afterAll() {
        browser.close();
        playwright.close();
    }

    @BeforeEach
    void beforeEach() {
        browserContext = browser.newContext();

        // Start tracing before creating / navigating a page.
      browserContext.tracing().start(new Tracing.StartOptions()
                      .setScreenshots(true)
                      .setSnapshots(true)
                      .setSources(true));

        page = browserContext.newPage();
    }

    @AfterEach
    void afterEach() {
        page.close();
       //  Stop tracing and export it into a zip archive.
        browserContext.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("trace.zip")));

        browserContext.close();
    }
}
