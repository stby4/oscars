package ch.fhnw.oop.oscar.command;

import ch.fhnw.oop.oscar.model.Movie;
import javafx.collections.ObservableList;

import java.util.ResourceBundle;

/**
 * Delete a movie
 * Created by hinri on 13.06.2016.
 */
public class DeleteMovie implements ICommand {
    private final ResourceBundle STRINGS = ResourceBundle.getBundle("view.javafx.Strings");
    private final ObservableList<Movie> movies;
    private final Movie movie;

    public DeleteMovie(ObservableList<Movie> movies, Movie movie) {
        this.movies = movies;
        this.movie = movie;
    }

    @Override
    public void execute() {
        movies.remove(movie);
    }

    @Override
    public void undo() {
        movies.add(movie);
    }

    @Override
    public String getDescription() {
        return String.format(STRINGS.getString("MovieDeleted"), movie.getTitle());
    }
}
