package murach.util;

import java.io.IOException;
import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.Properties;

@WebServlet("/sendEmail")
public class SendEmailServlet extends HttpServlet {

    // Thông tin tài khoản Gmail và mật khẩu ứng dụng (App Password)
    private final String username = "phuongdinhhoang18@gmail.com";
    private final String appPassword = "cvlfweweoseibksk";  // Thay bằng mật khẩu ứng dụng thật

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String to = request.getParameter("to");
        String subject = request.getParameter("subject");
        String body = request.getParameter("body");
        boolean isHtml = "true".equalsIgnoreCase(request.getParameter("isHtml"));

        try {
            sendMail(to, subject, body, isHtml);
            response.getWriter().println("Email sent successfully to " + to);
        } catch (MessagingException e) {
            e.printStackTrace();
            response.getWriter().println("Failed to send email: " + e.getMessage());
        }
    }

    /**
     * Gửi email.
     * @param to Địa chỉ nhận email
     * @param subject Tiêu đề email
     * @param body Nội dung email
     * @param bodyIsHTML true nếu nội dung là HTML, false nếu thuần text
     * @throws MessagingException
     */
    public void sendMail(String to, String subject, String body, boolean bodyIsHTML)
            throws MessagingException {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");  // Bật STARTTLS
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Tạo session với thông tin xác thực
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, appPassword);
            }
        });

        session.setDebug(true); // Bật debug chi tiết (dùng để check lỗi)

        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(username));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        msg.setSubject(subject);
        if (bodyIsHTML) {
            msg.setContent(body, "text/html; charset=utf-8");
        } else {
            msg.setText(body);
        }

        Transport.send(msg);
    }
}