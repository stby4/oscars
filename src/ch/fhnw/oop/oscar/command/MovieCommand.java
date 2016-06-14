package ch.fhnw.oop.oscar.command;

import ch.fhnw.oop.oscar.model.Movie;

import java.util.ResourceBundle;

/**
 * abstract command for movie operations
 * Created by Hinrich on 12.06.2016.
 */
public abstract class MovieCommand<T> implements ICommand {
    protected final ResourceBundle STRINGS = ResourceBundle.getBundle("view.javafx.Strings");
    protected final StringBuilder description = new StringBuilder();
    protected final Movie movie;
    protected final T oldValue;
    protected final T newValue;

    public MovieCommand(Movie movie, T oldValue, T newValue) {
        this.movie = movie;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    @Override
    public String getDescription() {
        return description.toString();
    }
}