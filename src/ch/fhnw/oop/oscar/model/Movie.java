package ch.fhnw.oop.oscar.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Movie
 * Created by Hinrich on 31.05.2016.
 */
public class Movie {
    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty title = new SimpleStringProperty();
    private StringProperty titleEn = new SimpleStringProperty();
    private IntegerProperty yearAward = new SimpleIntegerProperty();
    private IntegerProperty yearProduction = new SimpleIntegerProperty();
    private StringProperty director = new SimpleStringProperty();
    private StringProperty actors = new SimpleStringProperty();
    private StringProperty countries = new SimpleStringProperty();
    private IntegerProperty duration = new SimpleIntegerProperty();
    private IntegerProperty fsk = new SimpleIntegerProperty();
    private StringProperty genre = new SimpleStringProperty();
    private StringProperty startDate = new SimpleStringProperty();
    private IntegerProperty numberOscars = new SimpleIntegerProperty();

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
        setFsk(Integer.valueOf(line.get(9)));
        setGenre(line.get(10));
        setStartDate(line.get(11));
        setNumberOscars(Integer.valueOf(line.get(12)));
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

    public int getFsk() {
        return fsk.get();
    }

    public IntegerProperty fskProperty() {
        return fsk;
    }

    public void setFsk(int fsk) {
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

    public String getStartDate() {
        return startDate.get();
    }

    public StringProperty startDateProperty() {
        return startDate;
    }

    public void setStartDate(String startDate) {
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
}
