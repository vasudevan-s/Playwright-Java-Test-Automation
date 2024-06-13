package pro.vasudevan.lambdatest.web.base;

import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import pro.vasudevan.PlaywrightTestFramework.base.ElementBase;
import pro.vasudevan.PlaywrightTestFramework.config.IPlaywrightTestConfig;

/*
Created By: Vasudevan Sampath

TestBase.java has init methods to initialize Playwright and also initialize object repository
 */
public class TestBase extends ElementBase implements IPlaywrightTestConfig {

    @BeforeSuite(alwaysRun = true)
    public void initSuite() throws Exception {
        initObjectRepo();
    }

    @BeforeTest(alwaysRun = true)
    public void initTest(ITestContext testContext) {
        IPlaywrightTestConfig.init(testContext);
    }

    @AfterTest(alwaysRun = true)
    public void cleanup() {
        IPlaywrightTestConfig.tearDown();
    }
}
