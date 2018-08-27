package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thaycacac
 */
@WebServlet(name = "FapServlet", urlPatterns = {"/FapServlet"})
public class FapServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        pw.println("<html>\n"
                + "<head>\n"
                + "    <style>\n"
                + "		.myTitle {\n"
                + "			font-size: 30px;\n"
                + "			font-weight: bold;\n"
                + "		  }\n"
                + "\n"
                + "		  .mySpan {\n"
                + "			font-weight: bold;\n"
                + "		  }\n"
                + "\n"
                + "		  .myTable {\n"
                + "			margin: 0 auto;\n"
                + "			display: flex;\n"
                + "		  }\n"
                + "		  .myTableField {\n"
                + "			text-transform: uppercase;\n"
                + "			margin: 0 auto;\n"
                + "			display: flex;\n"
                + "		  }\n"
                + "		  .myItemField {\n"
                + "			background: #6b90da;\n"
                + "			margin: 1px;\n"
                + "			color: black;\n"
                + "			height: 30px;\n"
                + "			text-align: left;\n"
                + "			line-height: 30px;\n"
                + "			width: 1000px;\n"
                + "		  }\n"
                + "		  .myItem {\n"
                + "			margin: 1px;\n"
                + "			font-size: 16px;\n"
                + "			text-align: left;\n"
                + "			width: 1000px;\n"
                + "		  }\n"
                + "		  .myCode {\n"
                + "			color: #5c58f1;\n"
                + "		  }\n"
                + "		  .absent {\n"
                + "			color: red;\n"
                + "		  }\n"
                + "		  .present{\n"
                + "			color: green;\n"
                + "		  }\n"
                + "		  .container {\n"
                + "			width: 95%;\n"
                + "			margin: 0 auto;\n"
                + "		  }\n"
                + "		  a:link {\n"
                + "			color: blue;\n"
                + "			text-decoration: none;\n"
                + "		}\n"
                + "	</style>\n"
                + "</head>\n"
                + "<body>\n"
                + "    <div class=\"container\">\n"
                + "        <p class=\"myTitle\">Single activity Attendance</p>\n"
                + "        <br>\n"
                + "        <a href=\"#\" class=\"myCode\">Edit this Attendance</a>\n"
                + "        <p>Attendance for\n"
                + "            <span class=\"mySpan\">PRJ321</span> with leacturer\n"
                + "            <span class=\"mySpan\">Duong TB</span>\n"
                + "            at slot 4 on Monday 13/08/2018, in room HB/305L at FU-HL</p>\n"
                + "        <div class=\"myTableField\">\n"
                + "            <div class=\"myItemField\">No</div>\n"
                + "            <div class=\"myItemField\">Group</div>\n"
                + "            <div class=\"myItemField\">Code</div>\n"
                + "            <div class=\"myItemField\">Name</div>\n"
                + "            <div class=\"myItemField\">Image</div>\n"
                + "            <div class=\"myItemField\">Status</div>\n"
                + "            <div class=\"myItemField\">Comment</div>\n"
                + "            <div class=\"myItemField\">Taker</div>\n"
                + "            <div class=\"myItemField\">Record Time</div>\n"
                + "        </div>\n"
                + "        <div class=\"myTable\">\n"
                + "            <div class=\"myItem myNo\">1</div>\n"
                + "            <div class=\"myItem\">\n"
                + "                <a href=\"#\">PRJ321.E-B5</a>\n"
                + "            </div>\n"
                + "            <div class=\"myItem myCode\">SE03335</div>\n"
                + "            <div class=\"myItem\">\n"
                + "                <a href=\"#\">Cao Bá Khánh Linh</a>\n"
                + "            </div>\n"
                + "            <div class=\"myItem\">\n"
                + "                <img src=\"1.PNG\" alt=\"\">\n"
                + "            </div>\n"
                + "            <div class=\"myItem absent\">Absent</div>\n"
                + "            <div class=\"myItem\"></div>\n"
                + "            <div class=\"myItem myCode\">duongtb</div>\n"
                + "            <div class=\"myItem\">8/13/2018 12:57:00PM</div>\n"
                + "        </div>\n"
                + "        <div class=\"myTable\">\n"
                + "            <div class=\"myItem\">1</div>\n"
                + "            <div class=\"myItem\">\n"
                + "                <a href=\"#\">PRJ321.E-B5</a>\n"
                + "            </div>\n"
                + "            <div class=\"myItem myCode\">SE03555</div>\n"
                + "            <div class=\"myItem\">\n"
                + "                <a href=\"#\">Phan Lâm</a>\n"
                + "            </div>\n"
                + "            <div class=\"myItem\">\n"
                + "                <img src=\"2.PNG\" alt=\"\">\n"
                + "            </div>\n"
                + "            <div class=\"myItem present\">Absent</div>\n"
                + "            <div class=\"myItem\"></div>\n"
                + "            <div class=\"myItem myCode\">duongtb</div>\n"
                + "            <div class=\"myItem\">8/13/2018 12:57:00PM</div>\n"
                + "        </div>\n"
                + "        <div class=\"myTable\">\n"
                + "            <div class=\"myItem\">1</div>\n"
                + "            <div class=\"myItem\">\n"
                + "                <a href=\"#\">PRJ321.E-B5</a>\n"
                + "            </div>\n"
                + "            <div class=\"myItem myCode\">SE03810</div>\n"
                + "            <div class=\"myItem\">\n"
                + "                <a href=\"#\">Nguyen Minh Hieu</a>\n"
                + "            </div>\n"
                + "            <div class=\"myItem\">\n"
                + "                <img src=\"3.PNG\" alt=\"\">\n"
                + "            </div>\n"
                + "            <div class=\"myItem present\">Absent</div>\n"
                + "            <div class=\"myItem\"></div>\n"
                + "            <div class=\"myItem myCode\">duongtb</div>\n"
                + "            <div class=\"myItem\">8/13/2018 12:57:00PM</div>\n"
                + "        </div>\n"
                + "    </div>\n"
                + "</body>\n"
                + "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
