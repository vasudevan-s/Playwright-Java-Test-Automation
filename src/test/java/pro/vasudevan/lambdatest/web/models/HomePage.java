package pro.vasudevan.lambdatest.web.models;

import com.microsoft.playwright.Page;
import pro.vasudevan.PlaywrightTestFramework.base.ElementBase;

import java.util.List;

/*
Created By: Vasudevan Sampath

HomePage.java has home page specific methods. Uses POM (Page object model) test design pattern
 */
public class HomePage extends ElementBase {

    private Page page;

    public HomePage(Page page) {
        this.page = page;
    }

    public List<String> getHomePageLinks() {
        return page.locator(getValue("menuTopLinks")).allInnerTexts();
    }
}
