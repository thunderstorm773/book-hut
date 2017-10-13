package bookHut.services.api;

import bookHut.models.bindingModels.AddBookModel;
import bookHut.models.viewModels.ViewBookModel;
import java.util.List;

public interface BookService {

    void saveBook(AddBookModel addBookModel);

    List<ViewBookModel> getAllBooks();

    void deleteBookById(Long id);

    ViewBookModel findBookById(Long id);

    void editBook(Long id, ViewBookModel editedBook);
}
