package mate.academy.javabookstore.constants.user;

public class UserDocs {
    public static final String PASSWORD_DESC = """
            Should contain from 8 to 50 symbols, at least one capital letter,\s
            at least one special symbol""";
    public static final String PASSWORD_EX = "qwerTy1234#";

    public static final String REPEAT_PASSWORD_DESC = "Should match the password";

    public static final String SHIPPING_ADDRESS_DESC = "Full user's address for shipping";
    public static final String SHIPPING_ADDRESS_EX = "123 Main St, City, Country";

    public static final String NAME_DESC =
            "Should contain from " + UserConstants.MIN_NAME_SIZE + " to "
                    + UserConstants.MAX_NAME_SIZE + " symbols";
    public static final String FIRST_NAME_EX = "John";
    public static final String LAST_NAME_EX = "Doe";
}
