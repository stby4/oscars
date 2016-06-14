package ch.fhnw.oop.oscar.command;

import ch.fhnw.oop.oscar.model.Movie;

/**
 * set movie title
 * Created by Hinrich on 12.06.2016.
 */
public class SetTitle extends MovieCommand<String> {

    /**
     * @param movie    the movie
     * @param oldTitle old title
     * @param newTitle new title
     */
    public SetTitle(Movie movie, String oldTitle, String newTitle) {
        super(movie, oldTitle, newTitle);
        description.append(String.format(STRINGS.getString("ChangedTitle"), oldValue, newValue));
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
