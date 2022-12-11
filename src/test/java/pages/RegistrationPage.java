package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultModal;
import pages.components.UploadFileComponent;

import java.util.Date;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final String TITLE_TEXT = "Student Registration Form";
    CalendarComponent calendarComponent = new CalendarComponent();
    UploadFileComponent uploadFileComponent = new UploadFileComponent();
    RegistrationResultModal registrationResultModal = new RegistrationResultModal();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            phoneNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            uploadFileInput = $("#uploadPicture"),
            addressTextArea = $("#currentAddress"),
            stateList = $("#state"),
            cityList = $("#city"),
            submitFormButton = $("#submit");

    @Step("Открыть страницу регистрации и проверить текст заголовка")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("Заполнить поле FirstName значением {value}")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    @Step("Заполнить поле LastName значением {value}")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    @Step("Заполнить поле UserEmail значением {value}")
    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    @Step("Выбрать пол {value}")
    public RegistrationPage setGender(String value) {
        $(byText(value)).click();
        return this;
    }

    @Step("Заполнить поле UserNumber значением {value}")
    public RegistrationPage setPhone(String value) {
        phoneNumberInput.setValue(value);
        return this;
    }

    @Step("Заполнить поле день рождения {birthday}")
    public RegistrationPage setDate(Date birthday) {
        dateOfBirthInput.click();
        calendarComponent.setDate(birthday);
        return this;
    }

    @Step("Заполнить поле Subject значением {value}")
    public RegistrationPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    @Step("Выбрать хобби {value}")
    public RegistrationPage setHobby(String value) {
        $x("//label[contains(text(), '" + value + "')]").click();
        return this;
    }

    @Step("Загрузить файл {value}")
    public RegistrationPage myUploadFile(String value) {
        uploadFileComponent.myUploadFile(uploadFileInput, value);
        return this;
    }

    @Step("Заполнить поле Address значением {value}")
    public RegistrationPage setAddress(String value) {
        addressTextArea.setValue(value);
        return this;
    }

    @Step("Выбрать штат {value}")
    public RegistrationPage setState(String value) {
        stateList.click();
        stateList.$(byText(value)).click();
        return this;
    }

    @Step("Выбрать город {value}")
    public RegistrationPage setCity(String value) {
        cityList.click();
        cityList.$(byText(value)).click();
        return this;
    }

    @Step("Нажать отправка формы")
    public void submitForm() {
        submitFormButton.submit();
    }

    @Step("Проверить, что открыто модальное окно с заголовком {value} с таблицей результатов")
    public RegistrationPage verifyModalAppear(String value) {
        registrationResultModal.verifyModalAppear(value);
        return this;
    }

    @Step("Проверить соответствие данных в таблице введеным в поле {key} значение {value}")
    public RegistrationPage verifyResults(String key, String value) {
        registrationResultModal.verifyResults(key, value);
        return this;
    }

    public String getNameFromFilePath(String value) {
        String[] parts = value.split("/");
        return parts[parts.length - 1];
    }
}
