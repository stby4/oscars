package ch.fhnw.oop.oscar.command;

import ch.fhnw.oop.oscar.model.Movie;

import java.util.ResourceBundle;

/**
 * set actors
 * Created by Hinrich on 12.06.2016.
 */
public class SetActors extends MovieCommand<String> {
    /**
     * @param movie the movie
     * @param oldActors old actors
     * @param newActors new actors
     */
    public SetActors(Movie movie, String oldActors, String newActors) {
        super(movie, oldActors, newActors);
        description.append(String.format(STRINGS.getString("ChangedActors"), oldActors, newActors));
    }

    @Override
    public void execute() {
        movie.setActors(newValue);
    }

    @Override
    public void undo() {
        movie.setActors(oldValue);
    }
}
