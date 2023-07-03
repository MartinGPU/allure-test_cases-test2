package base;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    public static void beforeAll() {
        Configuration.browserVersion = System.getProperty("version", "114.0");
        Configuration.browserSize = System.getProperty("size", "1366x900");
        Configuration.browser = System.getProperty("browser", "firefox");
    }
}
