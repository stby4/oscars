package ch.fhnw.oop.oscar.model;

import javafx.collections.ObservableList;

/**
 * Oscar model
 * Created by Hinrich on 31.05.2016.
 */
public interface OscarModel {
    /**
     * get movies
     * @return movies
     */
    ObservableList<Movie> getMovies();
}
