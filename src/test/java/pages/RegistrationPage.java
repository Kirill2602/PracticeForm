package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultModal;
import pages.components.UploadFileComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    UploadFileComponent uploadFileComponent = new UploadFileComponent();
    RegistrationResultModal registrationResultModal = new RegistrationResultModal();
    private SelenideElement
            firstNameInput = $x("//input[@id='firstName']"),
            lastNameInput = $x("//input[@id='lastName']"),
            emailInput = $x("//input[@id='userEmail']"),
            phoneNumberInput = $x("//input[@id='userNumber']"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectInput = $x("//div[@id='subjectsContainer']//input[@id='subjectsInput']"),
            uploadFileInput = $x("//input[@id='uploadPicture']"),
            addressTextArea = $x("//textarea[@id='currentAddress']"),
            stateList = $x("//div[@id='state']//div[@class=' css-tlfecz-indicatorContainer']"),
            cityList = $x("//div[@id='city']//div[@class=' css-tlfecz-indicatorContainer']"),
            submitFormButton = $x("//button[@id='submit']");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $x("//div[text()='Practice Form']").shouldBe(visible);
        $x("//h5[text()='Student Registration Form']").should(visible);
        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public RegistrationPage setGender(String gender) {
        $x("//label[contains(text(),'" + gender + "' )]").click();
        return this;
    }

    public RegistrationPage setPhone(String phone) {
        phoneNumberInput.setValue(phone);
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

    public RegistrationPage setHobby(String hobby) {
        $x("//label[contains(text(), '" + hobby + "')]").click();
        return this;
    }

    public RegistrationPage myUploadFile(String path) {
        uploadFileComponent.myUploadFile(uploadFileInput, path);
        return this;
    }

    public RegistrationPage setAddress(String address) {
        addressTextArea.setValue(address);
        return this;
    }

    public RegistrationPage setState(String state) {
        stateList.click();
        $x("//div[@class=' css-26l3qy-menu']//div[text()='" + state + "']").shouldBe(visible).click();
        return this;
    }

    public RegistrationPage setCity(String city) {
        cityList.click();
        $x("//div[@class=' css-26l3qy-menu']//div[text()='" + city + "']").shouldBe(visible).click();
        return this;
    }

    public void submitForm() {
        submitFormButton.submit();
    }

    public RegistrationPage verifyModalAppear(String modalTitle) {
        registrationResultModal.verifyModalAppear(modalTitle);
        return this;
    }

    public RegistrationPage verifyResults(String key, String value) {
        registrationResultModal.verifyResults(key, value);
        return this;
    }

    public String getNameFromFilePath(String path) {
        String[] parts = path.split("/");
        return parts[parts.length - 1];
    }
}
