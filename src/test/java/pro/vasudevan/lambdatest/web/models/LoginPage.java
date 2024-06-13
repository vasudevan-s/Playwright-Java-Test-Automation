package pro.vasudevan.lambdatest.web.models;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import pro.vasudevan.PlaywrightTestFramework.base.ElementBase;

/*
Created By: Vasudevan Sampath

LoginPage.java has login page specific methods. Uses POM (Page object model) test design pattern
 */
public class LoginPage extends ElementBase {

    private final Page page;

    public LoginPage(Page page) {
        this.page = page;
    }

    public void doLogin(String userid, String password) {
        page.locator(getValue("myAccountLink")).hover();
        page.locator(getValue("loginDropDown")).click();
        page.locator(getValue("userName")).fill(userid);
        page.locator(getValue("password")).fill(password);
        page.locator(getValue("loginButton")).click();
    }

    public boolean isLoginSuccessful() {
        page.waitForLoadState();
        return page.getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions().setName(getValue("editYourAccountInfo"))).isVisible();
    }
}
