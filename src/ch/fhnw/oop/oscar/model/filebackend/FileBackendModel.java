package ch.fhnw.oop.oscar.model.filebackend;

import ch.fhnw.oop.oscar.model.OscarModel;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * FileBackendModel
 * Created by Hinrich on 31.05.2016.
 */
public class FileBackendModel implements OscarModel {
    public FileBackendModel() {
        readFile(Paths.get("movies.csv"));
    }

    protected void readFile(Path filePath) {
        try {
            Scanner scanner = new Scanner(filePath);
            List<String> movies = new ArrayList<>();

            while (scanner.hasNextLine()) {
                movies.add(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
