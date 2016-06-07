package ch.fhnw.oop.oscar.view;

import ch.fhnw.oop.oscar.model.Movie;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

/**
 * OscarView
 * Created by Hinrich on 31.05.2016.
 */
public interface OscarView {
    void setMovies(ObservableList<Movie> movies);

    void onMovieSelected(Movie movie);

/*
    void onTitleChanged(StringProperty title);
    void onYearAwardChanged(IntegerProperty yearAward);
    void onDirectorChanged(StringProperty director);
    void onActorsChanged(StringProperty actors);
    void onTitleEnChanged(StringProperty titleEn);
    void onYearProductionChanged(IntegerProperty yearProduction);
    void onCountriesChanged(StringProperty countries);
    void onDurationChanged(IntegerProperty duration);
    void onFskChanged(IntegerProperty fsk);
    void onGenreChanged(StringProperty genre);
    void onStartDateChanged(IntegerProperty startDate);
    void onNumberOscatsChanged(IntegerProperty oscars);
*/
}
