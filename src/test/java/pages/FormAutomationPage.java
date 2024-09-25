package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.DateSelectorComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormAutomationPage {

    private final SelenideElement
            firstNameInput = $("#firstName"),
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

    final DateSelectorComponent dateSelector = new DateSelectorComponent();

    public FormAutomationPage openFormPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public FormAutomationPage fillFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public FormAutomationPage fillLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public FormAutomationPage fillEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public FormAutomationPage selectGender(String gender) {
        genderWrapper.$(byText(gender)).click();
        return this;
    }

    public FormAutomationPage fillPhoneNumber(String phoneNumber) {
        userNumberInput.setValue(phoneNumber);
        return this;
    }

    public FormAutomationPage setBirthDate(String month, String year, String day) {
        dateInput.click();
        dateSelector.setDate(month, year, day);
        return this;
    }

    public FormAutomationPage setSubject(String subject) {
        subjectInput.setValue(subject).pressEnter();
        return this;
    }

    public FormAutomationPage selectHobby() {
        hobbyCheckbox.click();
        return this;
    }

    public FormAutomationPage uploadPicture(String filePath) {
        uploadPictureInput.uploadFromClasspath(filePath);
        return this;
    }

    public FormAutomationPage setAddress(String address) {
        addressInput.setValue(address);
        return this;
    }

    public FormAutomationPage selectStateAndCity(String state, String city) {
        stateDropdown.click();
        $(byText(state)).click();
        cityDropdown.click();
        $(byText(city)).click();
        return this;
    }

    public FormAutomationPage submitForm() {
        submitButton.click();
        return this;
    }

    public FormAutomationPage checkFormNotSubmitted() {
        $(".modal-dialog").shouldNot(appear);
        return this;
    }

    public FormAutomationPage checkFormResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));
        return this;
    }
}
