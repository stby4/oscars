package ch.fhnw.oop.oscar.command;

import ch.fhnw.oop.oscar.model.Movie;

/**
 * set movie title
 * Created by Hinrich on 12.06.2016.
 */
public class SetTitle extends MovieCommand<String> implements ICommand {

    public SetTitle(Movie movie, String oldTitle, String newTitle) {
        super(movie, oldTitle, newTitle);
        description.append("Changed title from ");
        description.append(oldTitle).append(" to ").append(newTitle).append(".");
    }

    @Override
    public void execute() {
        movie.setTitle(newValue);
    }

    @Override
    public void undo() {
        movie.setTitle(oldValue);
    }
}
