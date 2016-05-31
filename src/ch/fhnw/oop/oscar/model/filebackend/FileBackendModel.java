package ch.fhnw.oop.oscar.model.filebackend;

import ch.fhnw.oop.oscar.model.Movie;
import ch.fhnw.oop.oscar.model.OscarModel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * FileBackendModel
 * Created by Hinrich on 31.05.2016.
 */
public class FileBackendModel implements OscarModel {
    private Map<Integer, Movie> movies = new HashMap<>();

    public FileBackendModel() {
        readFile(Paths.get("ressources/model/filebackend/movies.csv"));

        File file = new File("movies.csv");
        file.getAbsolutePath();

    }

    private void readFile(Path filePath) {
        List<String> details = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(filePath);
            scanner.nextLine();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                details = Arrays.asList(line.split(";"));
                Movie movie = new Movie(details);
                movies.put(movie.getId(), movie);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Movie getMovie(int id) {
        return movies.get(id);
    }
}
