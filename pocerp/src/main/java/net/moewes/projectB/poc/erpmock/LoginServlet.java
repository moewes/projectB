package net.moewes.projectB.poc.erpmock;

import org.keycloak.AuthorizationContext;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.representations.IDToken;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {


    public void init(ServletConfig servletConfig) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        PrintWriter w = res.getWriter();

        w.append("Hallo");

        KeycloakSecurityContext context = (KeycloakSecurityContext) req.getAttribute(KeycloakSecurityContext.class.getName());

        IDToken id = context.getIdToken();

        w.append("<br/>Name: " + id.getPreferredUsername());

        AuthorizationContext ac = context.getAuthorizationContext();


        w.close();
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
