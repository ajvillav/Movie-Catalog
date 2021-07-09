package mx.com.movies.data;

import java.util.List;
import mx.com.movies.domain.Movie;
import mx.com.movies.exceptions.*;
//import mx.com.movies.exceptions.DataAccessEx;
//import mx.com.movies.exceptions.DataReadingException;
//import mx.com.movies.exceptions.DataWritingException;

public interface IDataAccess {

    public abstract boolean exists(String name) throws DataAccessEx;

//    Interfaces methods have no body.
//    This method validate if the file exists.
//    Could throw an exception.
    public abstract List<Movie> toList(String name) throws DataReadingException;

//    This method returns a list with the movies in the file.
    public abstract void write(Movie movie, String name, boolean add) throws DataWritingException;

//    This method write into the file and asks if we should override or add.
    public abstract String search(String name, String search) throws DataReadingException;

//    This method search into the file and says if the movie exist and the line where it is.
    public abstract void create(String name) throws DataAccessEx;

//    This method creates an file.
    public abstract void delete(String name) throws DataAccessEx;

//    This method deleate a movie from the file.
}
