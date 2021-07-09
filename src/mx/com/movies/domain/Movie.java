package mx.com.movies.domain;

public class Movie {

    private String name;

    public Movie() {
        this.name = name;
    }

    public Movie(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Movie: " + name;
    }

}
