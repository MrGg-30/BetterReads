package Dao;

import Model.Book;
import Model.User;


import java.util.List;

public interface AdminDaoInterface {

    /**
     * gets all admins
     * @return
     */
    public List<User> getAllAdmins();

    /**
     * @param user
     * @return true if given user is admin
     */
    public boolean isAdmin(User user);

    /**
     * add book to database
     * @param book
     * @return true if add was successful.
     */
    public boolean addBook(Book book,String[] genres);

}
