package com.prtt.cornerbot.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;
import org.springframework.stereotype.Service;

@Service
public class PlayWrightService {


    public String getJson(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch();
        BrowserContext context = browser.newContext(
                new Browser.NewContextOptions()
                        .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 OPR/99.0.0.0")
        );

        Page page = context.newPage();
        page.navigate("https://api.sportsanalytics.com.br/api/v1/fixtures-svc/fixtures/livescores?include=weatherReport,additionalInfo,league,stats,pressureStats,probabilities&api_key=OjS6sjgyOjtAfk82AzxZKxc78Z4y9FJn");
        page.waitForLoadState(LoadState.NETWORKIDLE);
        Locator preElement = page.locator("pre");
        String html = preElement.innerHTML();
        page.close();
        browser.close();
        return html;
    }
}
