package ch.fhnw.oop.oscar.controller;

import ch.fhnw.oop.oscar.model.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * test for controller and commands
 * Created by hinri on 14.06.2016.
 */
public class OscarControllerTest {
    private OscarController oc;
    private ObservableList<Movie> movies;

    @Before
    public void setUp() throws Exception {
        oc = new OscarController();

        movies = FXCollections.observableArrayList();
        movies.add(new Movie(Arrays.asList("62;Das Schweigen der Lämmer;1992;Jonathan Demme;Jodie Foster, Anthony Hopkins;The Silence of the Lambs;1991;US;118;16;Horrorfilm, Kriminalfilm, Thriller;11.04.1991;1".split(";"))));
        movies.add(new Movie(Arrays.asList("75;Million Dollar Baby;2005;Clint Eastwood;Clint Eastwood, Hilary Swank;Million Dollar Babe;2004;US;133;12;Drama, Sportfilm;24.03.2005;4".split(";"))));


    }

    @After
    public void tearDown() throws Exception {
        oc = null;
    }

    @Test
    public void executeUndo() throws Exception {
        oc.execute(3);
        assertEquals(0, oc.getUndoList().size());
        assertEquals(0, oc.getExecuteList().size());

        oc.undo(2);
        assertEquals(0, oc.getUndoList().size());
        assertEquals(0, oc.getExecuteList().size());


        assertEquals(2, movies.size());
        oc.addMovie(movies);
        assertEquals(3, movies.size());
        assertEquals(83, movies.get(2).getId());

        oc.setTitle(movies.get(2), "", "Inception");
        oc.setTitle(movies.get(2), "Inception", "Incebtion");
        assertEquals("Incebtion", movies.get(2).getTitle());

        assertEquals(3, oc.getExecuteList().size());

        oc.undo(1);
        assertEquals("Inception", movies.get(2).getTitle());

        assertEquals(1, oc.getUndoList().size());
        assertEquals(2, oc.getExecuteList().size());

        oc.execute(2);

        assertEquals(0, oc.getUndoList().size());
        assertEquals(3, oc.getExecuteList().size());


        oc.undo(1000);
        assertEquals(2, movies.size());
        assertEquals(3, oc.getUndoList().size());
        assertEquals(0, oc.getExecuteList().size());
    }

    @Test
    public void addMovie() throws Exception {
        oc.addMovie(movies);
        assertEquals(3, movies.size());
        oc.undo(1);
        assertEquals(2, movies.size());
    }

    @Test
    public void deleteMovie() throws Exception {
        oc.deleteMovie(movies, movies.get(0));
        assertEquals(1, movies.size());
        assertEquals("Clint Eastwood, Hilary Swank", movies.get(0).getActors());

        oc.undo(1);
        assertEquals(2, movies.size());
    }

    @Test
    public void setTitle() throws Exception {
        oc.setTitle(movies.get(1), movies.get(1).getTitle(), "Thousand Dollar Baby");
        assertEquals("Thousand Dollar Baby", movies.get(1).getTitle());
        assertEquals(1, oc.getExecuteList().size());

        oc.undo(1);
        assertEquals("Million Dollar Baby", movies.get(1).getTitle());
    }

    @Test
    public void setYearAward() throws Exception {
        int origYear = movies.get(1).getYearAward();

        oc.setYearAward(movies.get(1), movies.get(1).getYearAward(), 2006);
        assertEquals(2006, movies.get(1).getYearAward());
        assertEquals(1, oc.getExecuteList().size());

        oc.undo(1);
        assertEquals(origYear, movies.get(1).getYearAward());
    }

    @Test
    public void setActors() throws Exception {
        String origActors = movies.get(1).getActors();

        oc.setActors(movies.get(1), movies.get(1).getActors(), "Peter");
        assertEquals("Peter", movies.get(1).getActors());
        assertEquals(1, oc.getExecuteList().size());

        oc.undo(1);
        assertEquals(origActors, movies.get(1).getActors());
    }

