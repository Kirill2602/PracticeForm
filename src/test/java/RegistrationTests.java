import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.constants.RegistrationFormConstants;
import testBase.TestBase;

public class RegistrationTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationFormConstants constants = new RegistrationFormConstants();

    @Test
    void fillPracticeFormTest() {
        registrationPage.openPage()
                .setFirstName(constants.getFIRST_NAME())
                .setLastName(constants.getLAST_NAME())
                .setEmail(constants.getEMAIL())
                .setGender(constants.getGENDER())
                .setPhone(constants.getPHONE())
                .setDate(constants.getDAY(), constants.getMONTH(), constants.getYEAR())
                .setSubject(constants.getSUBJECT())
                .setHobby(constants.getHOBBY())
                .myUploadFile(constants.getFILE_PATH())
                .setAddress(constants.getADDRESS())
                .setState(constants.getSTATE())
                .setCity(constants.getCITY())
                .submitForm();

        registrationPage.verifyModalAppear(constants.getMODAL_TITLE())
                .verifyResults("Student Name", constants.getFIRST_NAME() + " " + constants.getLAST_NAME())
                .verifyResults("Student Email", constants.getEMAIL())
                .verifyResults("Gender", constants.getGENDER())
                .verifyResults("Mobile", constants.getPHONE())
                .verifyResults("Date of Birth", constants.getDAY() + " " + constants.getMONTH() + "," + constants.getYEAR())
                .verifyResults("Subjects", constants.getSUBJECT())
                .verifyResults("Hobbies", constants.getHOBBY())
                .verifyResults("Picture", registrationPage.getNameFromFilePath(constants.getFILE_PATH()))
                .verifyResults("Address", constants.getADDRESS())
                .verifyResults("State and City", constants.getSTATE() + " " + constants.getCITY());
    }
}
