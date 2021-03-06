package Dao;

import Model.Genre;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class GenreDao implements GenreDaoInterface{
    Connection connection;

    public GenreDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean addGenre(Genre genre) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("insert into genres(genre_name) values(?);");
        statement.setString(1, genre.getGenre_name());
        return statement.executeUpdate() != 0;
    }

    private Genre getGenreByRS(ResultSet rs) throws SQLException {
        Genre res = new Genre();
        res.setGenre_id(rs.getInt(1));
        res.setGenre_name(rs.getString(2));
        return res;
    }

    @Override
    public Genre getGenreById(int id) throws SQLException {
        PreparedStatement statement;
        statement = connection.prepareStatement("select * from genres where genre_id = ?;");
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        if(!rs.next()) return null;
        return getGenreByRS(rs);
    }

    @Override
    public List<String> getAllGenres() throws SQLException {
        PreparedStatement statement;
        List<String> genreList = new ArrayList<>();
        statement = connection.prepareStatement("select * from genres;");
        ResultSet rs = statement.executeQuery();
        while(rs.next()){
            genreList.add((rs.getString(2)));
        }
        return genreList;
    }
}
