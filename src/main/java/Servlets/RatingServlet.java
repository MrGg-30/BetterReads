package Servlets;

import Constants.SharedConstants;
import Model.Book;
import Model.User;
import Service.AllServices;
import Service.RatingService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class RatingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        super.doGet(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        AllServices allServices = (AllServices) getServletContext().getAttribute(SharedConstants.ATTRIBUTE);
        RatingService ratingService = allServices.getRatingService();
        HttpSession httpSession = httpServletRequest.getSession();
        User user = (User) httpSession.getAttribute(SharedConstants.SESSION_ATTRIBUTE);
        int rating = Integer.parseInt(httpServletRequest.getParameter("rating"));
        ratingService.rateBook(user.getUser_id(), Integer.parseInt(httpServletRequest.getParameter("book_id")), rating);
        Book b = null;
        try {
            b = allServices.getBookService().getBookById(Integer.parseInt(httpServletRequest.getParameter("book_id")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        httpServletRequest.setAttribute("bookID", b.getBook_id());
        httpServletRequest.setAttribute("bookName", b.getBook_name());
        httpServletRequest.setAttribute("authorId", b.getAuthor_id());
        httpServletRequest.setAttribute("description", b.getBook_description());
        httpServletRequest.setAttribute("rating", b.getBook_rating());
        httpServletRequest.setAttribute("count",b.getAvailable_count());
        httpServletRequest.setAttribute("year", b.getRelease_year());  httpServletRequest.getRequestDispatcher("WEB-INF/BookPage.jsp")
                .forward(httpServletRequest,httpServletResponse);
    }
}