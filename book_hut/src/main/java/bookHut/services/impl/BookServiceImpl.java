package bookHut.services.impl;

import bookHut.entities.Book;
import bookHut.models.bindingModels.AddBookModel;
import bookHut.models.viewModels.ViewBookModel;
import bookHut.repositories.impl.BookRepositoryImpl;
import bookHut.services.api.BookService;
import bookHut.utils.MapperUtil;
import java.util.List;

public class BookServiceImpl implements BookService {

    @Override
    public void saveBook(AddBookModel addBookModel) {
        if (addBookModel != null) {
            Book book = MapperUtil.getInstance().getModelMapper()
                    .map(addBookModel, Book.class);
            BookRepositoryImpl.getInstance().saveBook(book);
        }
    }

    @Override
    public List<ViewBookModel> getAllBooks() {
        List<Book> books = BookRepositoryImpl.getInstance().getAllBooks();
        List<ViewBookModel> viewBookModels = MapperUtil.getInstance()
                .convertAll(books, ViewBookModel.class);
        return viewBookModels;
    }

    @Override
    public void deleteBookById(Long id) {
        BookRepositoryImpl.getInstance().deleteBookById(id);
    }

    @Override
    public ViewBookModel findBookById(Long id) {
        Book book = BookRepositoryImpl.getInstance().findBookById(id);
        ViewBookModel viewBookModel = null;

        if (book != null) {
            viewBookModel = MapperUtil.getInstance().getModelMapper()
                    .map(book, ViewBookModel.class);
        }

        return viewBookModel;
    }

    @Override
    public void editBook(Long id, ViewBookModel editedBook) {
        Book book = MapperUtil.getInstance().getModelMapper()
                .map(editedBook, Book.class);
        BookRepositoryImpl.getInstance().editBook(id, book);
    }
}
