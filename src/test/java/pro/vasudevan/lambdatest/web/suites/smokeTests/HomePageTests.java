package pro.vasudevan.lambdatest.web.suites.smokeTests;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pro.vasudevan.PlaywrightTestFramework.config.IPlaywrightTestConfig;
import pro.vasudevan.lambdatest.web.base.TestBase;
import pro.vasudevan.lambdatest.web.models.HomePage;
import pro.vasudevan.lambdatest.web.testdata.HomePageData;

/*
Created By: Vasudevan Sampath

HomePageTests.java has home page specific test methods
 */
public class HomePageTests extends TestBase {

    private HomePage homePage;

    @BeforeClass(alwaysRun = true)
    public void initClass(ITestContext testContext) {
         homePage = new HomePage(IPlaywrightTestConfig.getPage());
    }

    @Test(priority = 0)
    public void verifyForThePresenceOfHomePageLinksTest() {
        Assert.assertEquals(homePage.getHomePageLinks(), HomePageData.links, "Home Page links not matching");
    }
}
