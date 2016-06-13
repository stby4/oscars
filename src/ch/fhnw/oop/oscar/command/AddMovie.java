package ch.fhnw.oop.oscar.command;

import ch.fhnw.oop.oscar.model.Movie;
import javafx.collections.ObservableList;

import java.util.ResourceBundle;

/**
 * add a new, empty
 * Created by hinri on 13.06.2016.
 */
public class AddMovie implements ICommand {
    private final ResourceBundle STRINGS = ResourceBundle.getBundle("view.javafx.Strings");
    private final ObservableList<Movie> movies;
    private final Movie movie;

    public AddMovie(ObservableList<Movie> movies) {
        this.movies = movies;

        // find highest ID
        int id = 0;
        for (Movie m : movies) {
            if (m.getId() > id) {
                id = m.getId();
            }
        }
        id++;
        if (83 > id) {
            id = 83;
        }

        movie = new Movie(id);
    }

    @Override
    public void execute() {
        movies.add(movie);
    }

    @Override
    public void undo() {
        movies.remove(movie);
    }

    @Override
    public String getDescription() {
        return STRINGS.getString("NewMovieAdded");
    }
}
