package ch.fhnw.oop.oscar.command;

import ch.fhnw.oop.oscar.model.Movie;

/**
 * set fsk
 * Created by Hinrich on 12.06.2016.
 */
public class SetFsk extends MovieCommand<Movie.Fsk> {
    /**
     * @param movie the movie
     * @param oldValue old fsk
     * @param newValue new fsk
     */
    public SetFsk(Movie movie, Movie.Fsk oldValue, Movie.Fsk newValue) {
        super(movie, oldValue, newValue);
        description.append(String.format(STRINGS.getString("ChangedFsk"), oldValue, newValue));
    }

    @Override
    public void execute() {
        movie.setFsk(newValue);
    }

    @Override
    public void undo() {
        movie.setFsk(oldValue);
    }
}
