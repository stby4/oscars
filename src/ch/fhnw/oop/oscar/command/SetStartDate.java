package ch.fhnw.oop.oscar.command;

import ch.fhnw.oop.oscar.model.Movie;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * set start date
 * Created by Hinrich on 12.06.2016.
 */
public class SetStartDate extends MovieCommand<LocalDate> {
    public SetStartDate(Movie movie, LocalDate oldValue, LocalDate newValue) {
        super(movie, oldValue, newValue);
        DateTimeFormatter fmt = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);

        description.append(String.format(STRINGS.getString("ChangedStartDate"), (null == oldValue ? "-" : fmt.format(oldValue)), fmt.format(newValue)));
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
