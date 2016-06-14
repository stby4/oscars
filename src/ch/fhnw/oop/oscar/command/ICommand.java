package ch.fhnw.oop.oscar.command;

/**
 * a command
 * Created by Hinrich on 12.06.2016.
 */
public interface ICommand {
    /**
     * executes a command
     */
    void execute();

    /**
     * undo a command
     */
    void undo();

    /**
     * get description of command
     * @return String description of command
     */
    String getDescription();
}
