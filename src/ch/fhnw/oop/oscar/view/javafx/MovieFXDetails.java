package ch.fhnw.oop.oscar.view.javafx;

import javafx.beans.property.IntegerProperty;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * MovieFXDetails
 * Created by Hinrich on 07.06.2016.
 */
public class MovieFXDetails extends VBox {
    private Control year;
    private Control title;
    private Control director;
    private Control actors;
    private Control titleEn;
    private Control genre;
    private Control yearProduction;
    private Control countries;
    private Control duration;
    private Control fsk;
    private Control startDate;
    private Control numberOscars;

    public MovieFXDetails() {
        initializeControls();
        layoutControls();
        addEventHandlers();
    }

    private void initializeControls() {
        year = new Spinner<IntegerProperty>();
        title = new TextField();
        director = new TextField();
        actors = new TextField();
        titleEn = new TextField();
        genre = new TextField();
        yearProduction = new Spinner<IntegerProperty>();
        countries = new TextField();
        duration = new Spinner<IntegerProperty>();
        fsk = new ComboBox<IntegerProperty>();
        startDate = new DatePicker();
        numberOscars = new Spinner<IntegerProperty>();
    }

    private void layoutControls() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));

        // Year
        grid.add(new Text("Jahr"), 0, 0);
        grid.add(year, 1, 0, 3, 1);

        // Title
        grid.add(new Text("Titel"), 0, 1);
        grid.add(title, 1, 1, 3, 1);

        // Director
        grid.add(new Text("Regisseur"), 0, 2);
        grid.add(director, 1, 2, 3, 1);

        // Actors
        grid.add(new Text("Hauptdarsteller"), 0, 3);
        grid.add(actors, 1, 3, 3, 1);

        // Title en
        grid.add(new Text("englischer Titel"), 0, 4);
        grid.add(titleEn, 1, 4, 3, 1);

        // Genre
        grid.add(new Text("Genre"), 0, 5);
        grid.add(genre, 1, 5);

        // Year of production
        grid.add(new Text("Produktionsjahr"), 2, 5);
        grid.add(yearProduction, 3, 5);

        // Countries
        grid.add(new Text("Land"), 0, 6);
        grid.add(countries, 1, 6);

        // Duration
        grid.add(new Text("Länge (Minuten)"), 2, 6);
        grid.add(duration, 3, 6);

        // FSK
        grid.add(new Text("FSK-Altersfreigabe"), 0, 7);
        grid.add(fsk, 1, 7);

        // Start in cinemas
        grid.add(new Text("Kinostart"), 2, 7);
        grid.add(startDate, 3, 7);

        // Oscars
        grid.add(new Text("Oscars"), 0, 8);
        grid.add(numberOscars, 1, 8, 3, 1);

        getChildren().add(grid);
    }

    private void addEventHandlers() {

    }

    private void addValueChangeListeners() {

    }

    private void addBindings() {

    }
}
