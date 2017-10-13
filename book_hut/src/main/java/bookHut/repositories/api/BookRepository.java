package bookHut.repositories.api;

import bookHut.entities.Book;

import java.util.List;

public interface BookRepository {

    void saveBook(Book book);

    List<Book> getAllBooks();

    void deleteBookById(Long id);

    Book findBookById(Long id);

    void editBook(Long id, Book editedBook);
}
