package testBase;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;
import testVariables.Variables;

public class TestBase extends Variables {
    @BeforeAll
    static void setup() {
        new ChromeOptions().addArguments("start-maximized");
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
    }
}
