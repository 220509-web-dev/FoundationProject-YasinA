package servlets;

import Service.AuthService;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.GGCritics.Model.User;
import dev.GGCritics.Utilities.InvalidCredentialsException;
import dtos.Credentials;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;

public class AuthServlet extends HttpServlet {

    private final ObjectMapper mapper;
    private final AuthService authService;
    public AuthServlet(ObjectMapper mapper, AuthService authService) {
        this.mapper = mapper;
        this.authService = authService;
    }

    // Makes a session
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        System.out.println("[LOG] - Received a RegServlet Post request at " + LocalDateTime.now());

        Credentials credentials = mapper.readValue(req.getInputStream(), Credentials.class);

        try {
            User authenticatedUser = authService.login(credentials);
            // Create an HTTP session and add the authenticatedUser as an attribute to it
            HttpSession session = req.getSession();
            session.setAttribute("auth-user", authenticatedUser);

            resp.setStatus(200);
            resp.setContentType("application/json");
            resp.getWriter().write(mapper.writeValueAsString(authenticatedUser));// replace if needed
            return;
        } catch (InvalidCredentialsException e) {
            resp.setStatus(401); // UNAUTHORIZED (login failure)
        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(500);
        }

//        List<User> users = new UserDaoPostgres().getAllUsers();
//        try {
//            Credentials credentials = mapper.readValue(req.getInputStream(), Credentials.class);
//            String paramUsername = (String) credentials.getUsername();
//            String paramPassword = (String) credentials.getPassword();
//
//            for (User user : users) {
//                if (paramUsername.equals(user.getUsername()) && paramPassword.equals(user.getPassword())) {
//                    System.out.println("[LOG] - found user!");
//
//                    HttpSession session = req.getSession();
//                    session.setAttribute("auth-user", user);
//
//                    resp.setStatus(204);
//                    return;
//                }
//            }
//        } catch (InvalidCredentialsException e) {
//        resp.setStatus(400);
//        resp.setContentType("application/json");
//        HashMap<String, Object> errorMessage = new HashMap<>();
//        errorMessage.put("code", 400);
//        errorMessage.put("message", "No user found with provided credentials");
//        errorMessage.put("timestamp", LocalDateTime.now().toString());
//
//        resp.getWriter().write(mapper.writeValueAsString(errorMessage));
//        }
    }



    // deletes session
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        resp.setStatus(204);
    }

}
