package mx.com.movies.service;

import mx.com.movies.data.DataAccessImpl;
import mx.com.movies.data.IDataAccess;
import mx.com.movies.domain.Movie;
import mx.com.movies.exceptions.DataAccessEx;

public class MoviesCatalogImpl implements IMoviesCatalog {

    private final IDataAccess data; //May be many implements of the same interphase, then its a good practice to
    //define the variable with the interphase and in the moment of the object creation specify the implementation.

    public MoviesCatalogImpl() {
        this.data = new DataAccessImpl(); //Now we have access to the methods defined in the interphase.
    }

    @Override
    public void addMovie(String movieName) {
        var movie = new Movie(movieName);
        boolean add = false;
        try {
            add = this.data.exists(RESOURCE_NAME);
            data.write(movie, RESOURCE_NAME, add);
        } catch (DataAccessEx ex) {
            System.out.println("There has been an error with the data access:");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void toListMovie() {
        try {
            var movies = this.data.toList(RESOURCE_NAME);
            for (Movie movie : movies) {
                System.out.println(movie);
            }
        } catch (DataAccessEx ex) {
            System.out.println("There has been an error with the data access:");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void searchMovie(String search) {
        String result = null;

        try {
            result = data.search(RESOURCE_NAME, search);
        } catch (DataAccessEx ex) {
            System.out.println("There has been an error with the data access:");
            ex.printStackTrace(System.out);
        }

        System.out.println(result);
    }

    @Override
    public void startMovieCatalog() {
        try {
            if (this.data.exists(RESOURCE_NAME)) {
                data.delete(RESOURCE_NAME);
                data.create(RESOURCE_NAME);
            } else {
                data.create(RESOURCE_NAME);
            }
        } catch (DataAccessEx ex) {
            System.out.println("There has been an error with the data access:");
            ex.printStackTrace(System.out);
        }
    }

}
