package ch.fhnw.oop.oscar;

import ch.fhnw.oop.oscar.model.OscarModel;
import ch.fhnw.oop.oscar.model.filebackend.FileBackendModel;
import ch.fhnw.oop.oscar.view.OscarView;

/**
 * Presenter
 * Created by Hinrich on 31.05.2016.
 */
public class OscarPresenter {
    private final OscarView view;
    private final OscarModel model;

    public OscarPresenter(OscarView view) {
        this.view = view;
        model = new FileBackendModel();
    }
}
