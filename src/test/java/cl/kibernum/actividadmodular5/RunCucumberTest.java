package cl.kibernum.actividadmodular5;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.FILTER_TAGS_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "cl.kibernum.actividadmodular5.steps")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty,summary,json:target/cucumber-reports.json")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@formulario") // 🔹 solo ejecuta los escenarios con @formulario


public class RunCucumberTest {
    
}
