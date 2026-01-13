package mate.academy.javabookstore.constants;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class BookConstants {
    public static final int MIN_TITLE_SIZE = 3;
    public static final int MAX_TITLE_SIZE = 50;

    public static final int MIN_AUTHOR_SIZE = 3;
    public static final int MAX_AUTHOR_SIZE = 30;

    public static final String ISBN_REGEX = "\\d{3}+-\\d{10}+";
    public static final String ISBN_REGEX_ERROR_MSG =
            "Should contain 14 symbols and be in the pattern 000-0000000000";
}
