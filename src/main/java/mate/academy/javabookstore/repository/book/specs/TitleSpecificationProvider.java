package mate.academy.javabookstore.repository.book.specs;

import mate.academy.javabookstore.model.Book;
import mate.academy.javabookstore.repository.LikeSpecificationProvider;
import mate.academy.javabookstore.repository.book.BookSpecificationFields;
import org.springframework.stereotype.Component;

@Component
public class TitleSpecificationProvider extends LikeSpecificationProvider<Book> {
    public TitleSpecificationProvider() {
        super(BookSpecificationFields.TITLE.getKey());
    }
}
