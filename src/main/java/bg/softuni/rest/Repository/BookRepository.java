package bg.softuni.rest.Repository;

import bg.softuni.rest.model.Author;
import bg.softuni.rest.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
