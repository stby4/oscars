package ch.fhnw.oop.oscar.command;

import ch.fhnw.oop.oscar.model.Movie;

/**
 * old value
 * Created by Hinrich on 12.06.2016.
 */
public class SetNumberOscars extends MovieCommand<Integer> {
    public SetNumberOscars(Movie movie, Integer oldValue, Integer newValue) {
        super(movie, oldValue, newValue);

        description.append(String.format(STRINGS.getString("ChangedNumberOscars"), oldValue, newValue));
    }

    @Override
    public void execute() {
        movie.setNumberOscars(newValue);
    }

    @Override
    public void undo() {
        movie.setNumberOscars(oldValue);
    }
}
