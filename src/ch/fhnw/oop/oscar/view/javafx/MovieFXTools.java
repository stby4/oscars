package ch.fhnw.oop.oscar.view.javafx;

import ch.fhnw.oop.oscar.IOscarPresenter;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

import java.util.ResourceBundle;

/**
 * Movie Tools
 * Created by Hinrich on 07.06.2016.
 */
public class MovieFXTools extends ToolBar {
    private final ResourceBundle STRINGS =  ResourceBundle.getBundle("view.javafx.Strings");
    IOscarPresenter presenter;

    private Button save;

    private Button add;
    private Button remove;

    private Button undo;
    private Button redo;

    private TextField search;


    public MovieFXTools(IOscarPresenter presenter) {
        this.presenter = presenter;

        initializeControls();
        layoutControls();
        addEventHandlers();
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

    }
}
