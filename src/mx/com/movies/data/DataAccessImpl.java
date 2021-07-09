package mx.com.movies.data;

import java.io.*;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
import java.util.*;
//import java.util.ArrayList;
//import java.util.List;
import mx.com.movies.domain.Movie;
import mx.com.movies.exceptions.*;
//import mx.com.movies.exceptions.DataAccessEx;
//import mx.com.movies.exceptions.DataReadingException;
//import mx.com.movies.exceptions.DataWritingException;

public class DataAccessImpl implements IDataAccess {

    @Override
    public boolean exists(String name) {
        File file = new File(name);
        return file.exists();
    }

    @Override
    public List<Movie> toList(String name) throws DataReadingException {
        List<Movie> movieList = new ArrayList<>();

        File file = new File(name);
        try {
            var in = new BufferedReader(new FileReader(file));
            var read = in.readLine();

            while (read != null) {
                Movie movie = new Movie(read);
                movieList.add(movie);
                read = in.readLine();
            }

            in.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new DataReadingException("Error listing movies:" + ex.getMessage()); //propagate the error.
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new DataReadingException("Error listing movies:" + ex.getMessage()); //propagate the error.
        }

        return movieList;
    }

    @Override
    public void write(Movie movie, String name, boolean add) throws DataWritingException {
        File file = new File(name);

        try {
            var out = new PrintWriter(new FileWriter(file, add)); // boolean add says if  we need to override or add.
            out.println(movie.getName());
            out.close();
            System.out.println("Information has been written into the file.");
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new DataWritingException("Error writing the file: " + ex.getMessage());
        }
    }

    @Override
    public String search(String name, String search) throws DataReadingException {

        String message = null;
        int line = 1;
        File file = new File(name);

        try {
            var in = new BufferedReader(new FileReader(file));
            var read = in.readLine();

            while (read != null) {
//                line++;
//                movieList.add(read);
                if (search != null && search.equalsIgnoreCase(read)) {
                    message = "Movie " + search + " is in the file, line: " + line;
                    break;
                }

                line++;
                read = in.readLine();
            }

            in.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new DataReadingException("Error searching movies:" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new DataReadingException("Error searching movies:" + ex.getMessage());
        }

        return message;

//        List<String> movieList = new ArrayList<>();
//        for (int i = 0; i < movieList.size(); i++) {
//            if (movieList.get(i) == search) {
//                message = "Movie " + search + " is in the file, line: " + i;
//                break;
//            } else {
//                message = "Movie" + search + " is not in the file.";
//            }
//        }    
//        
//        return message;
    }

    @Override
    public void create(String name) throws DataAccessEx {
        File file = new File(name);

        try {
            var out = new PrintWriter(new FileWriter(file));
            out.close();
            System.out.println("File has been created.");
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new DataAccessEx("Error creating the file: " + ex.getMessage());
        }

    }

    @Override
    public void delete(String name) {
        File file = new File(name);

        if (file.exists()) {
            file.delete();
            System.out.println("File " + name + "has been deleated.");
        }
    }

}
