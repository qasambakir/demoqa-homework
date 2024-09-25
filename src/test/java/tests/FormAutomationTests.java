package tests;

import org.junit.jupiter.api.Test;
import pages.FormAutomationPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class FormAutomationTests extends BaseTestSetup {

    FormAutomationPage formPage = new FormAutomationPage();

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

        formPage.checkFormResult("Student Name", "Sam Baker")
                .checkFormResult("Student Email", "qabaker@gmail.com")
                .checkFormResult("Mobile", "7077570510")
                .checkFormResult("Date of Birth", "10 October,1995")
                .checkFormResult("Subjects", "Hindi")
                .checkFormResult("Hobbies", "Sports")
                .checkFormResult("Address", "Sports street 43")
                .checkFormResult("State and City", "Uttar Pradesh Lucknow");
    }

    @Test
    void minimalFormSubmissionTest() {
        formPage.openFormPage()
                .fillFirstName("Test")
                .fillLastName("Testov")
                .selectGender("Male")
                .fillPhoneNumber("9876543210")
                .submitForm();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }

    // Негативный тест: Поле Gender не выбрано
    @Test
    void genderNotSelectedTest() {
        formPage.openFormPage()
                .fillFirstName("Sam")
                .fillLastName("Baker")
                .fillEmail("dsn@smda.la")
                .fillPhoneNumber("7077470510")
                .setBirthDate("October", "1995", "10")
                .setSubject("Hindi")
                .selectHobby()
                .uploadPicture("image.png")
                .setAddress("Sports street 43")
                .selectStateAndCity("Uttar Pradesh", "Lucknow")
                .submitForm();

        // Проверка, что форма не отправилась, т.к. "Gender" не был выбран
        $(".modal-dialog").shouldNot(appear); // Модальное окно не должно появить
    }

    // Негативный тест: Поле Last Name не заполнено
    @Test
    void lastNameNotFilledTest() {
        formPage.openFormPage()
                .fillFirstName("Sam")
                // Пропускаем поле Last Name
                .fillEmail("dsn@smda.la")
                .selectGender("Male")
                .fillPhoneNumber("7077470510")
                .setBirthDate("October", "1995", "10")
                .setSubject("Hindi")
                .selectHobby()
                .uploadPicture("image.png")
                .setAddress("Sports street 43")
                .selectStateAndCity("Uttar Pradesh", "Lucknow")
                .submitForm();

        // Проверка, что поле Last Name не заполнено, и форма не отправляется
        $("#lastName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }
}
