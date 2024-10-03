package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class DateSelectorComponent {

    public void setDate(String month, String year, String day) {
        // Преобразование названия месяца в индекс для календаря
        String monthIndex = getMonthIndex(month);
        // Кликаем для выбора месяца
        $(".react-datepicker__month-select").$("option[value='" + monthIndex + "']").click();
        // Кликаем для выбора года
        $(".react-datepicker__year-select").$("option[value='" + year + "']").click();
        // Выбираем день
        String daySelector = String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", day);
        $(daySelector).click();
    }

    // Метод для преобразования месяца в индекс (0-based)
    private String getMonthIndex(String month) {
        switch (month) {
            case "January": return "0";
            case "February": return "1";
            case "March": return "2";
            case "April": return "3";
            case "May": return "4";
            case "June": return "5";
            case "July": return "6";
            case "August": return "7";
            case "September": return "8";
            case "October": return "9";
            case "November": return "10";
            case "December": return "11";
            default: throw new IllegalArgumentException("Invalid month: " + month);
        }
    }
}