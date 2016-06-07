package ch.fhnw.oop.oscar.view.javafx;

import ch.fhnw.oop.oscar.model.Movie;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * MovieFXSelector
 * Created by Hinrich on 31.05.2016.
 */
class MovieFXSelector<T extends Movie> extends TableView {

    @SuppressWarnings("unchecked")
    MovieFXSelector() {
        TableColumn<T, Integer> yearAwardCol = new TableColumn<>("Jahr");
        yearAwardCol.setCellValueFactory(new PropertyValueFactory<T, Integer>("yearAward"));

        TableColumn<T, String> titleCol = new TableColumn<>("Titel");
        titleCol.setCellValueFactory(new PropertyValueFactory<T, String>("title"));

        TableColumn<T, String> directorCol = new TableColumn<>("Regisseur");
        directorCol.setCellValueFactory(new PropertyValueFactory<T, String>("director"));

        TableColumn<T, String> actorsCol = new TableColumn<>("Hauptdarsteller");
        actorsCol.setCellValueFactory(new PropertyValueFactory<T, String>("actors"));

        getColumns().setAll(yearAwardCol, titleCol, directorCol, actorsCol);
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