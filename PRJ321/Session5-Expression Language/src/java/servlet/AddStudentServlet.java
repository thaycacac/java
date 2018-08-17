package servlet;

import dal.StudentDAO;
import dataobj.Student;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thaycacac
 */
public class AddStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StudentDAO studentDAO = new StudentDAO();
        ArrayList<Student> listStudent = studentDAO.getAllStudent();
        
        int no = listStudent.size() + 1;
        String group = request.getParameter("group");
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        String status = request.getParameter("status");
        String comment = request.getParameter("comment");
        String taker = request.getParameter("taker");
        String time = request.getParameter("time");
        Student student = new Student(no, group, code, name, image, status,
                comment, taker, Date.valueOf(time));
        
        studentDAO.addStudent(student);
        //set session in servlet
//        HttpSession session = request.getSession();
//        session.setMaxInactiveInterval(0);
        request.getRequestDispatcher("ShowAllStudent.jsp").forward(request,response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
