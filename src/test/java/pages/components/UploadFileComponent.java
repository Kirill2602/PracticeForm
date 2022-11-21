package pages.components;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

public class UploadFileComponent {
    public void myUploadFile(SelenideElement element, String path) {
        element.scrollTo().uploadFile(new File(path));
    }
}
