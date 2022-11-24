package pages.components;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMMM yyyy", Locale.ENGLISH);
        String[] dates = formatter.format(date).split(" ");

        $(".react-datepicker__month-select").selectOption(dates[1]);
        $(".react-datepicker__year-select").selectOption(dates[2]);
        $(".react-datepicker__day--0" + dates[0] +
                ":not(.react-datepicker__day--outside-month)").click();
    }
}
