package ch.fhnw.oop.oscar.command;

import ch.fhnw.oop.oscar.model.Movie;

/**
 * change duration
 * Created by Hinrich on 12.06.2016.
 */
public class SetDuration extends MovieCommand<Integer> {
    public SetDuration(Movie movie, Integer oldValue, Integer newValue) {
        super(movie, oldValue, newValue);
        description.append("Changed duration from ");
        description.append(oldValue).append(" to ").append(newValue).append(".");
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
