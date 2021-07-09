package mx.com.movies.presentation;

/*
Here we wont work at low level with data cape, we are going to work with the
business cape, that's an advantage of the use of different capes.
 */
import java.util.Scanner;
import mx.com.movies.service.IMoviesCatalog;
import mx.com.movies.service.MoviesCatalogImpl;

public class MoviesCatalogPresentation {

    public static void main(String[] args) {

        var option = -1;
        var console = new Scanner(System.in);
        IMoviesCatalog catalog = new MoviesCatalogImpl();

        while (option != 0) {
            System.out.println("Choose an option: \n" + "1. Start movies catalog.\n"
                    + "2. Add movie.\n" + "3. List movies.\n" + "4. Search movie.\n"
                    + "0. Leave.");

            option = Integer.parseInt(console.nextLine());

            switch (option) {
                case 1:
                    catalog.startMovieCatalog();
                    System.out.println("Movies catalog has been started.");
                    break;

                case 2:
                    System.out.println("Write the name of the movie: ");
                    String movieName = console.nextLine();
                    catalog.addMovie(movieName);
                    break;

                case 3:
                    catalog.toListMovie();
                    break;

                case 4:
                    System.out.println("Write the name of the movie that you want to search: ");
                    String searchName = console.nextLine();
                    catalog.searchMovie(searchName);
                    break;

                case 0:
                    System.out.println("You have left.");
                    break;

                default:
                    System.out.println("Unrecognized option, try again.");
                    break;
            }
        }
    }

}
