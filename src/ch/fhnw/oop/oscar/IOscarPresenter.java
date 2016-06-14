package ch.fhnw.oop.oscar;

import ch.fhnw.oop.oscar.command.ICommand;
import ch.fhnw.oop.oscar.model.Movie;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

import java.time.LocalDate;

/**
 * Interface for Oscar presenter
 * Created by Hinrich on 07.06.2016.
 */
public interface IOscarPresenter {
    /**
     * fills the current view with the data from the model
     */
    void fillView();

    /**
     * filters movie list
     *
     * @param query the seartch term
     */
    void filterMovies(FilteredList<Movie> moviesFiltered, String query);

    /**
     * set movie for editing
     *
     * @param movie the movie
     */
    void onMovieSelected(Movie movie);

    void onMovieAdded();

    void onMovieDeleted();

    void onMoviesSaved();

    /**
     * get list of executed commands
     *
     * @return list
     */
    ObservableList<ICommand> getExecuteList();

    /**
     * get list of "undone" commands
     *
     * @return list
     */
    ObservableList<ICommand> getUndoList();

    /**
     * undo
     *
     * @param number number of undos
     */
    void onUndo(int number);

    /**
     * redo
     *
     * @param number number of redos
     */
    void onRedo(int number);


    void onTitleChanged(Movie movie, String oldTitle, String newTitle);

    void onYearAwardChanged(Movie movie, Integer oldYearAward, Integer newYearAward);

    void onDirectorChanged(Movie movie, String oldDirector, String newDirector);

    void onActorsChanged(Movie movie, String oldActors, String newActors);

    void onTitleEnChanged(Movie movie, String oldTitleEn, String newTitleEn);

    void onYearProductionChanged(Movie movie, Integer oldYearProduction, Integer newYearProduction);

    void onCountriesChanged(Movie movie, String oldCountries, String newCountries);

    void onDurationChanged(Movie movie, Integer oldDuration, Integer newDuration);

    void onFskChanged(Movie movie, Movie.Fsk oldFsk, Movie.Fsk newFsk);

    void onGenreChanged(Movie movie, String oldGenre, String newGenre);

    void onStartDateChanged(Movie movie, LocalDate oldStartDate, LocalDate newStartDate);

    void onNumberOscarsChanged(Movie movie, Integer oldOscars, Integer newOscars);
}
