package ch.fhnw.oop.oscar.command;

import ch.fhnw.oop.oscar.model.Movie;

/**
 * set movie title
 * Created by Hinrich on 12.06.2016.
 */
public class SetDirector extends MovieCommand<String> {

    public SetDirector(Movie movie, String oldDirector, String newDirector) {
        super(movie, oldDirector, newDirector);
        description.append(String.format(STRINGS.getString("ChangedDirector"), oldValue, newValue));
    }

    @Override
    public void execute() {
        movie.setDirector(newValue);
    }

    @Override
    public void undo() {
        movie.setDirector(oldValue);
    }
}
