package ch.fhnw.oop.oscar.view.javafx;

import ch.fhnw.oop.oscar.IOscarPresenter;
import ch.fhnw.oop.oscar.model.Movie;
import ch.fhnw.oop.oscar.view.IOscarView;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.util.Callback;

import java.time.LocalDate;
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

    private ChangeListener<Integer> yearChanged;
    private ChangeListener<String> titleChanged;
    private ChangeListener<String> directorChanged;
    private ChangeListener<String> actorsChanged;
    private ChangeListener<String> titleEnChanged;
    private ChangeListener<String> genreChanged;
    private ChangeListener<Integer> yearProductionChanged;
    private ChangeListener<String> countriesChanged;
    private ChangeListener<Integer> durationChanged;
    private ChangeListener<Integer> fskChanged;
    private ChangeListener<LocalDate> startDateChanged;
    private ChangeListener<Integer> numberOscarsChanged;

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
        addListeners();
        setDisable(true);
    }

    public void setMovie(Movie movie) {
        yearLabel.textProperty().unbind();
        titleLabel.textProperty().unbind();
        directorLabel.textProperty().unbind();
        removeListeners();

        if (null != movie) {
            this.movie = movie;

            yearLabel.textProperty().bind(movie.yearAwardProperty().asString());
            titleLabel.textProperty().bind(movie.titleProperty());

            setActorsLabel();
            this.movie.actorsProperty().addListener((v, o, n) -> {
                if (null != n && !n.equals("")) {
                    setActorsLabel();
                } else {
                    actorsLabel.setText("");
                }
            });

            setDirectorLabel();
            this.movie.directorProperty().addListener((v, o, n) -> {
                if (null != n && !n.equals("")) {
                    setDirectorLabel();
                } else {
                    directorLabel.setText("");
                }
            });

            movie.countriesProperty().addListener((v, o, n) -> {
                if (null != n) {
                    setCountriesHBox(n);
                }
            });
            setCountriesHBox(movie.getCountries());

            movie.numberOscarsProperty().addListener((v, o, n) -> {
                if (null != n) {
                    setOscarHBox(n.intValue());
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

        setDisable(null == movie);

        addListeners();
    }

    private void setActorsLabel() {
        actorsLabel.setText(String.format(STRINGS.getString("WithActors"), movie.getActors()));
    }

    private void setDirectorLabel() {
        directorLabel.setText(String.format(STRINGS.getString("FromDirector"), movie.getDirector()));
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
            } catch (Exception e) {
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
        numberOscars.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 24));
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
        setMaxSize(600, Double.MAX_VALUE);
    }

    private void removeEventHandlers() {
    }

    private void addListeners() {
        disabledProperty().addListener((v, o, n) -> {
            if (n) {
                movie = null;
                yearLabel.setText("");
                titleLabel.setText("");
                directorLabel.setText("");
                actorsLabel.setText("");
                numberOscarsHBox.getChildren().clear();
                posterImage.setImage(null);
                countriesHBox.getChildren().clear();

                if (null != year.getValueFactory()) {
                    year.getValueFactory().setValue(0);
                }
                title.setText("");
                director.setText("");
                actors.setText("");
                titleEn.setText("");
                genre.setText("");
                if (null != yearProduction) {
                    yearProduction.getValueFactory().setValue(0);
                }
                countries.setText("");
                if (null != duration.getValueFactory()) {
                    duration.getValueFactory().setValue(0);
                }
                fsk.setValue(0);
                startDate.setValue(null);
                if (null != numberOscars.getValueFactory()) {
                    numberOscars.getValueFactory().setValue(0);
                }
            }
        });

        yearChanged = (v, o, n) -> presenter.onYearAwardChanged(movie, o, n);
        year.valueProperty().addListener(yearChanged);

        titleChanged = (v, o, n) -> presenter.onTitleChanged(movie, o, n);
        title.textProperty().addListener(titleChanged);

        directorChanged = (v, o, n) -> presenter.onDirectorChanged(movie, o, n);
        director.textProperty().addListener(directorChanged);

        actorsChanged = (v, o, n) -> presenter.onActorsChanged(movie, o, n);
        actors.textProperty().addListener(actorsChanged);

        titleEnChanged = (v, o, n) -> presenter.onTitleEnChanged(movie, o, n);
        titleEn.textProperty().addListener(titleEnChanged);

        genreChanged = (v, o, n) -> presenter.onGenreChanged(movie, o, n);
        genre.textProperty().addListener(genreChanged);

        yearProductionChanged = (v, o, n) -> presenter.onYearProductionChanged(movie, o, n);
        yearProduction.valueProperty().addListener(yearProductionChanged);

        countriesChanged = (v, o, n) -> presenter.onCountriesChanged(movie, o, n);
        countries.textProperty().addListener(countriesChanged);

        durationChanged = (v, o, n) -> presenter.onDurationChanged(movie, o, n);
        duration.valueProperty().addListener(durationChanged);

        fskChanged = (v, o, n) -> presenter.onFskChanged(movie, o, n);
        fsk.valueProperty().addListener(fskChanged);

        startDateChanged = (v, o, n) -> presenter.onStartDateChanged(movie, o, n);
        startDate.valueProperty().addListener(startDateChanged);

        numberOscarsChanged = (v, o, n) -> presenter.onNumberOscarsChanged(movie, o, n);
        numberOscars.valueProperty().addListener(numberOscarsChanged);
    }

    private void removeListeners() {
        year.valueProperty().removeListener(yearChanged);
        title.textProperty().removeListener(titleChanged);
        director.textProperty().removeListener(directorChanged);
        actors.textProperty().removeListener(actorsChanged);
        titleEn.textProperty().removeListener(titleEnChanged);
        genre.textProperty().removeListener(genreChanged);
        yearProduction.valueProperty().removeListener(yearProductionChanged);
        countries.textProperty().removeListener(countriesChanged);
        duration.valueProperty().removeListener(durationChanged);
        fsk.valueProperty().removeListener(fskChanged);
        startDate.valueProperty().removeListener(startDateChanged);
        numberOscars.valueProperty().removeListener(numberOscarsChanged);
    }
}
