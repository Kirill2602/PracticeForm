package testbase;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import testdata.TestData;

public class TestBase extends TestData {
    @Step("Подготовка")
    @BeforeAll
    static void setup() {
        Configuration.browserSize = System.getProperty("browserSize");
        System.out.println(System.getProperty("browserSize"));
        Configuration.baseUrl = System.getProperty("baseUrl","https://demoqa.com");
        System.out.println(System.getProperty("baseUrl"));
        Configuration.browserVersion = System.getProperty("browserVersion");
        System.out.println(System.getProperty("browserVersion"));
        Configuration.browser = System.getProperty("browser");
        System.out.println(System.getProperty("browser"));
        Configuration.remote = System.getProperty("remoteUrl", "https://user1:1234@selenoid.autotests.cloud") + "/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @Step("Добавить логгер")
    @BeforeEach
    void addLogger() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @Step("Добавить вложения")
    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
