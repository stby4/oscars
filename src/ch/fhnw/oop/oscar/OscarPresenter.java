package ch.fhnw.oop.oscar;

import ch.fhnw.oop.oscar.model.LevenshteinDistance;
import ch.fhnw.oop.oscar.model.Movie;
import ch.fhnw.oop.oscar.model.OscarModel;
import ch.fhnw.oop.oscar.model.filebackend.FileBackendModel;
import ch.fhnw.oop.oscar.view.IOscarView;
import javafx.collections.transformation.FilteredList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

/**
 * Presenter
 * Created by Hinrich on 31.05.2016.
 */
public class OscarPresenter implements IOscarPresenter {
    private final IOscarView view;
    private final OscarModel model;

    public OscarPresenter(IOscarView view) {
        this.view = view;
        model = new FileBackendModel();

    }

    @Override
    public void fillView() {
        view.setMovies(model.getMovies());
    }

    public void filterMovies(FilteredList<Movie> moviesFiltered, String query) {
        if (null != moviesFiltered) {
            moviesFiltered.setPredicate(movie -> {
                if (null == query || query.isEmpty()) {
                    return true;
                }

                if(0.8 < LevenshteinDistance.getSimilarity(query, movie.getTitle())) {
                    return true;
                }

                return false;
            });
        }
    }

    @Override
    public void onMovieSelected(Movie movie) {
        view.onMovieSelected(movie);
    }

    @Override
    public void onTitleChanged(Movie movie, String title) {
        movie.titleProperty().setValue(title);
        view.onMovieSelected(movie);
    }

    @Override
    public void onYearAwardChanged(Movie movie, Integer yearAward) {
        movie.yearAwardProperty().setValue(yearAward);
    }

    @Override
    public void onDirectorChanged(Movie movie, String director) {
        movie.directorProperty().setValue(director);
    }

    @Override
    public void onActorsChanged(Movie movie, String actors) {
        movie.actorsProperty().setValue(actors);
    }

    @Override
    public void onTitleEnChanged(Movie movie, String titleEn) {
        movie.titleEnProperty().setValue(titleEn);
    }

    @Override
    public void onYearProductionChanged(Movie movie, Integer yearProduction) {
        movie.yearProductionProperty().setValue(yearProduction);
    }

    @Override
    public void onCountriesChanged(Movie movie, String countries) {
        movie.countriesProperty().setValue(countries);
    }

    @Override
    public void onDurationChanged(Movie movie, Integer duration) {
        movie.durationProperty().setValue(duration);
    }

    @Override
    public void onFskChanged(Movie movie, Integer fsk) {
        movie.fskProperty().setValue(fsk);
    }

    @Override
    public void onGenreChanged(Movie movie, String genre) {
        movie.genreProperty().setValue(genre);
    }

    @Override
    public void onStartDateChanged(Movie movie, LocalDate startDate) {
        movie.startDateProperty().setValue(startDate);
    }

    @Override
    public void onNumberOscatsChanged(Movie movie, Integer oscars) {
        movie.numberOscarsProperty().setValue(oscars);
    }
}
