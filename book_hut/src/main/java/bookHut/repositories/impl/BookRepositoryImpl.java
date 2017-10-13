package bookHut.repositories.impl;

import bookHut.entities.Book;
import bookHut.repositories.api.BookRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookRepositoryImpl implements BookRepository {

    private static BookRepository bookRepository;

    private List<Book> books;

    private Long currentIndex;

    private BookRepositoryImpl() {
        this.books = new ArrayList<>();
        this.currentIndex = 1L;
    }

    public static BookRepository getInstance() {
        if (bookRepository == null) {
            bookRepository = new BookRepositoryImpl();
        }

        return bookRepository;
    }

    @Override
    public void saveBook(Book book) {
        book.setId(this.currentIndex);
        this.currentIndex = this.currentIndex + 1L;
        this.books.add(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return this.books;
    }

    @Override
    public void deleteBookById(Long id) {
        Book book = this.findBookById(id);
        if (book != null) {
            this.books.remove(book);
        }
    }

    @Override
    public Book findBookById(Long id) {
        Optional<Book> candidateBook = this.books.stream().
                filter(b -> b.getId().equals(id)).findAny();
        Book book = null;
        if (candidateBook.isPresent()) {
            book = candidateBook.get();
        }

        return book;
    }

    @Override
    public void editBook(Long id, Book editedBook) {
        Integer bookIndex = findBookIndexById(id);
        if (bookIndex != null) {
            this.books.set(bookIndex, editedBook);
        }
    }

    private Integer findBookIndexById(Long id) {
        Integer bookIndex = null;

        for (int i = 0; i < this.books.size(); i++) {
            Book book = this.books.get(i);
            if (book.getId().equals(id)) {
                bookIndex = i;
                break;
            }
        }

        return bookIndex;
    }
}
