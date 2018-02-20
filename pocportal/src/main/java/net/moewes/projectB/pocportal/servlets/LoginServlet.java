package net.moewes.projectB.pocportal.servlets;

import net.moewes.projectB.pocerp.rest.api.HelloResource;
import org.keycloak.AuthorizationContext;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.representations.IDToken;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/index.html")
public class LoginServlet extends HttpServlet {

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        PrintWriter w = res.getWriter();

        w.append("<p>Hallo");

        KeycloakSecurityContext context = (KeycloakSecurityContext) req.getAttribute(KeycloakSecurityContext.class.getName());

        if (context != null) {
            IDToken id = context.getIdToken();

            w.append("<br/>Benutzer: " + id.getPreferredUsername() + "</p>");

            AuthorizationContext ac = context.getAuthorizationContext();

            //log(context.getToken());
            log(context.getTokenString());
            // Aufruf eines Webservices
            Client client = ClientBuilder.newClient();

            HelloResource result = client.target("http://localhost:8080/pocerp-1.0/rest/hello/message")
                    .request(MediaType.APPLICATION_JSON_TYPE)
                    .header("Authorization", "BEARER " + context.getTokenString())
                    .get(HelloResource.class);

            w.append("<br/>System: " + result.getSystem());
            w.append("<br/>Message: " + result.getMessage());
        }
        else {
            w.append("<br/>Nicht eingeloggt");
        }
        w.close();
    }
}
