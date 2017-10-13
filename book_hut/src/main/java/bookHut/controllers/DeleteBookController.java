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

@WebServlet("/shelves/delete/*")
public class DeleteBookController extends HttpServlet {

    private BookService bookService;

    public DeleteBookController() {
        this.bookService = new BookServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (LoggedInUtil.isUserLoggedIn(request.getSession())) {
            String requestURI = request.getRequestURI();
            String[] requestURITokens = requestURI.split("/");
            Long bookId = Long.valueOf(requestURITokens[requestURITokens.length - 1]);
            ViewBookModel viewBookModel = this.bookService.findBookById(bookId);
            if (viewBookModel != null) {
                request.setAttribute("book", viewBookModel);
                request.getRequestDispatcher("/templates/delete-book.jsp")
                        .forward(request, response);
            } else {
                response.sendRedirect("/shelves");
            }
        } else {
            response.sendRedirect("/sign-in");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (LoggedInUtil.isUserLoggedIn(request.getSession())) {
            String delete = request.getParameter("delete");
            if (delete != null) {
                String requestURI = request.getRequestURI();
                String[] requestURITokens = requestURI.split("/");
                Long bookId = Long.valueOf(requestURITokens[requestURITokens.length - 1]);
                this.bookService.deleteBookById(bookId);
                response.sendRedirect("/shelves");
            }
        } else {
            response.sendRedirect("/sign-in");
        }
    }
}
