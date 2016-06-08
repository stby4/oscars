package ch.fhnw.oop.oscar.view.javafx;

import ch.fhnw.oop.oscar.OscarPresenter;
import ch.fhnw.oop.oscar.model.Movie;
import ch.fhnw.oop.oscar.view.IOscarView;
import javafx.collections.ObservableList;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 * OscarFXView
 * Created by Hinrich on 31.05.2016.
 */
class OscarFXView extends VBox implements IOscarView {
    private final OscarPresenter presenter;
    private MovieFXSelector<Movie> movieSelector;
    private MovieFXTools toolBar;
    private MovieFXDetails movieDetails;

    OscarFXView() {
        presenter = new OscarPresenter(this);

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
    public void setMovies(ObservableList<Movie> movies) {
        movieSelector.setItems(movies);
    }

    @Override
    public void onMovieSelected(Movie movie) {
        movieDetails.setMovie(movie);
    }

    private void initializeControls() {
        toolBar = new MovieFXTools(presenter);
        movieSelector = new MovieFXSelector<>(presenter);
        movieDetails = new MovieFXDetails(presenter);
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
