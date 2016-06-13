package ch.fhnw.oop.oscar.view.javafx;

import ch.fhnw.oop.oscar.IOscarPresenter;
import ch.fhnw.oop.oscar.model.Movie;
import ch.fhnw.oop.oscar.view.IOscarView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.util.Callback;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

/**
 * MovieFXDetails
 * Created by Hinrich on 07.06.2016.
 */
class MovieFXDetails extends BorderPane {
    private final ResourceBundle STRINGS = ResourceBundle.getBundle("view.javafx.Strings");
    private final IOscarPresenter presenter;
    private final IOscarView parent;
    private Movie movie;

    private Label yearLabel;
    private Label titleLabel;
    private Label directorLabel;
    private Label actorsLabel;
    private HBox numberOscarsHBox;
    private ImageView posterImage;
    private HBox countriesHBox;

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

    MovieFXDetails(IOscarPresenter presenter, IOscarView parent) {
        this.presenter = presenter;
        this.parent = parent;

        initializeControls();
        layoutControls();
        addEventHandlers();
    }

    public void setMovie(Movie movie) {
        this.movie = movie;

        yearLabel.textProperty().unbind();
        yearLabel.textProperty().bind(movie.yearAwardProperty().asString());
        titleLabel.textProperty().unbind();
        titleLabel.textProperty().bind(movie.titleProperty());
        actorsLabel.textProperty().unbind();
        actorsLabel.textProperty().bind(movie.actorsProperty());
        directorLabel.textProperty().unbind();
        directorLabel.textProperty().bind(movie.directorProperty());

        movie.countriesProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (null != newValue) {
                    setCountriesHBox(newValue);
                }
            }
        });
        setCountriesHBox(movie.getCountries());

        movie.numberOscarsProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (null != newValue) {
                    setOscarHBox(newValue.intValue());
                }
            }
        });

        try {
            posterImage.setImage(new Image("view/javafx/posters/" + movie.getId() + ".jpg"));
        } catch (IllegalArgumentException e) {
            posterImage.setImage(new Image("view/javafx/posters/no_poster.gif"));
        }

        year.getValueFactory().setValue(movie.getYearAward());
        title.setText(movie.getTitle());
        director.setText(movie.getDirector());
        actors.setText(movie.getActors());
        titleEn.setText(movie.getTitleEn());
        genre.setText(movie.getGenre());
        yearProduction.getValueFactory().setValue(this.movie.getYearProduction());
        countries.setText(movie.getCountries());
        duration.getValueFactory().setValue(movie.getDuration());
        fsk.setValue(movie.getFsk());
        fsk.setButtonCell((fsk.getCellFactory()).call(null));
        startDate.setValue(movie.getStartDate());
        numberOscars.getValueFactory().setValue(movie.getNumberOscars());
        setOscarHBox(movie.getNumberOscars());
    }

    private ImageView getOscarImageView() {
        ImageView oscar = new ImageView(new Image("view/javafx/Oscar-logo.png"));
        oscar.setFitHeight(40);
        oscar.setFitWidth(16);
        return oscar;
    }

    private void setOscarHBox(int numberOscars) {
        // have to use children count of HBOX because... reasons (Java)
        int difference = numberOscars - numberOscarsHBox.getChildren().size();
        if (0 < difference) {
            for (int i = 0; i < difference; i++) {
                numberOscarsHBox.getChildren().add(getOscarImageView());
            }
        } else if (0 > difference) {
            for (int i = 0; i < -difference; i++) {
                numberOscarsHBox.getChildren().remove(numberOscarsHBox.getChildren().size() - 1);
            }
        }
    }

    private ImageView getCountryImageView(String country) {
        ImageView countryIV = new ImageView(new Image("view/javafx/flags/" + country.toLowerCase() + ".png"));
        countryIV.setFitHeight(24);
        countryIV.setFitWidth(24);
        return countryIV;
    }

    private void setCountriesHBox(String countriesString) {
        countriesHBox.getChildren().clear();
        List<String> countries = Arrays.asList(countriesString.split("/"));
        countries.forEach(ctr -> {
            try {
                countriesHBox.getChildren().add(getCountryImageView(ctr));
            } catch (IllegalArgumentException e) {
                // ignore the invalid country string
            }
        });
    }

    private void initializeControls() {
        // poster area
        yearLabel = new Label();
        countriesHBox = new HBox();
        titleLabel = new Label();
        directorLabel = new Label();
        actorsLabel = new Label();
        numberOscarsHBox = new HBox();
        posterImage = new ImageView();

        // edit area
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
        fsk.getItems().addAll(0, 6, 12, 16, 18);
        fsk.setCellFactory(new Callback<ListView<Integer>, ListCell<Integer>>() {
            @Override
            public ListCell<Integer> call(ListView<Integer> param) {
                return new ListCell<Integer>() {
                    @Override
                    protected void updateItem(Integer item, boolean empty) {
                        super.updateItem(item, empty);

                        if (null == item || empty) {
                            setGraphic(null);
                        } else {
                            ImageView fskImage = new ImageView(new Image("view/javafx/fsk_labels/FSK_ab_" + item + "_logo_Dec_2008.svg.png", true));
                            setGraphic(fskImage);
                        }
                    }
                };
            }
        });

        startDate = new DatePicker();
        numberOscars = new Spinner<>();
        numberOscars.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100));
    }

    private void layoutControls() {
        // poster area
        countriesHBox.setMinHeight(24);
        yearLabel.setId("details_year");
        BorderPane top = new BorderPane();
        top.setLeft(yearLabel);
        top.setRight(countriesHBox);
        top.setMaxWidth(Double.MAX_VALUE);
        top.setPadding(new Insets(0, 10, 0, 0));

        titleLabel.setId("details_title");
        directorLabel.setId("details_director");
        actorsLabel.setId("details_actors");
        VBox left = new VBox();
        left.getChildren().add(0, top);
        left.getChildren().add(1, titleLabel);
        left.getChildren().add(2, directorLabel);
        left.getChildren().add(3, actorsLabel);
        left.getChildren().add(4, numberOscarsHBox);
        numberOscarsHBox.setMinHeight(40);
        numberOscarsHBox.setPadding(new Insets(0, 2, 0, 2));

        BorderPane poster = new BorderPane();
        poster.setPadding(new Insets(20));
        poster.setMaxWidth(Double.MAX_VALUE);
        //poster.setPrefWidth(Double.MAX_VALUE);
        //BorderPane.setHgrow(poster, Priority.ALWAYS);
        posterImage.setFitHeight(237);
        posterImage.setPreserveRatio(true);

        poster.setCenter(left);
        poster.setRight(posterImage);

        // edit area
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setMaxWidth(Double.MAX_VALUE);
        GridPane.setHgrow(grid, Priority.ALWAYS);

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
        fsk.setMinSize(102, 72);
        grid.add(fsk, 1, 7);

        // Start in cinemas
        grid.add(new Text(STRINGS.getString("StartDate")), 2, 7);
        grid.add(startDate, 3, 7);

        // Oscars
        grid.add(new Text(STRINGS.getString("Oscars")), 0, 8);
        grid.add(numberOscars, 1, 8, 3, 1);

        setTop(poster);
        setBottom(grid);
        setPrefWidth(550);
        setMaxSize(700, Double.MAX_VALUE);
    }

    private void addEventHandlers() {

        year.valueProperty().addListener((v, o, n) -> presenter.onYearAwardChanged(movie, o, n));
        title.textProperty().addListener((v, o, n) -> presenter.onTitleChanged(movie, o, n));
        director.textProperty().addListener((v, o, n) -> presenter.onDirectorChanged(movie, o, n));
        actors.textProperty().addListener((v, o, n) -> presenter.onActorsChanged(movie, o, n));
        titleEn.textProperty().addListener((v, o, n) -> presenter.onTitleEnChanged(movie, o, n));
        genre.textProperty().addListener((v, o, n) -> presenter.onGenreChanged(movie, o, n));
        yearProduction.valueProperty().addListener((v, o, n) -> presenter.onYearProductionChanged(movie, o, n));
        countries.textProperty().addListener((v, o, n) -> presenter.onCountriesChanged(movie, o, n));
        duration.valueProperty().addListener((v, o, n) -> presenter.onDurationChanged(movie, o, n));
        fsk.valueProperty().addListener((v, o, n) -> presenter.onFskChanged(movie, o, n));
        startDate.valueProperty().addListener((v, o, n) -> presenter.onStartDateChanged(movie, o, n));
        numberOscars.valueProperty().addListener((v, o, n) -> presenter.onNumberOscarsChanged(movie, o, n));
    }

    private void addValueChangeListeners() {
    }

    private void addBindings() {

    }

    private void setNumberOfOscars(int numberOfOscars) {
        //oscarsHBox.getChildren().clear();
    }
}
