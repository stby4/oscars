package ch.fhnw.oop.oscar.view.javafx;

import ch.fhnw.oop.oscar.model.Movie;
import ch.fhnw.oop.oscar.view.OscarView;
import javafx.beans.property.IntegerProperty;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.Date;
import java.util.ResourceBundle;

/**
 * MovieFXDetails
 * Created by Hinrich on 07.06.2016.
 */
public class MovieFXDetails extends VBox {
    private final ResourceBundle STRINGS =  ResourceBundle.getBundle("view.javafx.Strings");
    OscarView parent;
    Movie movie;

    private Spinner<Integer> year;
    private TextField title;
    private TextField director;
    private TextField actors;
    private TextField titleEn;
    private TextField genre;
    private Spinner<IntegerProperty> yearProduction;
    private TextField countries;
    private Spinner<IntegerProperty> duration;
    private ComboBox<IntegerProperty> fsk;
    private DatePicker startDate;
    private Spinner<IntegerProperty> numberOscars;

    public MovieFXDetails(OscarView parent) {
        this.parent = parent;
        initializeControls();
        layoutControls();
        addEventHandlers();
    }

    public void setMovie(Movie movie) {
        if(null != this.movie) {
            this.movie.yearAwardProperty().unbind();
            this.movie.titleProperty().unbind();
            this.movie.directorProperty().unbind();
            this.movie.actorsProperty().unbind();
        }
        this.movie = movie;

        year.getValueFactory().setValue(this.movie.getYearAward());
        title.setText(this.movie.getTitle());
        actors.setText(this.movie.getActors());
        director.setText(this.movie.getDirector());
    }

    private void initializeControls() {
        // Year
        year = new Spinner<>();
        // TODO make it future proof
        year.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Integer.MAX_VALUE));
        year.setEditable(true);
        title = new TextField();
        director = new TextField();
        actors = new TextField();
        titleEn = new TextField();
        genre = new TextField();

        // Year production
        yearProduction = new Spinner<>();
        countries = new TextField();
        duration = new Spinner<>();
        fsk = new ComboBox<>();
        startDate = new DatePicker();
        numberOscars = new Spinner<>();
    }

    private void layoutControls() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setMaxWidth(Double.MAX_VALUE);

        // Year
        grid.add(new Text(STRINGS.getString("Year")), 0, 0);
        grid.add(year, 1, 0, 3, 1);

        // Title
        grid.add(new Text(STRINGS.getString("Title")), 0, 1);
        grid.add(title, 1, 1, 3, 1);

        // Director
        grid.add(new Text(STRINGS.getString("Director")), 0, 2);
        grid.add(director, 1, 2, 3, 1);

        // Actors
        grid.add(new Text(STRINGS.getString("Actors")), 0, 3);
        grid.add(actors, 1, 3, 3, 1);

        // Title en
        grid.add(new Text(STRINGS.getString("EnglishTitle")), 0, 4);
        grid.add(titleEn, 1, 4, 3, 1);

        // Genre
        grid.add(new Text(STRINGS.getString("Genre")), 0, 5);
        grid.add(genre, 1, 5);

        // Year of production
        grid.add(new Text(STRINGS.getString("ProductionYear")), 2, 5);
        grid.add(yearProduction, 3, 5);

        // Countries
        grid.add(new Text(STRINGS.getString("Country")), 0, 6);
        grid.add(countries, 1, 6);

        // Duration
        grid.add(new Text(STRINGS.getString("DurationMinutes")), 2, 6);
        grid.add(duration, 3, 6);

        // FSK
        grid.add(new Text(STRINGS.getString("FSKRating")), 0, 7);
        grid.add(fsk, 1, 7);

        // Start in cinemas
        grid.add(new Text(STRINGS.getString("StartDate")), 2, 7);
        grid.add(startDate, 3, 7);

        // Oscars
        grid.add(new Text(STRINGS.getString("Oscars")), 0, 8);
        grid.add(numberOscars, 1, 8, 3, 1);

        getChildren().add(grid);
    }

    private void addEventHandlers() {

    }

    private void addValueChangeListeners() {

    }

    private void addBindings() {

    }

    private void setNumberOfOscars(int numberOfOscars) {
        //oscarsHBox.getChildren().clear();
    }
}
