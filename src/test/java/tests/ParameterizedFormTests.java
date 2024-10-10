package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.FormAutomationPage;
import utils.RandomUtils;
import java.util.stream.Stream;

@DisplayName("Класс параметризированных тестов")
public class ParameterizedFormTests extends TestBase {

    final FormAutomationPage formPage = new FormAutomationPage();

    // Использование @ValueSource для проверки валидности email
    @ParameterizedTest
    @DisplayName("Использование @ValueSource для проверки валидности email")
    @ValueSource(strings = {"test1@example.com", "test2@example.com", "invalid-email"})
    void emailValidationTest(String email) {
        formPage.openFormPage()
                .fillFirstName("John")
                .fillLastName("Doe")
                .selectGender("Male")
                .fillPhoneNumber("1234567890")
                .fillEmail(email)
                .submitForm();

        if (email.contains("@")) {
            formPage.checkFormSubmissionSuccess()
                    .checkFormResult("Student Email", email);
        } else {
            formPage.checkFormNotSubmitted();
        }
    }

    // Использование @CsvSource для тестирования ввода имени, фамилии и email
    @ParameterizedTest
    @DisplayName("Использование @CsvSource для тестирования ввода имени, фамилии и email")
    @CsvSource({
            "John, Doe, john.doe@example.com",
            "Test, User, test.user@example.com"
    })
    void registrationTest(String firstName, String lastName, String email) {
        formPage.openFormPage()
                .fillFirstName(firstName)
                .fillLastName(lastName)
                .selectGender("Male")
                .fillPhoneNumber("0987654321")
                .fillEmail(email)
                .submitForm();

        formPage.checkFormResult("Student Name", firstName + " " + lastName)
                .checkFormResult("Student Email", email);
    }

    @Disabled("Временное отключение теста")
    @Test
    void registrationForJaneSmithTest() {
        String firstName = "Jane";
        String lastName = "Smith";
        String email = "jane.smith@example.com";

        formPage.openFormPage()
                .fillFirstName(firstName)
                .fillLastName(lastName)
                .selectGender("Female")
                .fillPhoneNumber("0987654321")
                .fillEmail(email)
                .submitForm();

        // Проверка результатов
        formPage.checkFormSubmissionSuccess()
                .checkFormResult("Student Name", firstName + " " + lastName)
                .checkFormResult("Student Email", email);
    }

    // Использование @MethodSource для генерации случайных данных
    static Stream<Arguments> formDataProvider() {
        Faker faker = new Faker();
        return Stream.of(
                Arguments.of(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        faker.internet().emailAddress(),
                        RandomUtils.getRandomGender(),
                        faker.phoneNumber().subscriberNumber(10),
                        faker.address().streetAddress(),
                        RandomUtils.getRandomBirthMonth(),
                        RandomUtils.getRandomBirthYear(),
                        RandomUtils.getRandomBirthDay(),
                        RandomUtils.getRandomSubject(),
                        RandomUtils.getRandomPicturePath()
                )
        );
    }

    @ParameterizedTest
    @DisplayName("Использование @MethodSource для генерации случайных данных")
    @MethodSource("formDataProvider")
    void successfulFormSubmissionTest(String firstName,
                                      String lastName,
                                      String email,
                                      String gender,
                                      String phoneNumber,
                                      String address,
                                      String birthMonth,
                                      String birthYear,
                                      String birthDay,
                                      String subject,
                                      String picturePath) {
        formPage.openFormPage()
                .fillFirstName(firstName)
                .fillLastName(lastName)
                .fillEmail(email)
                .selectGender(gender)
                .fillPhoneNumber(phoneNumber)
                .setBirthDate(birthMonth, birthYear, birthDay)
                .setSubject(subject)
                .uploadPicture(picturePath)
                .setAddress(address)
                .submitForm();

        formPage.checkFormResult("Student Name", firstName + " " + lastName)
                .checkFormResult("Student Email", email)
                .checkFormResult("Gender", gender)
                .checkFormResult("Mobile", phoneNumber)
                .checkFormResult("Date of Birth", birthDay + " " + birthMonth + "," + birthYear)
                .checkFormResult("Subjects", subject)
                .checkFormResult("Picture", picturePath.substring(picturePath.lastIndexOf("/") + 1))
                .checkFormResult("Address", address);
    }
}
