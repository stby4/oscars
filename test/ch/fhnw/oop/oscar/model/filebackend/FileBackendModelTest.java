package ch.fhnw.oop.oscar.model.filebackend;

import ch.fhnw.oop.oscar.model.Movie;
import javafx.collections.ObservableList;
import org.junit.Test;

import java.nio.file.Paths;

import static org.junit.Assert.*;

/**
 * test movie file backend
 * Created by hinri on 14.06.2016.
 */
public class FileBackendModelTest {
    @Test
    public void getMovies() throws Exception {
        FileBackendModel fbm = new FileBackendModel("ressources/model/filebackend/moviesTest.csv", "ressources/model/filebackend/moviesTestOut.csv");
        ObservableList<Movie> movies = fbm.getMovies();

        assertEquals(5, movies.size());

        assertEquals("Im Westen nichts Neues", movies.get(1).getTitle());
    }

}