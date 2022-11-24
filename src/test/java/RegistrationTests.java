import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import testbase.TestBase;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class RegistrationTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    SimpleDateFormat formatter = new SimpleDateFormat("dd MMMMM,yyyy", Locale.ENGLISH);


    @Test
    void fillPracticeFormTest() {

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
