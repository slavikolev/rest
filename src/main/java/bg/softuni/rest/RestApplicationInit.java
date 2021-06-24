package bg.softuni.rest;


import bg.softuni.rest.Repository.AuthorRepository;
import bg.softuni.rest.Repository.BookRepository;
import bg.softuni.rest.model.Author;
import bg.softuni.rest.model.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RestApplicationInit implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Autowired
    ObjectMapper om;

    RestApplicationInit(AuthorRepository authorRepository,
                        BookRepository bookRepository) {

        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        initJovkov();
        initNikolaiHaitov();
        initDimitarTalev();
        initElinPelin();
        initVazov();
    }

    private void initNikolaiHaitov() {
        initAuthor("Николай Хайтов",
                "Диви Разкази"
        );
    }

    private void initDimitarTalev() {
        initAuthor("Димитър Димов",
                "Тютюн"
        );
    }

    private void initElinPelin() {
        initAuthor("Елин Пелин",
                "Пижо и Пендо",
                "Ян Бибиян на луната",
                "Под манастирската лоза"
        );
    }

    private void initVazov() {
        initAuthor("Иван Вазов",
                "Пряпорец и Гусла",
                "Под Игото",
                "Тъгите на България"
        );
    }

    private void initJovkov() {

        initAuthor("Йордан Йовков",
                "Старопланински легенди",
                "Чифликът край границата");
    }

    private void initAuthor(String authorName, String... books) {
        Author author = new Author();
        author.setName(authorName);

        author = authorRepository.save(author);

        List<Book> allBooks = new ArrayList<>();

        for (String book: books) {
            Book aBook = new Book();
            aBook.setAuthor(author);
            aBook.setTitle(book);
            allBooks.add(aBook);
        }

        bookRepository.saveAll(allBooks);
    }
}