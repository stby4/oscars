package ch.fhnw.oop.oscar.command;

import ch.fhnw.oop.oscar.model.Movie;

/**
 * set genre
 * Created by Hinrich on 12.06.2016.
 */
public class SetGenre extends MovieCommand<String> {
    public SetGenre(Movie movie, String oldValue, String newValue) {
        super(movie, oldValue, newValue);

        description.append("Set Genre from ");
        description.append(oldValue).append(" to ").append(newValue).append(".");
    }

    @Override
    public void execute() {
        movie.setGenre(newValue);
    }

    @Override
    public void undo() {
        movie.setGenre(oldValue);
    }
}
