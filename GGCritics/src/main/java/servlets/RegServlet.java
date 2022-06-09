package servlets;

import Service.AuthService;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.GGCritics.Model.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegServlet extends HttpServlet {

    private final ObjectMapper mapper;
    private final AuthService authService;

    public RegServlet(ObjectMapper mapper, AuthService authService) {
        this.mapper = mapper;
        this.authService = authService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        try {
            User newUser = mapper.readValue(req.getInputStream(), User.class);
            System.out.println(newUser);
            User user = authService.register(newUser);

            HttpSession session = req.getSession();
            session.setAttribute("auth-user", user);

            resp.setStatus(200);
            String respPayload = mapper.writeValueAsString(newUser);
            resp.setContentType("application/json");
            resp.getWriter().write(respPayload);

        } catch (Exception e) {
            resp.setStatus(401);
            e.printStackTrace();
        }

    }
}
