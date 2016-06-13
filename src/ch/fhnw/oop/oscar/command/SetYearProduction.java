package ch.fhnw.oop.oscar.command;

import ch.fhnw.oop.oscar.model.Movie;

/**
 * set production year
 * Created by Hinrich on 12.06.2016.
 */
public class SetYearProduction extends MovieCommand<Integer> {
    public SetYearProduction(Movie movie, Integer oldValue, Integer newValue) {
        super(movie, oldValue, newValue);
        description.append("Changed production year from ");
        description.append(oldValue).append(" to ").append(newValue);
    }

    @Override
    public void execute() {
        movie.setYearProduction(newValue);
    }

    @Override
    public void undo() {
        movie.setYearProduction(oldValue);
    }
}