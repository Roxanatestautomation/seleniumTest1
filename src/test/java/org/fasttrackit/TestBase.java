package org.fasttrackit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class TestBase {

    protected WebDriver driver = null;

    @Before
    public void setup () {
        String browser = System.getProperty("browser", "chrome");
        driver = DriverFactory.getDriver(browser);
    }

    @After
    public void tearDown () {
    //    driver.quit();
    }
}
