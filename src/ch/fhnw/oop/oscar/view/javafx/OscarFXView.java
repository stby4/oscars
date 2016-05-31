package ch.fhnw.oop.oscar.view.javafx;

import ch.fhnw.oop.oscar.OscarPresenter;
import ch.fhnw.oop.oscar.view.OscarView;
import javafx.scene.layout.VBox;

/**
 * OscarFXView
 * Created by Hinrich on 31.05.2016.
 */
public class OscarFXView extends VBox implements OscarView {
    private final OscarPresenter presenter;

    public OscarFXView() {
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
