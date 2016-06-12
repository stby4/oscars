package ch.fhnw.oop.oscar.command;

import ch.fhnw.oop.oscar.model.Movie;

/**
 * set fsk
 * Created by Hinrich on 12.06.2016.
 */
public class SetFsk extends MovieCommand<Integer> {
    public SetFsk(Movie movie, Integer oldValue, Integer newValue) {
        super(movie, oldValue, newValue);

        description.append("Set FSK from ").append(oldValue).append(" to ").append(newValue).append(".");
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