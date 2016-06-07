package ch.fhnw.oop.oscar.view.javafx;

import ch.fhnw.oop.oscar.model.Movie;
import ch.fhnw.oop.oscar.model.filebackend.MovieEdited;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

/**
 * MovieFXSelector
 * Created by Hinrich on 31.05.2016.
 */
class MovieFXSelector<T extends Movie> extends TableView {

    @SuppressWarnings("unchecked")
    MovieFXSelector() {
        TableColumn editedCol = new TableColumn();
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


        TableColumn<T, Integer> yearAwardCol = new TableColumn<>("Jahr");
        yearAwardCol.setCellValueFactory(new PropertyValueFactory<T, Integer>("yearAward"));

        TableColumn<T, String> titleCol = new TableColumn<>("Titel");
        titleCol.setCellValueFactory(new PropertyValueFactory<T, String>("title"));

        TableColumn<T, String> directorCol = new TableColumn<>("Regisseur");
        directorCol.setCellValueFactory(new PropertyValueFactory<T, String>("director"));

        TableColumn<T, String> actorsCol = new TableColumn<>("Hauptdarsteller");
        actorsCol.setCellValueFactory(new PropertyValueFactory<T, String>("actors"));

        getColumns().setAll(editedCol, yearAwardCol, titleCol, directorCol, actorsCol);
    }


    private void initializeControls() {

    }

    private void layoutControls() {

    }

    private void addEventHandlers() {

    }

    private void addValueChangeListeners() {

    }

    private void addBindings() {

    }
}