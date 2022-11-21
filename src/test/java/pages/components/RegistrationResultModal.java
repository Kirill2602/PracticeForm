package pages.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RegistrationResultModal {
    public void verifyModalAppear(String modalTitle) {
        $(".modal-dialog").should(appear);
        $x("//div[@id='example-modal-sizes-title-lg']").shouldHave(text(modalTitle));
    }

    public void verifyResults(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));
    }
}
