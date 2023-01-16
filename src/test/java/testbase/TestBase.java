package testbase;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.ProjectConfig;
import config.WebConfig;
import helpers.Attach;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import testdata.TestData;

public class TestBase extends TestData {
    private static WebConfig config;
    private static ProjectConfig projectConfig;

    @Step("Подготовка")
    @BeforeAll
    static void setup() {
        config = ConfigFactory.create(WebConfig.class, System.getProperties());
        projectConfig = new ProjectConfig();
        projectConfig.webConfig(config);
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
