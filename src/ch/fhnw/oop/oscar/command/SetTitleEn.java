package ch.fhnw.oop.oscar.command;

import ch.fhnw.oop.oscar.model.Movie;

/**
 * set movie title
 * Created by Hinrich on 12.06.2016.
 */
public class SetTitleEn extends MovieCommand<String> implements ICommand {

    public SetTitleEn(Movie movie, String oldTitle, String newTitle) {
        super(movie, oldTitle, newTitle);
        description.append("Changed english title from ");
        description.append(oldTitle).append(" to ").append(newTitle).append(".");
    }

    @Override
    public void execute() {
        movie.setTitleEn(newValue);
    }

    @Override
    public void undo() {
        movie.setTitleEn(oldValue);
    }
}