    @Test
    public void setDirector() throws Exception {
        String origDirector = movies.get(1).getDirector();

        oc.setDirector(movies.get(1), movies.get(1).getDirector(), "Hans");
        assertEquals("Hans", movies.get(1).getDirector());
        assertEquals(1, oc.getExecuteList().size());

        oc.undo(1);
        assertEquals(origDirector, movies.get(1).getDirector());
    }

    @Test
    public void setTitleEn() throws Exception {
        String origTitleEn = movies.get(1).getTitleEn();

        oc.setTitleEn(movies.get(1), movies.get(1).getTitleEn(), "50 cent baby");
        assertEquals("50 cent baby", movies.get(1).getTitleEn());
        assertEquals(1, oc.getExecuteList().size());

        oc.undo(1);
        assertEquals(origTitleEn, movies.get(1).getTitleEn());
    }

    @Test
    public void setYearProduction() throws Exception {
        int origYear = movies.get(1).getYearProduction();

        oc.setYearProduction(movies.get(1), movies.get(1).getYearProduction(), 2001);
        assertEquals(2001, movies.get(1).getYearProduction());
        assertEquals(1, oc.getExecuteList().size());

        oc.undo(1);
        assertEquals(origYear, movies.get(1).getYearProduction());
    }

    @Test
    public void setCountries() throws Exception {
        String origCountries = movies.get(1).getCountries();

        oc.setCountries(movies.get(1), movies.get(1).getCountries(), "DE/EN/US");
        assertEquals("DE/EN/US", movies.get(1).getCountries());
        assertEquals(1, oc.getExecuteList().size());

        oc.undo(1);
        assertEquals(origCountries, movies.get(1).getCountries());
    }

    @Test
    public void setDuration() throws Exception {
        int origDuration = movies.get(1).getDuration();

        oc.setDuration(movies.get(1), movies.get(1).getDuration(), 105);
        assertEquals(105, movies.get(1).getDuration());
        assertEquals(1, oc.getExecuteList().size());

        oc.undo(1);
        assertEquals(origDuration, movies.get(1).getDuration());
    }

    @Test
    public void setFsk() throws Exception {
        int origFsk = movies.get(1).getFsk();

        oc.setFsk(movies.get(1), movies.get(1).getFsk(), 0);
        assertEquals(0, movies.get(1).getFsk());
        assertEquals(1, oc.getExecuteList().size());

        oc.undo(1);
        assertEquals(origFsk, movies.get(1).getFsk());
    }

    @Test
    public void setGenre() throws Exception {
        String origGenre = movies.get(1).getGenre();

        oc.setGenre(movies.get(1), movies.get(1).getGenre(), "Komödie");
        assertEquals("Komödie", movies.get(1).getGenre());
        assertEquals(1, oc.getExecuteList().size());

        oc.undo(1);
        assertEquals(origGenre, movies.get(1).getGenre());
    }

    @Test
    public void setStartDate() throws Exception {
        LocalDate origDate = movies.get(0).getStartDate();

        LocalDate now = LocalDate.now();
        oc.setStartDate(movies.get(0), movies.get(0).getStartDate(), now);
        assertEquals(now, movies.get(0).getStartDate());
        assertEquals(1, oc.getExecuteList().size());

        oc.undo(1);

        assertEquals(origDate, movies.get(0).getStartDate());
    }

    @Test
    public void setNumberOscars() throws Exception {
        int origOscars = movies.get(1).getNumberOscars();

        oc.setNumberOscars(movies.get(1), movies.get(1).getNumberOscars(), 5);
        assertEquals(5, movies.get(1).getNumberOscars());
        assertEquals(1, oc.getExecuteList().size());

        oc.undo(1);
        assertEquals(origOscars, movies.get(1).getNumberOscars());
    }

}