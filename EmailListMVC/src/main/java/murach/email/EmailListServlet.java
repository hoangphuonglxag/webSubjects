package murach.email;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Calendar;
import java.util.List;
import javax.mail.MessagingException;

import murach.business.User;
import murach.data.UserDB;
import murach.util.SendEmailServlet;

public class EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/index.jsp";
        
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";
        }

        if (action.equals("join")) {
            url = "/index.jsp";
        } 
        else if (action.equals("add")) {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");

            User user = new User(email, firstName, lastName);
            String message;

            if (firstName == null || lastName == null || email == null ||
                firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()) {
                message = "Please fill out all three text boxes.";
                request.setAttribute("message", message);
                url = "/index.jsp";
            } else {
                message = "";
                url = "/thanks.jsp";

                // Ghi user vào file
                ServletContext sc = getServletContext();
                String path = sc.getRealPath(getServletConfig().getInitParameter("relativePathToFile"));
                UserDB.insert(user, path);

                // Đọc lại danh sách từ file
                List<User> users = UserDB.getAll(path);

                // Lưu user và danh sách vào request
                request.setAttribute("user", user);
                request.setAttribute("users", users);

                // --- Gửi mail cảm ơn ---
                String to = email;
                String from = "phuongdinhhoang18@gmail.com";  // Email gửi (phải hợp lệ)
                String subject = "Welcome to our email list";
                String body = "Dear " + firstName + ",\n\n"
                        + "Thanks for joining our email list. "
                        + "We'll make sure to send "
                        + "you announcements about new products "
                        + "and promotions.\n"
                        + "Have a great day and thanks again!\n\n"
                        + "Hoang Phuong's Web";
                boolean bodyIsHTML = false;

                try {
                    SendEmailServlet sendEmail = new SendEmailServlet();
                    sendEmail.sendMail(to, subject, body, bodyIsHTML);
                } catch (MessagingException e) {
                    // Log lỗi và thông báo người dùng
                    e.printStackTrace();
                    message = "ERROR: Unable to send email. Please check logs.";
                    request.setAttribute("message", message);
                    url = "/index.jsp";
                }
            }

            int year = Calendar.getInstance().get(Calendar.YEAR);
            request.setAttribute("currentYear", year);
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}