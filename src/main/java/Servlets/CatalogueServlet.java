package Servlets;

import Constants.SharedConstants;
import Model.Book;
import Model.Genre;
import Service.AllServices;
import Service.BookService;
import Service.GenreService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CatalogueServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AllServices allServices = (AllServices) getServletContext().getAttribute(SharedConstants.ATTRIBUTE);
        GenreService genreService = allServices.getGenreService();
        List<String> genres = genreService.getGenres();
        request.setAttribute("genres", genres);
        System.out.println(genres);
        request.getRequestDispatcher("WEB-INF/Catalogue.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AllServices allServices = (AllServices) getServletContext().getAttribute(SharedConstants.ATTRIBUTE);
        BookService bs = allServices.getBookService();
        String yearSort = request.getParameter("booksYear");
        String ratingSort = request.getParameter("bookRating");
        List<Book> list = bs.getAllBooks();

        if (request.getParameter("action") != null){
            list = bs.removeUnavailableBooks(list);
        }

        if(yearSort != null) {
            if (yearSort.equals("old to new")) {
                list = bs.oldToNew(bs.getAllBooks());
            } else if (yearSort.equals("new to old")) {
                list = bs.newToOld(bs.getAllBooks());
            }
        } else {
            if (ratingSort != null) {
                if (ratingSort.equals("High -> Low")) {
                    list = bs.getBestBooks(1, list.size() - 1);
                } else if (ratingSort.equals("Low -> High")) {
                    list = bs.getBestBooks(1, list.size() - 1);
                    list = bs.getLowRatingBooks(1, list.size() - 1);
                }
            }
        }
        if (request.getParameter("GenreFilter") != null){
            String[] names = request.getParameterValues("genres");
            list = bs.getBooksByGanres(names);
        }
        request.setAttribute("list", list);

        GenreService genreService = allServices.getGenreService();
        List<String> genres = genreService.getGenres();
        request.setAttribute("genres", genres);

        request.getRequestDispatcher("WEB-INF/Catalogue.jsp").forward(request,response);
    }
}
