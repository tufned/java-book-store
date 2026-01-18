package mate.academy.javabookstore.constants.book;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class BookDocs {
    public static final String ID_DESC = "The numeric id of the book";
    public static final String ID_EX = "12";

    public static final String TITLE_DESC = "The official title of the book";
    public static final String TITLE_EX = "The Hobbit";

    public static final String AUTHOR_DESC = "The author's name";
    public static final String AUTHOR_EX = "John Doe";

    public static final String ISBN_DESC = "13-digit ISBN number";
    public static final String ISBN_EX = "978-000000000";

    public static final String PRICE_DESC =
            "Decimal price, contains 2 digits from coma. Must be positive";
    public static final String PRICE_EX = "109.99";

    public static final String DESCRIPTION_DESC = "Description of the book";
    public static final String DESCRIPTION_EX = "This is dark fantasy book";

    public static final String COVER_IMAGE_DESC = "Cover image url";
    public static final String COVER_IMAGE_EX = "https://example.com/cover-image.jpg";
}
