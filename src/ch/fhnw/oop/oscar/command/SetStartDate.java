package ch.fhnw.oop.oscar.command;

import ch.fhnw.oop.oscar.model.Movie;

import java.time.LocalDate;

/**
 * set start date
 * Created by Hinrich on 12.06.2016.
 */
public class SetStartDate extends MovieCommand<LocalDate> {
    public SetStartDate(Movie movie, LocalDate oldValue, LocalDate newValue) {
        super(movie, oldValue, newValue);

        description.append("Changed start date from ").append(oldValue).append(" to ").append(newValue).append(".");
    }

    @Override
    public void execute() {
        movie.setStartDate(newValue);
    }

    @Override
    public void undo() {
        movie.setStartDate(oldValue);
    }
}
