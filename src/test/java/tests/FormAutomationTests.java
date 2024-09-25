package tests;

import org.junit.jupiter.api.Test;
import pages.FormAutomationPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class FormAutomationTests extends TestBase {

    final FormAutomationPage formPage = new FormAutomationPage();

    @Test
    void successfulFormSubmissionTest() {
        formPage.openFormPage()
                .fillFirstName("Sam")
                .fillLastName("Baker")
                .fillEmail("qabaker@gmail.com")
                .selectGender("Male")
                .fillPhoneNumber("7077570510")
                .setBirthDate("October", "1995", "10")
                .setSubject("Hindi")
                .selectHobby()
                .uploadPicture("image.png")
                .setAddress("Sports street 43")
                .selectStateAndCity("Uttar Pradesh", "Lucknow")
                .submitForm();

        // Проверка результатов после успешной отправки
        formPage.checkFormResult("Student Name", "Sam Baker")
                .checkFormResult("Student Email", "qabaker@gmail.com")
                .checkFormResult("Mobile", "7077570510")
                .checkFormResult("Date of Birth", "10 October,1995")
                .checkFormResult("Subjects", "Hindi")
                .checkFormResult("Hobbies", "Sports")
                .checkFormResult("Address", "Sports street 43")
                .checkFormResult("State and City", "Uttar Pradesh Lucknow")
                .checkFormResult("Picture", "image.png");
    }

    // Минимальная отправка формы
    @Test
    void minimalFormSubmissionTest() {
        formPage.openFormPage()
                .fillFirstName("Test")
                .fillLastName("Testov")
                .selectGender("Male")
                .fillPhoneNumber("9876543210")
                .submitForm();

        // Проверка успешной отправки
        formPage.checkFormSubmissionSuccess()
                .checkFormResult("Student Name", "Test Testov")
                .checkFormResult("Mobile", "9876543210")
                .checkFormResult("Gender", "Male");
    }

    @Test
    public void formNotSubmittedWithoutRequiredFieldsTest() {
        formPage.openFormPage()
                .fillFirstName("Sam")
                .fillEmail("dsn@smda.la")
                .fillPhoneNumber("7077470510")
                .setBirthDate("October", "1995", "10")
                .submitForm();

        // Проверка, что форма не отправляется
        $(".modal-dialog").shouldNot(appear);
        formPage.checkFormNotSubmitted();
    }
}
