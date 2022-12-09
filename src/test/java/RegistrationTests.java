import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import testbase.TestBase;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class RegistrationTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    SimpleDateFormat formatter = new SimpleDateFormat("dd MMMMM,yyyy", Locale.ENGLISH);


    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка заполнения формы регистрации")
    @Owner("Kirill")
    @Link(value = "Страница регистрации", url = "https://demoqa.com/automation-practice-form")
    void fillPracticeFormTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        registrationPage.openPage()
                .setFirstName(getFirstName())
                .setLastName(getLastName())
                .setEmail(getEmail())
                .setGender(getGender())
                .setPhone(getPhone())
                .setDate(getBirthDay())
                .setSubject(getSubject())
                .setHobby(getHobby())
                .myUploadFile(getFilePath())
                .setAddress(getAddress())
                .setState(getState())
                .setCity(getCity())
                .submitForm();

        registrationPage.verifyModalAppear(getModalTitle())
                .verifyResults("Student Name", getFirstName() + " " + getLastName())
                .verifyResults("Student Email", getEmail())
                .verifyResults("Gender", getGender())
                .verifyResults("Mobile", getPhone())
                .verifyResults("Date of Birth", formatter.format(getBirthDay()))
                .verifyResults("Subjects", getSubject())
                .verifyResults("Hobbies", getHobby())
                .verifyResults("Picture", registrationPage.getNameFromFilePath(getFilePath()))
                .verifyResults("Address", getAddress())
                .verifyResults("State and City", getState() + " " + getCity());
    }
}
