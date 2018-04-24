package lv.myProject.java2.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlets extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {

        /*req.getRequestDispatcher("servlets/hello.jsp").forward(req, resp);*/

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("web/index.html");
        requestDispatcher.forward(req, resp);

       /* String param1 = req.getParameter("param1");*/

        /*HttpSession session = req.getSession();
        session.setAttribute("ĀttrName", 1L);*/

        // Set response content type
        resp.setContentType("text/html");

        // Prepare output html
        /*PrintWriter out = resp.getWriter();
        out.println("<h1>" + "LABRIT!" + "</h1>");
        out.println("<h1>" + "Hello WWW world from Java!" + "</h1>");

        out.println("<h1>" + "Param 1 = " + param1 + "</h1>");
*/
    }

}
