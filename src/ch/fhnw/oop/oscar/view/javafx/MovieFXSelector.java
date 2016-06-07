package ch.fhnw.oop.oscar.view.javafx;

import ch.fhnw.oop.oscar.model.Movie;
import ch.fhnw.oop.oscar.model.MovieEdited;
import ch.fhnw.oop.oscar.view.OscarView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    private final ResourceBundle STRINGS =  ResourceBundle.getBundle("view.javafx.Strings");
    private OscarView parent;

    private TableColumn editedCol;
    private TableColumn<T, Integer> yearAwardCol;
    private TableColumn<T, String> titleCol;
    TableColumn<T, String> directorCol;
    TableColumn<T, String> actorsCol;

    @SuppressWarnings("unchecked")
    MovieFXSelector(OscarView parent) {
        this.parent = parent;

        initializeControls();
        layoutControls();
        addEventHandlers();
        addValueChangeListeners();
        addBindings();
    }


    private void initializeControls() {

        editedCol = new TableColumn();
        editedCol.setCellValueFactory(new PropertyValueFactory("edited"));
        //editedCol.setPrefWidth(16);
        editedCol.setCellFactory(new Callback<TableColumn<T, MovieEdited>, TableCell<T, MovieEdited>>() {
            @Override
            public TableCell<T, MovieEdited> call(TableColumn<T, MovieEdited> param) {
                TableCell<T, MovieEdited> cell = new TableCell<T, MovieEdited>() {
                    @Override
                    protected void updateItem(MovieEdited item, boolean empty) {
                        if (null != item) {
                            if (item.isEdited()) {
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
                        }
                    }
                };
                return cell;
            }
        });


        yearAwardCol = new TableColumn<>(STRINGS.getString("Year"));
        yearAwardCol.setCellValueFactory(new PropertyValueFactory<T, Integer>("yearAward"));

        titleCol = new TableColumn<>(STRINGS.getString("Title"));
        titleCol.setCellValueFactory(new PropertyValueFactory<T, String>("title"));

        directorCol = new TableColumn<>(STRINGS.getString("Director"));
        directorCol.setCellValueFactory(new PropertyValueFactory<T, String>("director"));

        actorsCol = new TableColumn<>(STRINGS.getString("Actors"));
        actorsCol.setCellValueFactory(new PropertyValueFactory<T, String>("actors"));
    }

    @SuppressWarnings("unchecked")
    private void layoutControls() {
        getColumns().setAll(editedCol, yearAwardCol, titleCol, directorCol, actorsCol);

    }

    private void addEventHandlers() {
    }

    @SuppressWarnings("unchecked")
    private void addValueChangeListeners() {
        getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if(null != newValue && newValue instanceof Movie) {
                    parent.onMovieSelected((Movie) newValue);
                }
            }
        });
    }

    private void addBindings() {

    }
}