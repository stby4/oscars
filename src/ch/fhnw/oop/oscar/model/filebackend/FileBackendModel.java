package ch.fhnw.oop.oscar.model.filebackend;

import ch.fhnw.oop.oscar.model.Movie;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * FileBackendModel
 * Created by Hinrich on 31.05.2016.
 */
public class FileBackendModel {
    private ObservableList<Movie> movies = FXCollections.observableArrayList();
    private String readPath = "ressources/model/filebackend/movies.csv";
    private String rwPath = "ressources/model/filebackend/movies2.csv";


    public FileBackendModel() {
        read();
    }

    FileBackendModel(String readPath, String rwPath) {
        this.readPath = readPath;
        this.rwPath = readPath;
        read();
    }

    private void read() {
        {
            try {
                readFile(Paths.get(rwPath));
            } catch (Exception e) {
                try {
                    readFile(Paths.get(readPath));
                } catch (Exception e2) {
                    // create empty interface
                }
            }
        }
    }

    private void readFile(Path filePath) throws IOException {
        List<String> details;

        Scanner scanner = new Scanner(filePath);
        scanner.nextLine();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            details = Arrays.asList(line.split(";"));
            Movie movie = new Movie(details);
            movies.add(movie);
        }
    }

    public void writeFile() throws IOException {
        List<String> lines = new ArrayList<>();
        lines.add(0, "#id;Title;yearOfAward;director;mainActor;titleEnglish;yearOfProduction;country;duration;fsk;genre;startDate;numberOfOscars");

        movies.forEach(m -> lines.add(m.toString()));

        Path file = Paths.get(rwPath);
        Files.write(file, lines, Charset.forName("UTF-8"));
    }

    public ObservableList<Movie> getMovies() {
        return movies;
    }
}
