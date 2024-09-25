package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class DateSelectorComponent {
    public void setDate(String month, String year, String day) {
        $(".react-datepicker__month-select").$("option[value='9']").click();
        $(".react-datepicker__year-select").$("option[value='1995']").click();
        String daySelector = String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", day);
        $(daySelector).click();
    }
}
