package ch.fhnw.oop.oscar.view.javafx;

import ch.fhnw.oop.oscar.IOscarPresenter;
import ch.fhnw.oop.oscar.model.Movie;
import ch.fhnw.oop.oscar.view.IOscarView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

import java.util.ResourceBundle;

/**
 * MovieFXSelector
 * Created by Hinrich on 31.05.2016.
 */
class MovieFXSelector<T extends Movie> extends TableView {
    private final ResourceBundle STRINGS = ResourceBundle.getBundle("view.javafx.Strings");
    private final IOscarPresenter presenter;

    private TableColumn editedCol;
    private TableColumn<T, Integer> yearAwardCol;
    private TableColumn<T, String> titleCol;
    private TableColumn<T, String> directorCol;
    private TableColumn<T, String> actorsCol;

    /**
     * constructor
     *
     * @param presenter the presenter
     */
    MovieFXSelector(IOscarPresenter presenter) {
        this.presenter = presenter;

        initializeControls();
        layoutControls();
        addEventHandlers();
        addValueChangeListeners();
    }

    @SuppressWarnings("unchecked")
    private void initializeControls() {

        editedCol = new TableColumn<>();
        editedCol.setCellValueFactory(new PropertyValueFactory<T, Boolean>("edited"));
        //editedCol.setPrefWidth(16);
        editedCol.setCellFactory(new Callback<TableColumn<T, Boolean>, TableCell<T, Boolean>>() {
            @Override
            public TableCell<T, Boolean> call(TableColumn<T, Boolean> param) {
                return new TableCell<T, Boolean>() {
                    @Override
                    protected void updateItem(Boolean item, boolean empty) {
                        if (null != item) {
                            if (item) {
                                ImageView edited = new ImageView(new Image("view/javafx/marks/Mark_Blue.png", true));
                                edited.setFitHeight(16);
                                edited.setFitWidth(16);
                                setGraphic(edited);
                            } else {
                                ImageView unedited = new ImageView(new Image("view/javafx/marks/Mark_Empty.png", true));
                                unedited.setFitHeight(16);
                                unedited.setFitWidth(16);
                                setGraphic(unedited);
                            }
                        } else {
                            setGraphic(null);
                        }
                    }
                };
            }
        });

        yearAwardCol = new TableColumn<>(STRINGS.getString("Year"));
        yearAwardCol.setCellValueFactory(new PropertyValueFactory<>("yearAward"));

        titleCol = new TableColumn<>(STRINGS.getString("Title"));
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        yearAwardCol.setEditable(true);

        directorCol = new TableColumn<>(STRINGS.getString("Director"));
        directorCol.setCellValueFactory(new PropertyValueFactory<>("director"));

        actorsCol = new TableColumn<>(STRINGS.getString("Actors"));
        actorsCol.setCellValueFactory(new PropertyValueFactory<>("actors"));
    }

    @SuppressWarnings("unchecked")
    private void layoutControls() {
        getColumns().setAll(editedCol, yearAwardCol, titleCol, directorCol, actorsCol);
    }

    private void addEventHandlers() {
    }

    @SuppressWarnings("unchecked")
    private void addValueChangeListeners() {
        getSelectionModel().selectedItemProperty().addListener((v, o, n) -> {
            if (null != n && n instanceof Movie) {
                presenter.onMovieSelected((T) n);
            }
        });

    }

    @SuppressWarnings("unchecked")
    public void setMovies(ObservableList<Movie> movies) {
        setItems(movies);

        movies.addListener(new ListChangeListener() {
            @Override
            public void onChanged(Change c) {
                while (c.next()) {
                    if (c.wasAdded()) {
                        getSelectionModel().select(movies.get(movies.size() - 1));
                    }
                }
            }
        });
    }
}