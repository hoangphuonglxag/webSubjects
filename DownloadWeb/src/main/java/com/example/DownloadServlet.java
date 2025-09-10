package com.example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DownloadServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "viewAlbums";  // default action
        }

        String url = "/index.jsp";
        if (action.equals("viewAlbums")) {
            url = "/index.jsp";
        } else if (action.equals("checkUser")) {
            url = checkUser(request, response);
        } else if (action.equals("viewCookies")) {
            url = "/view_cookies.jsp";
        } else if (action.equals("deleteCookies")) {
            url = deleteCookies(request, response);
        }

        // forward to the view
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {

        String action = request.getParameter("action");

        // perform action and set URL to appropriate page
        String url = "/index.jsp";
        if ("registerUser".equals(action)) {
            url = registerUser(request, response);
        }

        // forward to the view
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    private String checkUser(HttpServletRequest request,
            HttpServletResponse response) {

        String productCode = request.getParameter("productCode");
        HttpSession session = request.getSession();

        ServletContext sc = getServletContext();
        String productPath = sc.getRealPath("/WEB-INF/products.txt");
        Product product = ProductIO.getProduct(productCode, productPath);

        // Lưu product và productCode vào session để sử dụng khi đăng ký
        session.setAttribute("product", product);
        session.setAttribute("productCode", productCode);

        User user = (User) session.getAttribute("user");

        String url;
        if (user == null) {
            Cookie[] cookies = request.getCookies();
            String emailAddress = CookieUtil.getCookieValue(cookies, "emailCookie");
            if (emailAddress == null || emailAddress.equals("")) {
                url = "/register.jsp";  // chưa có user, chuyển sang trang đăng ký
            } else {
                String path = sc.getRealPath("/WEB-INF/EmailList.txt");
                user = UserIO.getUser(emailAddress, path);
                session.setAttribute("user", user);
                url = "/" + productCode + "_download.jsp";
            }
        } else {
            url = "/" + productCode + "_download.jsp";
        }
        return url;
    }

    private String registerUser(HttpServletRequest request,
            HttpServletResponse response) {

        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        User user = new User();
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);

        ServletContext sc = getServletContext();
        String path = sc.getRealPath("/WEB-INF/EmailList.txt");
        UserIO.add(user, path);

        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        Cookie c1 = new Cookie("emailCookie", email);
        c1.setMaxAge(60 * 60 * 24 * 365 * 3);
        c1.setPath("/");
        response.addCookie(c1);

        Cookie c2 = new Cookie("firstNameCookie", firstName);
        c2.setMaxAge(60 * 60 * 24 * 365 * 2);
        c2.setPath("/");
        response.addCookie(c2);

        // Lấy productCode từ session, KHÔNG lấy product object trực tiếp
        String productCode = (String) session.getAttribute("productCode");

        // Nếu productCode null (để tránh lỗi), có thể chuyển về index hoặc xử lý lỗi
        if (productCode == null) {
            return "/index.jsp";
        }

        String url = "/" + productCode + "_download.jsp";

        return url;
    }

    private String deleteCookies(HttpServletRequest request,
            HttpServletResponse response) {

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.setMaxAge(0); //delete the cookie
                cookie.setPath("/"); //allow the download application to access it
                response.addCookie(cookie);
            }
        }
        String url = "/delete_cookies.jsp";
        return url;
    }
}