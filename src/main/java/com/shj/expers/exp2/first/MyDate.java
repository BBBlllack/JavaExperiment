package com.shj.expers.exp2.first;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyDate {
    private int year;
    private int month;
    private int day;

    public boolean isValidDate() {
        if (year < 1900 || year > 2100) {
            return false;
        }
        if (month < 1 || month > 12) {
            return false;
        }
        if (day < 1 || day > daysInMonth()) {
            return false;
        }
        return true;
    }

    private int daysInMonth() {
        int days;
        switch (month) {
            case 2:
                days = isLeapYear() ? 29 : 28;
                break;
            case 4: case 6: case 9: case 11:
                days = 30;
                break;
            default:
                days = 31;
                break;
        }
        return days;
    }

    private boolean isLeapYear() {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }
}
