package Servlets;

import Constants.SharedConstants;
import Service.AdminService;
import Service.AllServices;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminAddAuthorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("WEB-INF/AdminAddAuthor.jsp").forward(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String name = httpServletRequest.getParameter("authorName");
        AllServices allServices = (AllServices) getServletContext().getAttribute(SharedConstants.ATTRIBUTE);
        AdminService adminService = allServices.getAdminService();
        adminService.addAuthor(name);
        httpServletRequest.getRequestDispatcher("WEB-INF/AdminHomePage.jsp").forward(httpServletRequest, httpServletResponse);
    }
}
