package ch.fhnw.oop.oscar.view;

import ch.fhnw.oop.oscar.model.Movie;
import javafx.collections.ObservableList;

/**
 * OscarView
 * Created by Hinrich on 31.05.2016.
 */
public interface OscarView {
    void setMovies(ObservableList<Movie> movies);
}
