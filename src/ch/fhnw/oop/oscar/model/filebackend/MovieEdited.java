package ch.fhnw.oop.oscar.model.filebackend;

/**
 * MovieEdited
 * Created by Hinrich on 07.06.2016.
 */
public class MovieEdited {
    private boolean edited;

    public MovieEdited(boolean edited) {
        this.edited = edited;
    }

    public boolean isEdited() {
        return edited;
    }

    public void setEdited(boolean edited) {
        this.edited = edited;
    }
}
