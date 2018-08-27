package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thaycacac
 */
public class ShowHeaderFieldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        pw.println("<html><head></head><body>");
        Enumeration<String> headerNames = request.getHeaderNames();
        pw.print("<p>Hello</p>");
        pw.print("<br>");
        while (headerNames.hasMoreElements()) {
            String headerName = (String) headerNames.nextElement();
            pw.print(headerName + " <br>");
            String headerFieldValue = request.getHeader(headerName);
            pw.println(headerFieldValue);
        }
        pw.println("</body></html>");
    }

    @Override
    public String getServletInfo() {
        return "Get Header Fields HTTP request";
    }// </editor-fold>

}
