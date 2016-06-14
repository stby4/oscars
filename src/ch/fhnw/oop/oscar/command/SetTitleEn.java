package ch.fhnw.oop.oscar.command;

import ch.fhnw.oop.oscar.model.Movie;

/**
 * set movie title EN
 * Created by Hinrich on 12.06.2016.
 */
public class SetTitleEn extends MovieCommand<String> implements ICommand {

    /**
     * @param movie    the movie
     * @param oldTitle old english title
     * @param newTitle new english title
     */
    public SetTitleEn(Movie movie, String oldTitle, String newTitle) {
        super(movie, oldTitle, newTitle);

        description.append(String.format(STRINGS.getString("ChangedTitleEn"), oldValue, newValue));
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
