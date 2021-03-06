package ch.fhnw.oop.oscar.view.javafx;

import ch.fhnw.oop.oscar.IOscarPresenter;
import ch.fhnw.oop.oscar.command.ICommand;
import ch.fhnw.oop.oscar.model.Movie;
import ch.fhnw.oop.oscar.view.IOscarView;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Movie Tools
 * Created by Hinrich on 07.06.2016.
 */
class MovieFXTools extends ToolBar {
    private final ResourceBundle STRINGS = ResourceBundle.getBundle("view.javafx.Strings");
    private final IOscarPresenter presenter;
    private final ObservableList<ICommand> executeList;
    private final ObservableList<ICommand> undoList;

    private Button save;

    private Button add;
    private Button remove;

    private Button undo;
    private Button redo;

    private TextField search;

    private FilteredList<Movie> moviesFiltered;

    /**
     * constructor
     *
     * @param presenter   the presenter to be used
     * @param executeList list with execute commands @see IOscarController
     * @param undoList    list with undo commands @see IOscarController
     */
    MovieFXTools(IOscarPresenter presenter, ObservableList<ICommand> executeList, ObservableList<ICommand> undoList) {
        this.presenter = presenter;
        this.executeList = executeList;
        this.undoList = undoList;

        initializeControls();
        layoutControls();
        addEventHandlers();
        addListeners();
    }

    /**
     * invoke movies
     *
     * @param moviesFiltered the movies
     */
    void setMovies(FilteredList<Movie> moviesFiltered) {
        this.moviesFiltered = moviesFiltered;
    }

    /**
     * set selected movie
     *
     * @param movie the movie
     */
    void setMovie(Movie movie) {
        if (null != movie) {
            remove.setDisable(false);
        } else {
            remove.setDisable(true);
        }
    }

    private void initializeControls() {
        Image imageSave = new Image("view/javafx/icons/save.svg.png", true);
        save = new Button();
        save.setGraphic(new ImageView(imageSave));
        save.setTooltip(new Tooltip(STRINGS.getString("Save")));

        Image imageAdd = new Image("view/javafx/icons/add.svg.png", true);
        add = new Button();
        add.setGraphic(new ImageView(imageAdd));
        add.setTooltip(new Tooltip(STRINGS.getString("Add")));

        Image imageRemove = new Image("view/javafx/icons/remove.svg.png", true);
        remove = new Button();
        remove.setGraphic(new ImageView(imageRemove));
        remove.setTooltip(new Tooltip(STRINGS.getString("Remove")));
        remove.setDisable(true);

        Image imageUndo = new Image("view/javafx/icons/undo.svg.png", true);
        undo = new Button();
        undo.setGraphic(new ImageView(imageUndo));
        undo.setTooltip(new Tooltip(STRINGS.getString("Undo")));
        undo.setDisable(true);

        Image imageRedo = new Image("view/javafx/icons/redo.svg.png", true);
        redo = new Button();
        redo.setGraphic(new ImageView(imageRedo));
        redo.setTooltip(new Tooltip(STRINGS.getString("Redo")));
        redo.setDisable(true);

        search = new TextField();
        search.setId("search_tf");
    }

    private void layoutControls() {
        getItems().add(0, save);
        getItems().add(1, new Separator());
        getItems().add(2, add);
        getItems().add(3, remove);
        getItems().add(4, new Separator());
        getItems().add(5, undo);
        getItems().add(6, redo);

        Pane spacer = new HBox();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        getItems().add(7, spacer);

        getItems().add(8, search);
    }

    private void addEventHandlers() {
        search.textProperty().addListener((v, o, query) -> {
            presenter.filterMovies(moviesFiltered, query);
        });

        save.setOnAction(event -> presenter.onMoviesSaved());

        add.setOnAction(event -> presenter.onMovieAdded());
        remove.setOnAction(event -> presenter.onMovieDeleted());

        undo.setOnAction(event -> presenter.onUndo(1));
        redo.setOnAction(event -> presenter.onRedo(1));
    }

    private void addListeners() {
        undoList.addListener(new ListChangeListener<ICommand>() {
            @Override
            public void onChanged(Change<? extends ICommand> c) {
                while (c.next()) {
                    if (c.wasAdded()) {
                        if (0 < undoList.size()) {
                            redo.setDisable(false);
                        }
                    }
                    if (c.wasRemoved()) {
                        if (1 > undoList.size()) {
                            redo.setDisable(true);
                        }
                    }
                }
            }
        });

        executeList.addListener(new ListChangeListener<ICommand>() {
            @Override
            public void onChanged(Change<? extends ICommand> c) {
                while (c.next()) {
                    if (c.wasAdded()) {
                        if (0 < executeList.size()) {
                            undo.setDisable(false);
                        }
                    }
                    if (c.wasRemoved()) {
                        if (1 > executeList.size()) {
                            undo.setDisable(true);
                        }
                    }
                }
            }
        });
    }
}
