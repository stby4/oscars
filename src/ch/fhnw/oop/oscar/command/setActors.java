package ch.fhnw.oop.oscar.command;

import ch.fhnw.oop.oscar.model.IModel;
import ch.fhnw.oop.oscar.model.Movie;

/**
 * set actors
 * Created by Hinrich on 12.06.2016.
 */
public class SetActors extends MovieCommand<String> implements ICommand {

    public SetActors(Movie movie, String oldActors, String newActors) {
        super(movie, oldActors, newActors);
        description.append("Changed Actors from ");
        description.append(oldActors).append(" to ").append(newActors).append(".");
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
