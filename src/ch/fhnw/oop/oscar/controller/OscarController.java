package ch.fhnw.oop.oscar.controller;

import ch.fhnw.oop.oscar.command.*;
import ch.fhnw.oop.oscar.model.Movie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * execute/undo controller for oscar project
 * Created by Hinrich on 12.06.2016.
 */
public class OscarController {
    private List<ICommand> executeList = new ArrayList<>();
    private List<ICommand> undoList = new ArrayList<>();

    public void execute(ICommand command) {
        command.execute();
        executeList.add(command);
    }

    public void undo(ICommand command) {
        // TODO
        command.undo();
    }

    public void setTitle(Movie movie, String oldTitle, String newTitle) {
        ICommand command = new SetTitle(movie, oldTitle, newTitle);
        execute(command);
    }

    public void setYearAward(Movie movie, Integer oldYearAward, Integer newYearAward) {
        ICommand command = new SetYearAward(movie, oldYearAward, newYearAward);
        execute(command);
    }

    public void setActors(Movie movie, String oldActors, String newActors) {
        ICommand command = new SetActors(movie, oldActors, newActors);
        execute(command);
    }

    public void setDirector(Movie movie, String oldDirector, String newDirector) {
        ICommand command = new SetDirector(movie, oldDirector, newDirector);
        execute(command);
    }

    public void setTitleEn(Movie movie, String oldTitleEn, String newTitleEn) {
        ICommand command = new SetTitleEn(movie, oldTitleEn, newTitleEn);
        execute(command);
    }

    public void setYearProduction(Movie movie, Integer oldYear, Integer newYear) {
        ICommand command = new SetYearProduction(movie, oldYear, newYear);
        execute(command);
    }

    public void setCountries(Movie movie, String oldCountries, String newCountries) {
        ICommand command = new SetCountries(movie, oldCountries, newCountries);
        execute(command);
    }

    public void setDuration(Movie movie, Integer oldDuration, Integer newDuration) {
        ICommand command = new SetDuration(movie, oldDuration, newDuration);
        execute(command);
    }

    public void setFsk(Movie movie, Integer oldFsk, Integer newFsk) {
        ICommand command = new SetFsk(movie, oldFsk, newFsk);
        execute(command);
    }

    public void setGenre(Movie movie, String oldGenre, String newGenre) {
        ICommand command = new SetGenre(movie, oldGenre, newGenre);
        execute(command);
    }

    public void setStartDate(Movie movie, LocalDate oldStartDate, LocalDate newStartDate) {
        ICommand command = new SetStartDate(movie, oldStartDate, newStartDate);
        execute(command);
    }

    public void setNumberOscars(Movie movie, Integer oldOscars, Integer newOscars) {
        ICommand command = new SetNumberOscars(movie, oldOscars, newOscars);
        execute(command);
    }
}