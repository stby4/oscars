package ch.fhnw.oop.oscar.controller;

import ch.fhnw.oop.oscar.command.ICommand;
import ch.fhnw.oop.oscar.model.Movie;
import javafx.collections.ObservableList;

import java.time.LocalDate;

/**
 * execute/undo controller for oscar project
 * Created by Hinrich on 14.06.2016.
 */
public interface IOscarController {
    /**
     * execute command
     *
     * @param command the command
     */
    void execute(ICommand command);

    /**
     * execute number commands from undo list
     *
     * @param number number of commands to be executed
     */
    void execute(int number);

    /**
     * undo command
     *
     * @param command the command
     */
    void undo(ICommand command);

    /**
     * undo number of commands from execute list
     *
     * @param number number of commands to be undone
     */
    void undo(int number);

    /**
     * get execute list
     *
     * @return execute list
     */
    ObservableList<ICommand> getExecuteList();

    /**
     * get undo list
     *
     * @return undo list
     */
    ObservableList<ICommand> getUndoList();

    /**
     * add a new, empty movie
     *
     * @param movies list of movies where a new movie will be added
     */
    void addMovie(ObservableList<Movie> movies);

    void deleteMovie(ObservableList<Movie> movies, Movie movie);

    void setTitle(Movie movie, String oldTitle, String newTitle);

    void setYearAward(Movie movie, Integer oldYearAward, Integer newYearAward);

    void setActors(Movie movie, String oldActors, String newActors);

    void setDirector(Movie movie, String oldDirector, String newDirector);

    void setTitleEn(Movie movie, String oldTitleEn, String newTitleEn);

    void setYearProduction(Movie movie, Integer oldYear, Integer newYear);

    void setCountries(Movie movie, String oldCountries, String newCountries);

    void setDuration(Movie movie, Integer oldDuration, Integer newDuration);

    void setFsk(Movie movie, Movie.Fsk oldFsk, Movie.Fsk newFsk);

    void setGenre(Movie movie, String oldGenre, String newGenre);

    void setStartDate(Movie movie, LocalDate oldStartDate, LocalDate newStartDate);

    void setNumberOscars(Movie movie, Integer oldOscars, Integer newOscars);
}
