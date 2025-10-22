package poly.edu.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import poly.edu.model.AccessLog;
import poly.edu.model.Account;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class LogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Account user = (Account) session.getAttribute("user");

        String uri = request.getRequestURI();
        LocalDateTime timestamp = LocalDateTime.now();
        String username = user != null ? user.getUsername() : "Guest";

        AccessLog log = new AccessLog(uri, timestamp, username);

        @SuppressWarnings("unchecked")
        List<AccessLog> accessLogs = (List<AccessLog>) session.getAttribute("accessLogs");
        if (accessLogs == null) {
            accessLogs = new ArrayList<>();
            session.setAttribute("accessLogs", accessLogs);
        }
        accessLogs.add(log);

        return true;
    }
}
