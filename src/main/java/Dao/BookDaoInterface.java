package Dao;

import Model.Book;
import Model.Genre;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface BookDaoInterface {
    /**
     *
     * @param name name of the book
     * @param description short description of the book
     * @param releaseYear year the book was released
     * @param authorID author's ID
     * @param rating book rating
     */
    public boolean AddBook(Book book, List<String> genres) throws SQLException;

    public List<Book> filterBooks(String name);

    /**
     *
     * @param bookID ID of the book
     * @return Book with bookID
     */
    public Book getBook(int bookID) throws SQLException;

    /**
     *
     * @param authorID author
     * @return List of author's books
     */
    public List<Book> getBookByAuthor(int authorID) throws SQLException;

    /**
     *
     * @param name name
     * @return List of books which name is like name
     */
    public List<Book> getBookByName(String name) throws SQLException;

    /**
     *
     * @param from from Year
     * @param to to Year
     * @return List of books which are released from from-year to to-year
     */
    public List<Book> getBookByYear(int from, int to) throws SQLException;

    /**
     *
     * @param genre Genre object
     * @return list of books with following genre
     */
    public List<Book> getBookByGenre(Genre genre) throws SQLException;
}