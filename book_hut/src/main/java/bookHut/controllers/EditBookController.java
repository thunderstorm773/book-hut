package bookHut.controllers;

import bookHut.models.viewModels.ViewBookModel;
import bookHut.services.api.BookService;
import bookHut.services.impl.BookServiceImpl;
import bookHut.utils.LoggedInUtil;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/shelves/edit/*")
public class EditBookController extends HttpServlet {

    private BookService bookService;

    public EditBookController() {
        this.bookService = new BookServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (LoggedInUtil.isUserLoggedIn(req.getSession())) {
            String requestURI = req.getRequestURI();
            String[] requestURITokens = requestURI.split("/");
            Long bookId = Long.valueOf(requestURITokens[requestURITokens.length - 1]);
            ViewBookModel viewBookModel = this.bookService.findBookById(bookId);
            if (viewBookModel != null) {
                req.setAttribute("book", viewBookModel);
                req.getRequestDispatcher("/templates/edit-book.jsp")
                        .forward(req, resp);
            } else {
                resp.sendRedirect("/shelves");
            }
        } else {
            resp.sendRedirect("/sign-in");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (LoggedInUtil.isUserLoggedIn(req.getSession())) {
            String edit = req.getParameter("edit");
            if (edit != null) {
                String title = req.getParameter("title");
                String author = req.getParameter("author");
                String pagesStr = req.getParameter("pages");

                String requestURI = req.getRequestURI();
                String[] requestURITokens = requestURI.split("/");
                Long bookId = Long.valueOf(requestURITokens[requestURITokens.length - 1]);

                if (!title.isEmpty() && !author.isEmpty() && !pagesStr.isEmpty()) {
                    Integer pages = Integer.valueOf(pagesStr);
                    ViewBookModel editedBook = new ViewBookModel(bookId, title, author, pages);
                    this.bookService.editBook(bookId, editedBook);
                    resp.sendRedirect("/shelves");
                } else {
                    resp.sendRedirect("/shelves/edit/" + bookId);
                }
            }
        } else {
            resp.sendRedirect("/sign-in");
        }
    }
}
