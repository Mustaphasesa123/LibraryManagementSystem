package librarymanagementsystem;

import java.time.LocalDate;

public class Validation {

    public static boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".");
    }

    public static boolean isValidDates(String borrowDate, String dueDate) {
        LocalDate borrow = LocalDate.parse(borrowDate);
        LocalDate due = LocalDate.parse(dueDate);

        return due.isAfter(borrow);
    }
}
