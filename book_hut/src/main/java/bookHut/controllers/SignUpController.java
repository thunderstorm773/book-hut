package bookHut.controllers;

import bookHut.models.bindingModels.LoginModel;
import bookHut.services.api.UserService;
import bookHut.services.impl.UserServiceImpl;
import bookHut.utils.LoggedInUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sign-up")
public class SignUpController extends HttpServlet {

    private UserService userService;

    public SignUpController() {
        this.userService = new UserServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!LoggedInUtil.isUserLoggedIn(request.getSession())) {
            request.getRequestDispatcher("/templates/sign-up.jsp")
                    .forward(request, response);
        } else {
            response.sendRedirect("/");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!LoggedInUtil.isUserLoggedIn(request.getSession())) {
            String signUp = request.getParameter("sign-up");
            if (signUp != null) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                boolean isUserExists = this.userService.isUserExists(username);

                if ((!username.isEmpty() && !password.isEmpty()) && !isUserExists) {
                    LoginModel loginModel = new LoginModel(username, password);
                    this.userService.createUser(loginModel);
                    response.sendRedirect("/sign-in");
                } else {
                    response.sendRedirect("/sign-up");
                }
            }
        } else {
            response.sendRedirect("/");
        }
    }
}
