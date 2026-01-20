package mate.academy.javabookstore.constants.user;

public class UserConstants {
    public static final int MIN_NAME_SIZE = 3;
    public static final int MAX_NAME_SIZE = 30;

    public static final String PASSWORD_REGEX =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&#])[A-Za-z\\d@$!%*?&#]{8,50}$";
}
