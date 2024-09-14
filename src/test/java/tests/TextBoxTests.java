package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1280x720";
        Configuration.baseUrl = "https://demoqa.com/automation-practice-form";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 25000; // 25 секунд

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
        $(".react-datepicker__month-select").$("option[value='9']").click(); // select October
        $(".react-datepicker__year-select").$("option[value='1995']").click();  // select year
        $(".react-datepicker__day--010").click(); // select day 10
        $("#subjectsContainer input").setValue("hindi").pressEnter();
        $(byText("Sports")).click(); // click checkbox "Sports"
        $("#uploadPicture").uploadFile(new File("C:\\Projects\\image.png"));
        $("#currentAddress").setValue("Sports street 43");
        $("#state").click(); // open list
        $(byText("Uttar Pradesh")).click(); // select state
        $("#city").click();
        $(byText("Lucknow")).click(); // select state
        $("#submit").click(); // send info


    }
}
