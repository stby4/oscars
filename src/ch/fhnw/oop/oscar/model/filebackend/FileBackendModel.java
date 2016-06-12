package ch.fhnw.oop.oscar.model.filebackend;

import ch.fhnw.oop.oscar.model.Movie;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * FileBackendModel
 * Created by Hinrich on 31.05.2016.
 */
public class FileBackendModel {
    private ObservableList<Movie> movies = FXCollections.observableArrayList();

    public FileBackendModel() {
        readFile(Paths.get("ressources/model/filebackend/movies.csv"));
    }

    private void readFile(Path filePath) {
        List<String> details;

        try {
            Scanner scanner = new Scanner(filePath);
            scanner.nextLine();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                details = Arrays.asList(line.split(";"));
                Movie movie = new Movie(details);
                movies.add(movie);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<Movie> getMovies() {
        return movies;
    }
}
