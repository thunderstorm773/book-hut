package bookHut.utils;

import javax.servlet.http.HttpSession;

public class LoggedInUtil {

    public static boolean isUserLoggedIn(HttpSession httpSession) {
        return httpSession.getAttribute("LOGIN_MODEL") != null;
    }
}
