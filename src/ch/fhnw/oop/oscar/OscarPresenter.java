package ch.fhnw.oop.oscar;

import ch.fhnw.oop.oscar.controller.OscarController;
import ch.fhnw.oop.oscar.model.Movie;
import ch.fhnw.oop.oscar.model.filebackend.FileBackendModel;
import ch.fhnw.oop.oscar.view.IOscarView;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

import java.io.IOException;
import java.time.LocalDate;

/**
 * Presenter
 * Created by Hinrich on 31.05.2016.
 */
public class OscarPresenter implements IOscarPresenter {
    private final IOscarView view;
    private final FileBackendModel model;
    private final OscarController controller;
    private final ObservableList<Movie> movies;

    public OscarPresenter(IOscarView view) {
        this.view = view;
        model = new FileBackendModel();
        movies = model.getMovies();
        controller = new OscarController();
    }

    @Override
    public void fillView() {
        view.setMovies(movies);
    }

    public void filterMovies(FilteredList<Movie> moviesFiltered, String query) {
        if (null != moviesFiltered) {
            moviesFiltered.setPredicate(movie -> {
                return null == query || query.isEmpty() || movie.getTitle().toLowerCase().contains(query.toLowerCase()) || movie.getActors().toLowerCase().contains(query.toLowerCase()) || movie.getDirector().toLowerCase().contains(query.toLowerCase());
            });
        }
    }

    @Override
    public void onMovieAdded() {
        controller.addMovie(movies);
    }

    @Override
    public void onMovieDeleted() {
        controller.deleteMovie(movies, view.getSelectedMovie());
        if (1 > movies.size()) {
            view.onMovieSelected(null);
        }
    }

    @Override
    public void onMoviesSaved() {
        try {
            model.writeFile();
        } catch (IOException e) {
// TODO
        }
    }

    @Override
    public void onMovieSelected(Movie movie) {
        view.onMovieSelected(movie);
    }

    @Override
    public void onTitleChanged(Movie movie, String oldTitle, String newTitle) {
        if (null != movie) controller.setTitle(movie, oldTitle, newTitle);
    }

    @Override
    public void onYearAwardChanged(Movie movie, Integer oldYearAward, Integer newYearAward) {
        if (null != movie) controller.setYearAward(movie, oldYearAward, newYearAward);
    }

    @Override
    public void onDirectorChanged(Movie movie, String oldDirector, String newDirector) {
        if (null != movie) controller.setDirector(movie, oldDirector, newDirector);
    }

    @Override
    public void onActorsChanged(Movie movie, String oldActors, String newActors) {
        if (null != movie) controller.setActors(movie, oldActors, newActors);
    }

    @Override
    public void onTitleEnChanged(Movie movie, String oldTitleEn, String newTitleEn) {
        if (null != movie) controller.setTitleEn(movie, oldTitleEn, newTitleEn);
    }

    @Override
    public void onYearProductionChanged(Movie movie, Integer oldYearProduction, Integer newYearProduction) {
        if (null != movie) controller.setYearProduction(movie, oldYearProduction, newYearProduction);
    }

    @Override
    public void onCountriesChanged(Movie movie, String oldCountries, String newCountries) {
        if (null != movie) controller.setCountries(movie, oldCountries, newCountries);
    }

    @Override
    public void onDurationChanged(Movie movie, Integer oldDuration, Integer newDuration) {
        if (null != movie) controller.setDuration(movie, oldDuration, newDuration);
    }

    @Override
    public void onFskChanged(Movie movie, Integer oldFsk, Integer newFsk) {
        if (null != movie) controller.setFsk(movie, oldFsk, newFsk);
    }

    @Override
    public void onGenreChanged(Movie movie, String oldGenre, String newGenre) {
        if (null != movie) controller.setGenre(movie, oldGenre, newGenre);
    }

    @Override
    public void onStartDateChanged(Movie movie, LocalDate oldStartDate, LocalDate newStartDate) {
        if (null != movie) controller.setStartDate(movie, oldStartDate, newStartDate);
    }

    @Override
    public void onNumberOscarsChanged(Movie movie, Integer oldOscars, Integer newOscars) {
        if (null != movie) controller.setNumberOscars(movie, oldOscars, newOscars);
    }
}
