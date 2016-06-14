package ch.fhnw.oop.oscar.controller;

import ch.fhnw.oop.oscar.command.*;
import ch.fhnw.oop.oscar.model.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

/**
 * execute/undo controller for oscar project
 * Created by Hinrich on 12.06.2016.
 */
public class OscarController implements IOscarController {
    private final ObservableList<ICommand> executeList = FXCollections.observableArrayList();
    private final ObservableList<ICommand> undoList = FXCollections.observableArrayList();

    @Override
    public void execute(ICommand command) {
        command.execute();
        executeList.add(command);
        undoList.clear();
    }

    @Override
    public void execute(int number) {
        for (int i = 0; i < number; i++) {
            try {
                ICommand command = undoList.remove(undoList.size() - 1);
                command.execute();
                executeList.add(command);
            } catch (Exception e) {
                return;
            }
        }
    }

    @Override
    public void undo(ICommand command) {
        command.undo();
        undoList.add(command);
        executeList.clear();
    }

    @Override
    public void undo(int number) {
        for (int i = 0; i < number; i++) {
            try {
                ICommand command = executeList.remove(executeList.size() - 1);
                command.undo();
                undoList.add(command);
            } catch (Exception e) {
                return;
            }
        }
    }

    @Override
    public ObservableList<ICommand> getExecuteList() {
        return executeList;
    }

    @Override
    public ObservableList<ICommand> getUndoList() {
        return undoList;
    }

    @Override
    public void addMovie(ObservableList<Movie> movies) {
        ICommand command = new AddMovie(movies);
        execute(command);
    }


    @Override
    public void deleteMovie(ObservableList<Movie> movies, Movie movie) {
        ICommand command = new DeleteMovie(movies, movie);
        execute(command);
    }

    @Override
    public void setTitle(Movie movie, String oldTitle, String newTitle) {
        ICommand command = new SetTitle(movie, oldTitle, newTitle);
        execute(command);
    }

    @Override
    public void setYearAward(Movie movie, Integer oldYearAward, Integer newYearAward) {
        ICommand command = new SetYearAward(movie, oldYearAward, newYearAward);
        execute(command);
    }

    @Override
    public void setActors(Movie movie, String oldActors, String newActors) {
        ICommand command = new SetActors(movie, oldActors, newActors);
        execute(command);
    }

    @Override
    public void setDirector(Movie movie, String oldDirector, String newDirector) {
        ICommand command = new SetDirector(movie, oldDirector, newDirector);
        execute(command);
    }

    @Override
    public void setTitleEn(Movie movie, String oldTitleEn, String newTitleEn) {
        ICommand command = new SetTitleEn(movie, oldTitleEn, newTitleEn);
        execute(command);
    }

    @Override
    public void setYearProduction(Movie movie, Integer oldYear, Integer newYear) {
        ICommand command = new SetYearProduction(movie, oldYear, newYear);
        execute(command);
    }

    @Override
    public void setCountries(Movie movie, String oldCountries, String newCountries) {
        ICommand command = new SetCountries(movie, oldCountries, newCountries);
        execute(command);
    }

    @Override
    public void setDuration(Movie movie, Integer oldDuration, Integer newDuration) {
        ICommand command = new SetDuration(movie, oldDuration, newDuration);
        execute(command);
    }

    @Override
    public void setFsk(Movie movie, Movie.Fsk oldFsk, Movie.Fsk newFsk) {
        ICommand command = new SetFsk(movie, oldFsk, newFsk);
        execute(command);
    }

    @Override
    public void setGenre(Movie movie, String oldGenre, String newGenre) {
        ICommand command = new SetGenre(movie, oldGenre, newGenre);
        execute(command);
    }

    @Override
    public void setStartDate(Movie movie, LocalDate oldStartDate, LocalDate newStartDate) {
        ICommand command = new SetStartDate(movie, oldStartDate, newStartDate);
        execute(command);
    }

    @Override
    public void setNumberOscars(Movie movie, Integer oldOscars, Integer newOscars) {
        ICommand command = new SetNumberOscars(movie, oldOscars, newOscars);
        execute(command);
    }
}