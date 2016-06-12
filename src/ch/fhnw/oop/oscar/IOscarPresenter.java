package ch.fhnw.oop.oscar;

import ch.fhnw.oop.oscar.model.Movie;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
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
     * @param query the seartch term
     */
    void filterMovies(FilteredList<Movie> moviesFiltered, String query);

    /**
     * set movie for editing
     * @param movie the movie
     */
    void onMovieSelected(Movie movie);
    void onTitleChanged(Movie movie, String oldTitle, String newTitle);
    void onYearAwardChanged(Movie movie, Integer oldYearAward, Integer newYearAward);
    void onDirectorChanged(Movie movie, String oldDirector, String newDirector);
    void onActorsChanged(Movie movie, String oldActors, String newActors);
    void onTitleEnChanged(Movie movie, String oldTitleEn, String newTitleEn);
    void onYearProductionChanged(Movie movie, Integer oldYearProduction, Integer newYearProduction);
    void onCountriesChanged(Movie movie, String oldCountries, String newCountries);
    void onDurationChanged(Movie movie, Integer oldDuration, Integer newDuration);
    void onFskChanged(Movie movie, Integer oldFsk, Integer newFsk);
    void onGenreChanged(Movie movie, String oldGenre, String newGenre);
    void onStartDateChanged(Movie movie, LocalDate oldStartDate, LocalDate newStartDate);
    void onNumberOscarsChanged(Movie movie, Integer oldOscars, Integer newOscars);
}
