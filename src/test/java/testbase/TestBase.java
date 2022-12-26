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
        String browserSize = System.getProperty("browserSize");
        String baseUrl = System.getProperty("baseUrl", "https://demoqa.com");
        String browserVersion = System.getProperty("browserVersion");
        String browser = System.getProperty("browser");
        String remote = System.getProperty("remoteUrl", "https://user1:1234@selenoid.autotests.cloud") + "/wd/hub";

        Configuration.browserSize = System.getProperty("browserSize");
        System.out.println(browserSize);
        Configuration.baseUrl = System.getProperty("baseUrl", "https://demoqa.com");
        System.out.println(baseUrl);
        Configuration.browserVersion = System.getProperty("browserVersion");
        System.out.println(browserVersion);
        Configuration.browser = System.getProperty("browser");
        System.out.println(browser);
        Configuration.remote = System.getProperty("remoteUrl", "https://user1:1234@selenoid.autotests.cloud") + "/wd/hub";
        System.out.println(remote);

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
