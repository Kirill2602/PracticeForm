package testBase;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {
    @BeforeAll
    static void setup() {
        new ChromeOptions().addArguments("start-maximized");
        Configuration.baseUrl = "https://demoqa.com";
    }
}
