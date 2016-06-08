package ch.fhnw.oop.oscar.view;

import ch.fhnw.oop.oscar.model.Movie;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

/**
 * IOscarView
 * Created by Hinrich on 31.05.2016.
 */
public interface IOscarView {
    /**
     * inject movies
     * @param movies
     */
    void setMovies(ObservableList<Movie> movies);

    /**
     * sets movie for editing
     * @param movie
     */
    void onMovieSelected(Movie movie);
}
