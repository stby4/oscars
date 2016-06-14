package ch.fhnw.oop.oscar.model;

import javafx.beans.property.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Movie
 * Created by Hinrich on 31.05.2016.
 */
public class Movie {
    public enum Fsk {
        ZERO(0), SIX(6), TWELVE(12), SIXTEEN(16), EIGHTEEN(18);

        private Integer value;

        Fsk(Integer value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty title = new SimpleStringProperty();
    private StringProperty titleEn = new SimpleStringProperty();
    private IntegerProperty yearAward = new SimpleIntegerProperty();
    private IntegerProperty yearProduction = new SimpleIntegerProperty();
    private StringProperty director = new SimpleStringProperty();
    private StringProperty actors = new SimpleStringProperty();
    private StringProperty countries = new SimpleStringProperty();
    private IntegerProperty duration = new SimpleIntegerProperty();
    private ObjectProperty<Fsk> fsk = new SimpleObjectProperty<>();
    private StringProperty genre = new SimpleStringProperty();
    private ObjectProperty<LocalDate> startDate = new SimpleObjectProperty<>();
    private IntegerProperty numberOscars = new SimpleIntegerProperty();
    private ObjectProperty<Boolean> edited = new SimpleObjectProperty<>();

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.uuuu");

    {
        addListeners();
    }

    /**
     * create empty movie with specified id
     * @param id id of the movie, will be used to reference posters
     */
    public Movie(int id) {
        setId(id);
        setTitle("");
        setYearAward(Calendar.getInstance().get(Calendar.YEAR));
        setDirector("");
        setActors("");
        setTitleEn("");
        setYearProduction(Calendar.getInstance().get(Calendar.YEAR));
        setCountries("");
        setDuration(90);
        setFsk(Fsk.ZERO);
        setGenre("");
        setStartDate(LocalDate.now());
        setNumberOscars(1);
    }

    /**
     * create a movie out of parsed string
     * @param line list of fields with movie values
     */
    public Movie(List<String> line) {
        setId(Integer.valueOf(line.get(0)));
        setTitle(line.get(1));
        setYearAward(Integer.valueOf(line.get(2)));
        setDirector(line.get(3));
        setActors(line.get(4));
        setTitleEn(line.get(5));
        setYearProduction(Integer.valueOf(line.get(6)));
        setCountries(line.get(7));
        setDuration(Integer.valueOf(line.get(8)));

        switch (Integer.valueOf(line.get(9))) {
            case 6:
                setFsk(Fsk.SIX);
                break;
            case 12:
                setFsk(Fsk.TWELVE);
                break;
            case 16:
                setFsk(Fsk.SIXTEEN);
                break;
            case 18:
                setFsk(Fsk.EIGHTEEN);
                break;
            default:
                setFsk(Fsk.ZERO);
        }

        setGenre(line.get(10));
        try {
            setStartDate(LocalDate.parse(line.get(11), formatter));
        } catch (DateTimeParseException e) {
            setStartDate(null);
        }
        setNumberOscars(Integer.valueOf(line.get(12)));
        setEdited(false);

        addListeners();
    }

    private void addListeners() {
        id.addListener(e -> setEdited(true));
        title.addListener(e -> setEdited(true));
        titleEn.addListener(e -> setEdited(true));
        yearAward.addListener(e -> setEdited(true));
        yearProduction.addListener(e -> setEdited(true));
        director.addListener(e -> setEdited(true));
        actors.addListener(e -> setEdited(true));
        countries.addListener(e -> setEdited(true));
        duration.addListener(e -> setEdited(true));
        fsk.addListener(e -> setEdited(true));
        genre.addListener(e -> setEdited(true));
        startDate.addListener(e -> setEdited(true));
        numberOscars.addListener(e -> setEdited(true));
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getTitleEn() {
        return titleEn.get();
    }

    public StringProperty titleEnProperty() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn.set(titleEn);
    }

    public int getYearAward() {
        return yearAward.get();
    }

    public IntegerProperty yearAwardProperty() {
        return yearAward;
    }

    public void setYearAward(int yearAward) {
        this.yearAward.set(yearAward);
    }

    public int getYearProduction() {
        return yearProduction.get();
    }

    public IntegerProperty yearProductionProperty() {
        return yearProduction;
    }

    public void setYearProduction(int yearProduction) {
        this.yearProduction.set(yearProduction);
    }

    public String getDirector() {
        return director.get();
    }

    public StringProperty directorProperty() {
        return director;
    }

    public void setDirector(String director) {
        this.director.set(director);
    }

    public String getActors() {
        return actors.get();
    }

    public StringProperty actorsProperty() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors.set(actors);
    }

    public String getCountries() {
        return countries.get();
    }

    public StringProperty countriesProperty() {
        return countries;
    }

    public void setCountries(String countries) {
        this.countries.set(countries);
    }

    public int getDuration() {
        return duration.get();
    }

    public IntegerProperty durationProperty() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration.set(duration);
    }

    public Fsk getFsk() {
        return fsk.get();
    }

    public ObjectProperty<Fsk> fskProperty() {
        return fsk;
    }

    public void setFsk(Fsk fsk) {
        this.fsk.set(fsk);
    }

    public String getGenre() {
        return genre.get();
    }

    public StringProperty genreProperty() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre.set(genre);
    }

    public LocalDate getStartDate() {
        return startDate.get();
    }

    public ObjectProperty<LocalDate> startDateProperty() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate.set(startDate);
    }

    public int getNumberOscars() {
        return numberOscars.get();
    }

    public IntegerProperty numberOscarsProperty() {
        return numberOscars;
    }

    public void setNumberOscars(int numberOscars) {
        this.numberOscars.set(numberOscars);
    }

    Boolean getEdited() {
        return edited.get();
    }

    public ObjectProperty<Boolean> editedProperty() {
        return edited;
    }

    private void setEdited(Boolean edited) {
        this.edited.set(edited);
    }


    @Override
    public String toString() {
        List<String> s = new ArrayList<>();
        s.add(String.valueOf(getId()));
        s.add(getTitle());
        s.add(String.valueOf(getYearAward()));
        s.add(getDirector());
        s.add(getActors());
        s.add(getTitleEn());
        s.add(String.valueOf(getYearProduction()));
        s.add(getCountries());
        s.add(String.valueOf(getDuration()));
        s.add(String.valueOf(getFsk()));
        s.add(getGenre());
        if (null != getStartDate()) {
            s.add(getStartDate().format(formatter));
        } else {
            s.add("-");
        }
        s.add(String.valueOf(getNumberOscars()));


        return String.join(";", s);
    }
}