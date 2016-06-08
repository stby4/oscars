package ch.fhnw.oop.oscar.view.javafx;

import ch.fhnw.oop.oscar.IOscarPresenter;
import ch.fhnw.oop.oscar.model.Movie;
import javafx.beans.property.IntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.ResourceBundle;

/**
 * MovieFXDetails
 * Created by Hinrich on 07.06.2016.
 */
public class MovieFXDetails extends VBox {
    private final ResourceBundle STRINGS =  ResourceBundle.getBundle("view.javafx.Strings");
    IOscarPresenter presenter;
    Movie movie;

    private Spinner<Integer> year;
    private TextField title;
    private TextField director;
    private TextField actors;
    private TextField titleEn;
    private TextField genre;
    private Spinner<Integer> yearProduction;
    private TextField countries;
    private Spinner<Integer> duration;
    private ComboBox<Integer> fsk;
    private DatePicker startDate;
    private Spinner<Integer> numberOscars;

    public MovieFXDetails(IOscarPresenter presenter) {
        this.presenter = presenter;
        initializeControls();
        layoutControls();
        addEventHandlers();
    }

    public void setMovie(Movie movie) {
        this.movie = movie;

        year.getValueFactory().setValue(movie.getYearAward());
        title.setText(movie.getTitle());
        director.setText(movie.getDirector());
        actors.setText(movie.getActors());
        titleEn.setText(movie.getTitleEn());
        genre.setText(movie.getGenre());
        yearProduction.getValueFactory().setValue(this.movie.getYearProduction());
        countries.setText(movie.getCountries());
        duration.getValueFactory().setValue(movie.getDuration());
        // fsk
        startDate.setValue(movie.getStartDate());
        numberOscars.getValueFactory().setValue(movie.getNumberOscars());
    }

    private void initializeControls() {
        // Year
        year = new Spinner<>();
        year.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Calendar.getInstance().get(Calendar.YEAR)));

        title = new TextField();
        director = new TextField();
        actors = new TextField();
        titleEn = new TextField();
        genre = new TextField();

        // Year production
        yearProduction = new Spinner<>();
        yearProduction.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Calendar.getInstance().get(Calendar.YEAR)));

        countries = new TextField();

        duration = new Spinner<>();
        duration.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Integer.MAX_VALUE));

        fsk = new ComboBox<>();
        startDate = new DatePicker();
        numberOscars = new Spinner<>();
        numberOscars.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100));
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

        year.valueProperty().addListener((v, o, n) -> presenter.onYearAwardChanged(movie, n));
        title.textProperty().addListener((v, o, n) -> presenter.onTitleChanged(movie, n));
        director.textProperty().addListener((v, o, n) -> presenter.onDirectorChanged(movie, n));
        actors.textProperty().addListener((v, o, n) -> presenter.onActorsChanged(movie, n));
        titleEn.textProperty().addListener((v, o, n) -> presenter.onTitleEnChanged(movie, n));
        genre.textProperty().addListener((v, o, n) -> presenter.onGenreChanged(movie, n));
        yearProduction.valueProperty().addListener((v, o, n) -> presenter.onYearProductionChanged(movie, n));
        countries.textProperty().addListener((v, o, n) -> presenter.onCountriesChanged(movie, n));
        duration.valueProperty().addListener((v, o, n) -> presenter.onDurationChanged(movie, n));
        fsk.valueProperty().addListener((v, o, n) -> presenter.onFskChanged(movie, n));
        startDate.valueProperty().addListener((v, o, n) -> presenter.onStartDateChanged(movie, n));
        numberOscars.valueProperty().addListener((v, o, n) -> presenter.onNumberOscatsChanged(movie, n));
    }

    private void addValueChangeListeners() {

    }

    private void addBindings() {

    }

    private void setNumberOfOscars(int numberOfOscars) {
        //oscarsHBox.getChildren().clear();
    }
}
