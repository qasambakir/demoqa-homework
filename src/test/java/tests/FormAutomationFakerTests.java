package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.FormAutomationPage;
import utils.RandomUtils;

public class FormAutomationFakerTests extends TestBase {

    final FormAutomationPage formPage = new FormAutomationPage();
    Faker faker = new Faker();

    // сгенерированные данные
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String gender = RandomUtils.getRandomGender();
    String phoneNumber = faker.phoneNumber().subscriberNumber(10);
    String address = faker.address().streetAddress();
    String birthMonth = RandomUtils.getRandomBirthMonth();
    String birthYear = RandomUtils.getRandomBirthYear();
    String birthDay = RandomUtils.getRandomBirthDay();
    String subject = RandomUtils.getRandomSubject();
    String hobbies = RandomUtils.getRandomHobby();
    String state = RandomUtils.getRandomState();
    String city = RandomUtils.getRandomCity(state);
    String picturePath = RandomUtils.getRandomPicturePath();

    @Test
    void successfulFormSubmissionTest() {
        formPage.openFormPage()
                .fillFirstName(firstName)
                .fillLastName(lastName)
                .fillEmail(email)
                .selectGender(gender)
                .fillPhoneNumber(phoneNumber)
                .setBirthDate(birthMonth, birthYear, birthDay)
                .setSubject(subject)
                .selectHobby(hobbies)
                .uploadPicture(picturePath)
                .setAddress(address)
                .selectStateAndCity(state, city)
                .submitForm();

        // Проверка результатов после успешной отправки
        formPage.checkFormResult("Student Name", firstName + " " + lastName)
                .checkFormResult("Student Email", email)
                .checkFormResult("Mobile", phoneNumber)
                .checkFormResult("Date of Birth", birthDay + " " + birthMonth + "," + birthYear)
                .checkFormResult("Subjects", subject) // Проверяем предмет
                .checkFormResult("Hobbies", hobbies)
                .checkFormResult("Address", address)
                .checkFormResult("State and City", state + " " + city)
                .checkFormResult("Picture", picturePath)
                .checkFormResult("Gender", gender); // Проверяем пол
    }
}
