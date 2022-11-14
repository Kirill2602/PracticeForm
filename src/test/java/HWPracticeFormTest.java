import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class HWPracticeFormTest {
    @BeforeAll
    static void setup() {
        new ChromeOptions().addArguments("start-maximized");
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillPracticeFormTest() {
        String firstName = "Kirill";
        String lastName = "Spitsyn";
        String email = "kirill@mail.ru";
        String phone = "89670233344";
        String address = "CURRENT ADDRESS";
        String inputFields = "//input[@id='%s']";

        open("/automation-practice-form");
        $x("//div[text()='Practice Form']").shouldBe(visible);
        $x("//h5[text()='Student Registration Form']").should(visible);
        $x(String.format(inputFields, "firstName")).setValue(firstName);
        $x(String.format(inputFields, "lastName")).setValue(lastName);
        $x(String.format(inputFields, "userEmail")).setValue(email);
        $x("//label[contains(text(), 'Male')]").click();
        $x(String.format(inputFields, "userNumber")).setValue(phone);
        $x(String.format(inputFields, "dateOfBirthInput")).click();
        $(".react-datepicker__month-select").selectOption("February");
        $(".react-datepicker__year-select").selectOption("1990");
        $x("//div[@aria-label='Choose Monday, February 26th, 1990']").click();
        $x("//div[@id='subjectsContainer']//input[@id='subjectsInput']").setValue("Maths").pressEnter();
        $x("//div[@id='subjectsContainer']//input[@id='subjectsInput']").setValue("Ac");
        $x("//div[@class='subjects-auto-complete__menu css-26l3qy-menu']//div[@id='react-select-2-option-0']").click();
        $x("//label[contains(text(), 'Sports')]").click();
        $x("//label[contains(text(), 'Reading')]").click();
        $x(String.format(inputFields, "uploadPicture")).scrollTo().uploadFile(new File("src/test/resources/image/cat.jpg"));
        $x("//textarea[@id='currentAddress']").setValue(address);
        $x("//div[@id='state']//div[@class=' css-tlfecz-indicatorContainer']").click();
        $x("//div[@class=' css-26l3qy-menu']//div[text()='NCR']").shouldBe(visible).click();
        $x("//div[@id='city']//div[@class=' css-tlfecz-indicatorContainer']").click();
        $x("//div[@class=' css-26l3qy-menu']//div[text()='Gurgaon']").shouldBe(visible).click();
        $x("//button[@id='submit']").submit();

        $x("//div[@id='example-modal-sizes-title-lg']").shouldHave(text("Thanks for submitting the form"));
        $x("//table//tr/td[text()='Student Name']/following-sibling::td").shouldHave(text(firstName + " " + lastName));
        $x("//table//tr/td[text()='Student Email']/following-sibling::td").shouldHave(text(email));
        $x("//table//tr/td[text()='Mobile']/following-sibling::td").text().equals(phone);
        $x("//table//tr/td[text()='Gender']/following-sibling::td").shouldHave(text("Male"));
        $x("//table//tr/td[text()='Date of Birth']/following-sibling::td").shouldHave(text("26 February,1990"));
        $x("//table//tr/td[text()='Address']/following-sibling::td").shouldHave(text(address));
        $x("//table//tr/td[text()='Subjects']/following-sibling::td").shouldHave(text("Maths, Accounting"));
        $x("//table//tr/td[text()='Hobbies']/following-sibling::td").shouldHave(text("Sports, Reading"));
        $x("//table//tr/td[text()='Picture']/following-sibling::td").shouldHave(text("cat.jpg"));
        $x("//table//tr/td[text()='State and City']/following-sibling::td").shouldHave(text("NCR Gurgaon"));
        $x("//button[@id='closeLargeModal']").shouldBe(visible).pressEscape();
    }
}