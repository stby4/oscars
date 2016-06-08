package ch.fhnw.oop.oscar;

import ch.fhnw.oop.oscar.model.Movie;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

/**
 * Interface for Oscar presenter
 * Created by Hinrich on 07.06.2016.
 */
public interface IOscarPresenter {
    /**
     * fills the current view with the data from the model
     */
    public void fillView();

    /**
     * set movie for editing
     * @param movie
     */
    void onMovieSelected(Movie movie);
    void onTitleChanged(Movie movie, String title);
    void onYearAwardChanged(Movie movie, Integer yearAward);
    void onDirectorChanged(Movie movie, String director);
    void onActorsChanged(Movie movie, String actors);
    void onTitleEnChanged(Movie movie, String titleEn);
    void onYearProductionChanged(Movie movie, Integer yearProduction);
    void onCountriesChanged(Movie movie, String countries);
    void onDurationChanged(Movie movie, Integer duration);
    void onFskChanged(Movie movie, Integer fsk);
    void onGenreChanged(Movie movie, String genre);
    void onStartDateChanged(Movie movie, LocalDate startDate);
    void onNumberOscatsChanged(Movie movie, Integer oscars);
}
