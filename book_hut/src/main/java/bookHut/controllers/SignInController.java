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
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/sign-in")
public class SignInController extends HttpServlet {

    private UserService userService;

    public SignInController() {
        this.userService = new UserServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!LoggedInUtil.isUserLoggedIn(request.getSession())) {
            request.getRequestDispatcher("/templates/sign-in.jsp")
                    .forward(request, response);
        } else {
            response.sendRedirect("/");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!LoggedInUtil.isUserLoggedIn(request.getSession())) {
            String signIn = request.getParameter("sign-in");

            if (signIn != null) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                LoginModel loggedInUser = this.userService
                        .findByUsernameAndPassword(username, password);

                if (loggedInUser != null) {
                    HttpSession httpSession = request.getSession();
                    httpSession.setAttribute("LOGIN_MODEL", loggedInUser);
                    response.sendRedirect("/");
                } else {
                    response.sendRedirect("/sign-in");
                }
            }
        } else {
            response.sendRedirect("/");
        }
    }
}
