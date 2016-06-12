package ch.fhnw.oop.oscar.command;

import ch.fhnw.oop.oscar.model.Movie;

/**
 * set award year
 * Created by Hinrich on 12.06.2016.
 */
public class SetYearAward extends MovieCommand<Integer> implements ICommand {

    public SetYearAward(Movie movie, Integer oldYear, Integer newYear) {
        super(movie, oldYear, newYear);
        description.append("Changed award year from ");
        description.append(oldYear).append(" to ").append(newYear).append(".");
    }

    @Override
    public void execute() {
        movie.setYearAward(newValue);
    }

    @Override
    public void undo() {
        movie.setYearAward(oldValue);
    }
}
