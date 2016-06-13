package ch.fhnw.oop.oscar.view.javafx;

import ch.fhnw.oop.oscar.OscarPresenter;
import ch.fhnw.oop.oscar.command.ICommand;
import ch.fhnw.oop.oscar.model.Movie;
import ch.fhnw.oop.oscar.view.IOscarView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * OscarFXView
 * Created by Hinrich on 31.05.2016.
 */
class OscarFXView extends VBox implements IOscarView {
    private final OscarPresenter presenter;
    private MovieFXSelector<Movie> movieSelector;
    private MovieFXTools toolBar;
    private MovieFXDetails movieDetails;
    private FilteredList<Movie> moviesFiltered;
    private Movie selectedMovie;
    private final List<ICommand> executeList;
    private final List<ICommand> undoList;

    OscarFXView() {
        presenter = new OscarPresenter(this);
        executeList = presenter.getExecuteList();
        undoList = presenter.getUndoList();

        initializeControls();
        layoutControls();
        addEventHandlers();
        addValueChangeListeners();
        addBindings();

        // this must be the last call in the constructor
        presenter.fillView();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void setMovies(ObservableList<Movie> moviesObservable) {
        moviesFiltered = new FilteredList<>(moviesObservable, p -> true);

        toolBar.setMovies(moviesFiltered);

        SortedList<Movie> moviesSorted = new SortedList<>(moviesFiltered);
        moviesSorted.comparatorProperty().bind(movieSelector.comparatorProperty());

        movieSelector.setItems(moviesSorted);
    }

    @Override
    public void onMovieSelected(Movie movie) {
        selectedMovie = movie;
        movieDetails.setMovie(selectedMovie);
    }

    @Override
    public Movie getSelectedMovie() {
        return selectedMovie;
    }

    private void initializeControls() {
        toolBar = new MovieFXTools(presenter, executeList, undoList);
        movieSelector = new MovieFXSelector<>(presenter, this);
        movieDetails = new MovieFXDetails(presenter, this);
    }

    private void layoutControls() {
        SplitPane splitPane = new SplitPane();
        //movieSelector.setPrefWidth();
        splitPane.getItems().add(0, movieSelector);
        splitPane.getItems().add(1, movieDetails);

        VBox.setVgrow(splitPane, Priority.ALWAYS);
        splitPane.setMaxWidth(Double.MAX_VALUE);
        splitPane.setMaxHeight(Double.MAX_VALUE);


        this.getChildren().add(0, toolBar);
        this.getChildren().add(1, splitPane);
    }

    private void addEventHandlers() {

    }

    private void addValueChangeListeners() {
    }

    private void addBindings() {

    }
}
