package ch.fhnw.oop.oscar.view.javafx;

import ch.fhnw.oop.oscar.OscarPresenter;
import ch.fhnw.oop.oscar.model.Movie;
import ch.fhnw.oop.oscar.view.OscarView;
import javafx.collections.ObservableList;
import javafx.scene.control.Control;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * OscarFXView
 * Created by Hinrich on 31.05.2016.
 */
class OscarFXView extends VBox implements OscarView {
    private final OscarPresenter presenter;
    private TableView<Movie> movieSelector;
    private Control toolBar;
    private Pane movieDetails;

    OscarFXView() {
        presenter = new OscarPresenter(this);

        initializeControls();
        layoutControls();
        addEventHandlers();
        addValueChangeListeners();
        addBindings();
        //dataList = FXCollections.observableArrayList();
        // this must be the last call in the constructor
        presenter.fillView();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void setMovies(ObservableList<Movie> movies) {
        movieSelector.setItems(movies);
    }

    private void initializeControls() {
        toolBar = new MovieFXTools();
        movieSelector = new MovieFXSelector<>();
        movieDetails = new MovieFXDetails();
    }

    private void layoutControls() {
        SplitPane splitPane = new SplitPane();
        splitPane.getItems().add(0, movieSelector);
        splitPane.getItems().add(1, movieDetails);

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
