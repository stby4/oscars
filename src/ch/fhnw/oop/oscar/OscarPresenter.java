package ch.fhnw.oop.oscar;

import ch.fhnw.oop.oscar.controller.OscarController;
import ch.fhnw.oop.oscar.model.Movie;
import ch.fhnw.oop.oscar.model.filebackend.FileBackendModel;
import ch.fhnw.oop.oscar.view.IOscarView;
import javafx.collections.transformation.FilteredList;

import java.time.LocalDate;

/**
 * Presenter
 * Created by Hinrich on 31.05.2016.
 */
public class OscarPresenter implements IOscarPresenter {
    private final IOscarView view;
    private final FileBackendModel model;
    private final OscarController controller;

    public OscarPresenter(IOscarView view) {
        this.view = view;
        model = new FileBackendModel();
        controller = new OscarController();
    }

    @Override
    public void fillView() {
        view.setMovies(model.getMovies());
    }

    public void filterMovies(FilteredList<Movie> moviesFiltered, String query) {
        if (null != moviesFiltered) {
            moviesFiltered.setPredicate(movie -> {
                return null == query || query.isEmpty() || movie.getTitle().toLowerCase().contains(query.toLowerCase()) || movie.getActors().toLowerCase().contains(query.toLowerCase()) || movie.getDirector().toLowerCase().contains(query.toLowerCase());
            });
        }
    }

    @Override
    public void onMovieSelected(Movie movie) {
        view.onMovieSelected(movie);
    }

    @Override
    public void onTitleChanged(Movie movie, String oldTitle, String newTitle) {
        controller.setTitle(movie, oldTitle, newTitle);
    }

    @Override
    public void onYearAwardChanged(Movie movie, Integer oldYearAward, Integer newYearAward) {
        controller.setYearAward(movie, oldYearAward, newYearAward);
    }

    @Override
    public void onDirectorChanged(Movie movie, String oldDirector, String newDirector) {
        controller.setDirector(movie, oldDirector, newDirector);
    }

    @Override
    public void onActorsChanged(Movie movie, String oldActors, String newActors) {
        controller.setActors(movie, oldActors, newActors);
    }

    @Override
    public void onTitleEnChanged(Movie movie, String oldTitleEn, String newTitleEn) {
        controller.setTitleEn(movie, oldTitleEn, newTitleEn);
    }

    @Override
    public void onYearProductionChanged(Movie movie, Integer oldYearProduction, Integer newYearProduction) {
        controller.setYearProduction(movie, oldYearProduction, newYearProduction);
    }

    @Override
    public void onCountriesChanged(Movie movie, String oldCountries, String newCountries) {
        controller.setCountries(movie, oldCountries, newCountries);
    }

    @Override
    public void onDurationChanged(Movie movie, Integer oldDuration, Integer newDuration) {
        controller.setDuration(movie, oldDuration, newDuration);
    }

    @Override
    public void onFskChanged(Movie movie, Integer oldFsk, Integer newFsk) {
        controller.setFsk(movie, oldFsk, newFsk);
    }

    @Override
    public void onGenreChanged(Movie movie, String oldGenre, String newGenre) {
        controller.setGenre(movie, oldGenre, newGenre);
    }

    @Override
    public void onStartDateChanged(Movie movie, LocalDate oldStartDate, LocalDate newStartDate) {
        controller.setStartDate(movie, oldStartDate, newStartDate);
    }

    @Override
    public void onNumberOscarsChanged(Movie movie, Integer oldOscars, Integer newOscars) {
        controller.setNumberOscars(movie, oldOscars, newOscars);
    }
}
