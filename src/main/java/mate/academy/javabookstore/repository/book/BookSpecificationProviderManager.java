package mate.academy.javabookstore.repository.book;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.javabookstore.model.Book;
import mate.academy.javabookstore.repository.SpecificationProvider;
import mate.academy.javabookstore.repository.SpecificationProviderManager;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookSpecificationProviderManager implements SpecificationProviderManager<Book> {
    private final List<SpecificationProvider<Book>> specificationProviders;

    @Override
    public SpecificationProvider<Book> getSpecificationProvider(String key) {
        return specificationProviders.stream().filter(p -> p.getKey().equals(key)).findFirst()
                .orElseThrow(() -> new RuntimeException(
                        "Can't find specification provider with key: " + key));
    }
}
