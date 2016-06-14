package ch.fhnw.oop.oscar;

import ch.fhnw.oop.oscar.command.ICommand;
import ch.fhnw.oop.oscar.model.Movie;
import ch.fhnw.oop.oscar.model.filebackend.FileBackendModel;
import ch.fhnw.oop.oscar.view.IOscarView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Presenter Test
 * Created by hinri on 14.06.2016.
 */
public class OscarPresenterTest {
    private IOscarPresenter presenter;
    private ObservableList<Movie> movies;


    @Before
    public void setUp() throws Exception {
        movies = FXCollections.observableArrayList();
        movies.add(new Movie(Arrays.asList("62;Das Schweigen der Lämmer;1992;Jonathan Demme;Jodie Foster, Anthony Hopkins;The Silence of the Lambs;1991;US;118;16;Horrorfilm, Kriminalfilm, Thriller;11.04.1991;1".split(";"))));
        movies.add(new Movie(Arrays.asList("75;Million Dollar Baby;2005;Clint Eastwood;Clint Eastwood, Hilary Swank;Million Dollar Babe;2004;US;133;12;Drama, Sportfilm;24.03.2005;4".split(";"))));


        presenter = new OscarPresenter(new IOscarView() {
            Movie selectedMovie;
            ObservableList<Movie> movies;

            @Override
            public void setMovies(ObservableList<Movie> movies) {
                this.movies = movies;
            }

            @Override
            public void onMovieSelected(Movie movie) {
                selectedMovie = movie;
            }

            @Override
            public Movie getSelectedMovie() {
                return selectedMovie;
            }
        });
    }

    @After
    public void tearDown() throws Exception {
        presenter = null;
        movies = null;
    }

    @Test
    public void getExecuteList() throws Exception {
        assertTrue(presenter.getExecuteList() instanceof ObservableList);
        assertEquals(0, presenter.getExecuteList().size());
    }

    @Test
    public void getUndoList() throws Exception {
        assertTrue(presenter.getUndoList() instanceof ObservableList);
        assertEquals(0, presenter.getUndoList().size());
    }

    @Test
    public void filterMovies() throws Exception {
        FilteredList<Movie> movieFilteredList = new FilteredList<>(movies, p -> true);

        presenter.filterMovies(movieFilteredList, "Million Dollar Baby");
        assertEquals(1, movieFilteredList.size());
        assertEquals("Clint Eastwood", movieFilteredList.get(0).getDirector());

        presenter.filterMovies(movieFilteredList, "");
        assertEquals(2, movieFilteredList.size());

        presenter.filterMovies(movieFilteredList, "fsogdnvl8wrmv3 l48573b2 lr4nreiv");
        assertEquals(0, movieFilteredList.size());
    }
}