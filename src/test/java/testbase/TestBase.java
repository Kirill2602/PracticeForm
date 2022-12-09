package testbase;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;
import testdata.TestData;

public class TestBase extends TestData {
    @BeforeAll
    @Step("Подготовка")
    static void setup() {
        new ChromeOptions().addArguments("start-maximized");
        Configuration.baseUrl = "https://demoqa.com";
    }
}
