package bookHut.controllers;

import bookHut.utils.LoggedInUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/sign-out")
public class SignOutController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (LoggedInUtil.isUserLoggedIn(request.getSession())) {
            HttpSession httpSession = request.getSession();
            httpSession.invalidate();
        }

        response.sendRedirect("/");
    }
}
