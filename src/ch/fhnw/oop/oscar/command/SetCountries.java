package ch.fhnw.oop.oscar.command;

import ch.fhnw.oop.oscar.model.Movie;

/**
 * set countries
 * Created by Hinrich on 12.06.2016.
 */
public class SetCountries extends MovieCommand<String> {
    /**
     * @param movie the movie
     * @param oldValue old countries
     * @param newValue new countries
     */
    public SetCountries(Movie movie, String oldValue, String newValue) {
        super(movie, oldValue, newValue);
        description.append(String.format(STRINGS.getString("ChangedCountries"), oldValue, newValue));
    }

    @Override
    public void execute() {
        movie.setCountries(newValue);
    }

    @Override
    public void undo() {
        movie.setCountries(oldValue);
    }
}
