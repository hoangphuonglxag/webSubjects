package com.example;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/survey")
public class SurveyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("firstName", request.getParameter("firstName"));
        request.setAttribute("lastName", request.getParameter("lastName"));
        request.setAttribute("email", request.getParameter("email"));
        request.setAttribute("dob", request.getParameter("dob"));
        request.setAttribute("heardFrom", request.getParameter("heardFrom"));
        request.setAttribute("wantsUpdates", request.getParameter("wantsUpdates"));
        request.setAttribute("contactVia", request.getParameter("contactVia"));
        request.setAttribute("agreeEmailContact", request.getParameter("agreeEmailContact"));

        RequestDispatcher dispatcher = request.getRequestDispatcher("survey.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.getWriter().println(":>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.");
    }
}