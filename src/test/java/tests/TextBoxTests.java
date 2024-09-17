package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com/automation-practice-form";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Sam");
        $("#lastName").setValue("Baker");
        $("#userEmail").setValue("qabaker@gmail.com");
        $("#gender-radio-1").parent().click();
        $("#userNumber").setValue("7077570510");
        $("#dateOfBirthInput").click(); // open calendar
        $(".react-datepicker__month-select").$("option[value='9']").click();
        $(".react-datepicker__year-select").$("option[value='1995']").click();
        $(".react-datepicker__day--010").click(); // select day 10
        $("#subjectsContainer input").setValue("hindi").pressEnter();
        $("[for=hobbies-checkbox-1]").click();
        $("#uploadPicture").uploadFromClasspath("image.png");
        $("#currentAddress").setValue("Sports street 43");
        $("#state").click();
        $("#react-select-3-option-1").click();
        $("#city").click();
        $("#react-select-4-option-1").click();
        $("#submit").click();

        // Проверка введённых данных в таблице
        $(".table-responsive").shouldHave(text("Sam Baker"));
        $(".table-responsive").shouldHave(text("qabaker@gmail.com"));
        $(".table-responsive").shouldHave(text("7077570510"));                // Проверка номера телефона
        $(".table-responsive").shouldHave(text("10 October,1995"));           // Проверка даты рождения
        $(".table-responsive").shouldHave(text("Hindi"));                     // Проверка выбранного предмета
        $(".table-responsive").shouldHave(text("Sports"));                    // Проверка выбранного хобби
        $(".table-responsive").shouldHave(text("Sports street 43"));          // Проверка введённого адреса
        $(".table-responsive").shouldHave(text("Uttar Pradesh Lucknow"));      // Проверка штата и города


    }
}
