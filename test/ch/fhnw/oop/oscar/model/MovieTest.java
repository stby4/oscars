package ch.fhnw.oop.oscar.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Test for Movie class
 * Created by hinri on 14.06.2016.
 */
public class MovieTest {
    private Movie movie;

    @Before
    public void setUp() throws Exception {
        movie = new Movie(12);
    }

    @After
    public void tearDown() throws Exception {
        movie = null;
    }

    @Test
    public void testGetterSetter() {
        assertEquals(12, movie.getId());
        movie.setId(42);
        assertEquals(42, movie.getId());

        movie.setTitle("Per Anhalter durch die Galaxis");
        assertEquals("Per Anhalter durch die Galaxis", movie.getTitle());

        movie.setTitleEn("The Hitchhiker's Guide to the Galaxy");
        assertEquals("The Hitchhiker's Guide to the Galaxy", movie.getTitleEn());

        movie.setYearAward(2005);
        assertEquals(2005, movie.getYearAward());

        movie.setYearProduction(2004);
        assertEquals(2004, movie.getYearProduction());

        movie.setDirector("Garth Jennings");
        assertEquals("Garth Jennings", movie.getDirector());

        movie.setActors("Martin Freeman, Sam Rockwell, Mos Def, Zooey Deschanel, Bill Nighy");
        assertEquals("Martin Freeman, Sam Rockwell, Mos Def, Zooey Deschanel, Bill Nighy", movie.getActors());

        movie.setCountries("UK/US");
        assertEquals("UK/US", movie.getCountries());

        movie.setDuration(109);
        assertEquals(109, movie.getDuration());

        movie.setFsk(6);
        assertEquals(6, movie.getFsk());

        movie.setGenre("Comedy");
        assertEquals("Comedy", movie.getGenre());

        movie.setStartDate(LocalDate.of(2005, 4, 28));
        assertEquals(LocalDate.of(2005, 4, 28), movie.getStartDate());

        movie.setNumberOscars(12);
        assertEquals(12, movie.getNumberOscars());
    }

    @Test
    public void testListener() {
        movie.titleProperty().set("Per Anhalter durch die Galaxis");
        assertEquals(true, movie.getEdited());
    }

    @Test
    public void testConstructor() {
        this.movie = null;

        String line = "75;Million Dollar Baby;2005;Clint Eastwood;Clint Eastwood, Hilary Swank;Million Dollar Babe;2004;US;133;12;Drama, Sportfilm;24.03.2005;4";
        movie = new Movie(Arrays.asList(line.split(";")));

        assertEquals(75, movie.getId());
        assertEquals(2005, movie.getYearAward());
        assertEquals("Clint Eastwood", movie.getDirector());
        assertEquals("Clint Eastwood, Hilary Swank", movie.getActors());
        assertEquals("Million Dollar Baby", movie.getTitle());
        assertEquals("Million Dollar Babe", movie.getTitleEn());
        assertEquals(2004, movie.getYearProduction());
        assertEquals("US", movie.getCountries());
        assertEquals(133, movie.getDuration());
        assertEquals(12, movie.getFsk());
        assertEquals("Drama, Sportfilm", movie.getGenre());
        assertEquals(LocalDate.of(2005, 3, 24), movie.getStartDate());
        assertEquals(4, movie.getNumberOscars());
    }
}