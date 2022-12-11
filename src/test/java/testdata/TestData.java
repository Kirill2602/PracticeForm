package testdata;

import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class TestData {
    Faker faker = new Faker();
    Random random = new Random();
    List<String> genderList = Arrays.asList("Male", "Female", "Other");
    List<String> hobbyList = Arrays.asList("Sport", "Music", "Reading");
    List<String> subjectsList = Arrays.asList("Maths", "Arts", "Commerce", "Civics", "Hindi");
    private String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            phone = faker.phoneNumber().subscriberNumber(10),
            address = faker.address().fullAddress(),
            gender = genderList.get(random.nextInt(genderList.size())),
            subject = subjectsList.get(random.nextInt(subjectsList.size())),
            hobby = hobbyList.get(random.nextInt(hobbyList.size())),
            filePath = "src/test/resources/image/cat.jpg",
            state = "NCR",
            city = "Gurgaon",
            modalTitle = "Thanks for submitting the form";
    public Date birthDay = faker.date().birthday();

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public String getSubject() {
        return subject;
    }

    public String getHobby() {
        return hobby;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getModalTitle() {
        return modalTitle;
    }
}