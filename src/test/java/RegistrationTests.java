import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import testBase.TestBase;

public class RegistrationTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = "Kirill",
            lastName = "Spitsyn",
            email = "kirill@mail.ru",
            phone = "8967023334",
            address = "CURRENT ADDRESS",
            gender = "Male",
            day = "26",
            month = "February",
            year = "1990",
            subject = "Maths",
            hobby = "Sport",
            filePath = "src/test/resources/image/cat.jpg",
            state = "NCR",
            city = "Gurgaon",
            modalTitle = "Thanks for submitting the form";

    @Test
    void fillPracticeFormTest() {

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhone(phone)
                .setDate(day, month, year)
                .setSubject(subject)
                .setHobby(hobby)
                .myUploadFile(filePath)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submitForm();

        registrationPage.verifyModalAppear(modalTitle)
                .verifyResults("Student Name", firstName + " " + lastName)
                .verifyResults("Student Email", email)
                .verifyResults("Gender", gender)
                .verifyResults("Mobile", phone)
                .verifyResults("Date of Birth", day + " " + month + "," + year)
                .verifyResults("Subjects", subject)
                .verifyResults("Hobbies", hobby)
                .verifyResults("Picture", registrationPage.getNameFromFilePath(filePath))
                .verifyResults("Address", address)
                .verifyResults("State and City", state + " " + city);
    }
}
