package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultModal;
import pages.components.UploadFileComponent;

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

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        $(byText(value)).click();
//        $x("//label[contains(text(),'" + value + "' )]").click();
        return this;
    }

    public RegistrationPage setPhone(String value) {
        phoneNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobby(String value) {
        $x("//label[contains(text(), '" + value + "')]").click();
        return this;
    }

    public RegistrationPage myUploadFile(String value) {
        uploadFileComponent.myUploadFile(uploadFileInput, value);
        return this;
    }

    public RegistrationPage setAddress(String value) {
        addressTextArea.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        stateList.click();
        stateList.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setCity(String value) {
        cityList.click();
        cityList.$(byText(value)).click();
        return this;
    }

    public void submitForm() {
        submitFormButton.submit();
    }

    public RegistrationPage verifyModalAppear(String value) {
        registrationResultModal.verifyModalAppear(value);
        return this;
    }

    public RegistrationPage verifyResults(String key, String value) {
        registrationResultModal.verifyResults(key, value);
        return this;
    }

    public String getNameFromFilePath(String value) {
        String[] parts = value.split("/");
        return parts[parts.length - 1];
    }
}
