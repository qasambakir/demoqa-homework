package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.DateSelectorComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormAutomationPage {
    // Локаторы для элементов формы
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsContainer input"),
            hobbyCheckbox = $("[for=hobbies-checkbox-1]"),
            uploadPictureInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateDropdown = $("#state"),
            cityDropdown = $("#city"),
            submitButton = $("#submit");

    // Инициализация компонента для выбора даты
    DateSelectorComponent dateSelector = new DateSelectorComponent();

    // Открытие страницы формы
    public FormAutomationPage openFormPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    // Заполнение имени
    public FormAutomationPage fillFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    // Заполнение фамилии
    public FormAutomationPage fillLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    // Заполнение email
    public FormAutomationPage fillEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    // Выбор пола
    public FormAutomationPage selectGender(String gender) {
        genderWrapper.$(byText(gender)).click();
        return this;
    }

    // Заполнение номера телефона
    public FormAutomationPage fillPhoneNumber(String phoneNumber) {
        userNumberInput.setValue(phoneNumber);
        return this;
    }

    // Установка даты рождения
    public FormAutomationPage setBirthDate(String month, String year, String day) {
        dateInput.click(); // Открыть календарь
        dateSelector.setDate(month, year, day); // Выбрать дату через компонент DateSelector
        return this;
    }

    // Установка предмета
    public FormAutomationPage setSubject(String subject) {
        subjectInput.setValue(subject).pressEnter();
        return this;
    }

    // Выбор хобби
    public FormAutomationPage selectHobby() {
        hobbyCheckbox.click();
        return this;
    }

    // Загрузка изображения
    public FormAutomationPage uploadPicture(String filePath) {
        uploadPictureInput.uploadFromClasspath(filePath);
        return this;
    }

    // Заполнение адреса
    public FormAutomationPage setAddress(String address) {
        addressInput.setValue(address);
        return this;
    }

    // Выбор штата и города
    public FormAutomationPage selectStateAndCity(String state, String city) {
        stateDropdown.click();
        $(byText(state)).click();
        cityDropdown.click();
        $(byText(city)).click();
        return this;
    }

    // Отправка формы
    public FormAutomationPage submitForm() {
        submitButton.click();
        return this;
    }

    // Проверка результата формы
    public FormAutomationPage checkFormResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));
        return this;
    }
}