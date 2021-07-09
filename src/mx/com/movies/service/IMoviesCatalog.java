package mx.com.movies.service;

/* More useful for the user, The user is not really interested in how the
access to the data is given, that is why this interface is more aimed at the
business and the interaction with the user
*/
public interface IMoviesCatalog {
    
    public static final String RESOURCE_NAME = "movies.txt";
    
    public abstract void addMovie(String name);
    
    public abstract void toListMovie();
    
    public abstract void searchMovie(String search);
    
    public abstract void startMovieCatalog();
    
}
