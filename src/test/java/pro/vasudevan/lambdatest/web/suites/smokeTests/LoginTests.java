package pro.vasudevan.lambdatest.web.suites.smokeTests;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pro.vasudevan.PlaywrightTestFramework.config.IPlaywrightTestConfig;
import pro.vasudevan.lambdatest.web.base.TestBase;
import pro.vasudevan.lambdatest.web.models.LoginPage;

/*
Created By: Vasudevan Sampath

LoginTests.java has login page specific test methods
 */
public class LoginTests extends TestBase {

    private LoginPage loginPage = null;
    private String loginId, password;

    @BeforeClass(alwaysRun = true)
    public void initClass(ITestContext testContext) {
        loginPage = new LoginPage(IPlaywrightTestConfig.getPage());
        loginId = testContext.getCurrentXmlTest().getLocalParameters().get("loginId");
        password = testContext.getCurrentXmlTest().getLocalParameters().get("password");
    }

    @Test(alwaysRun = true, priority = 1)
    public void verifyValidLoginTest() {
        loginPage.doLogin(loginId, password);
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login failed with User Id: " + loginId + " and Password: " + password);
    }
}
