package net.moewes.projectB.poc.erpmock;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

@WebServlet(urlPatterns = "/work")
public class WorkServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doGet(req, resp);

        Logger log = Logger.getLogger("Work Servlet"); // TODO: Inject zentralen Logger

        log.info("werde aufgerufen");

        System.out.println("Out: Work werde aufgerufen!");

       PrintWriter w = resp.getWriter() ;

       w.append("Hier ist das WorkServlet");

       w.close();
    }
}
