package servlets;

import Service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.GGCritics.Daos.UserDaoPostgres;
import dev.GGCritics.Model.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import static java.lang.Integer.parseInt;

//@WebServlet(name = "UserServlet", urlPatterns = "/users/*")
public class UserServlet extends HttpServlet {

    private final ObjectMapper mapper;
    private final UserDaoPostgres userDao;
    private final UserService userService;

    public UserServlet(ObjectMapper mapper, UserDaoPostgres userDao, UserService userService) {
        this.mapper = mapper;
        this.userDao = userDao;
        this.userService = userService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String username = req.getParameter("username");
        System.out.println("[LOG] - Received a UserServlet GET request at " + LocalDateTime.now());

        if (username != null) {
           User user = userService.getUserByUsername(username);
            resp.setContentType("application/json");
            resp.getWriter().write(String.valueOf(user));
        } else if (id != null) {
            User user = userService.getUserById(id);
            resp.setContentType("application/json");
            resp.getWriter().write(String.valueOf(user));
        }
        else {
        List<User> users = userDao.getAllUsers();
        String respPayload = mapper.writeValueAsString(users);
        resp.setContentType("application/json");
        resp.getWriter().write(respPayload);
    }}

}

