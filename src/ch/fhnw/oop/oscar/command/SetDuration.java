package ch.fhnw.oop.oscar.command;

import ch.fhnw.oop.oscar.model.Movie;

/**
 * change duration
 * Created by Hinrich on 12.06.2016.
 */
public class SetDuration extends MovieCommand<Integer> {
    /**
     * @param movie the movie
     * @param oldValue old duration
     * @param newValue new duration
     */
    public SetDuration(Movie movie, Integer oldValue, Integer newValue) {
        super(movie, oldValue, newValue);
        description.append(String.format(STRINGS.getString("ChangedDuration"), oldValue, newValue));
    }

    @Override
    public void execute() {
        movie.setDuration(newValue);
    }

    @Override
    public void undo() {
        movie.setDuration(oldValue);
    }
}
