package ch.fhnw.oop.oscar.model;

/**
 * Oscar model
 * Created by Hinrich on 31.05.2016.
 */
public interface OscarModel {
    /**
     * get movie by ID
     * @param id ID of the movie
     * @return Movie
     */
    Movie getMovie(int id);
}
