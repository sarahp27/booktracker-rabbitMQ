package afn.xloop.booktracker_cnsd23;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository implements IBookRepository<Book> {

    private Map<Integer, Book> bookListRepo;

    public BookRepository(){
        this.bookListRepo = new HashMap<>();
    }

    @Override
    public void saveBook(Book book) {
        this.bookListRepo.put(book.getId(), book);
    }
}