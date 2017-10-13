package bookHut.controllers;

import bookHut.models.bindingModels.AddBookModel;
import bookHut.services.api.BookService;
import bookHut.services.impl.BookServiceImpl;
import bookHut.utils.LoggedInUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddBookController extends HttpServlet {

    private BookService bookService;

    public AddBookController() {
        this.bookService = new BookServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (LoggedInUtil.isUserLoggedIn(request.getSession())) {
            request.getRequestDispatcher("/templates/add-book.jsp")
                    .forward(request, response);
        } else {
            response.sendRedirect("/sign-in");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (LoggedInUtil.isUserLoggedIn(request.getSession())) {
            String add = request.getParameter("add");
            if (add != null) {
                String title = request.getParameter("title");
                String author = request.getParameter("author");
                String pagesStr = request.getParameter("pages");

                if (!title.isEmpty() && !author.isEmpty() && !pagesStr.isEmpty()) {
                    Integer pages = Integer.valueOf(pagesStr);
                    AddBookModel addBookModel = new AddBookModel(title, author, pages);
                    this.bookService.saveBook(addBookModel);
                }

                response.sendRedirect("/add");
            }
        } else {
            response.sendRedirect("/sign-in");
        }
    }
}
