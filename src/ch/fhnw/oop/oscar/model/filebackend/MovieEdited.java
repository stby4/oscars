package ch.fhnw.oop.oscar.model.filebackend;

/**
 * MovieEdited
 * Created by Hinrich on 07.06.2016.
 */
public class MovieEdited {
    private Boolean edited;

    public MovieEdited(Boolean edited) {
        this.edited = edited;
    }

    public boolean isEdited() {
        return edited;
    }

    public void setEdited(Boolean edited) {
        this.edited = edited;
    }
}
