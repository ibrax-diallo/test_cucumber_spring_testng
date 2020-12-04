package com.ibrax;

import com.ibrax.controllers.AbonneController;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.testng.annotations.DataProvider;

/**
 * @author Ibrahima Diallo <ibrahima.diallo2@university-365.com>
 */

@CucumberOptions(features = "src/test/resources/features",
        plugin = {"pretty", "html:target/cucumber/abonne"},
        glue = "com.ibrax.bdd")
public class CucumberTest extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
