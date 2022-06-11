package homework;

import homework.entity.Command;

/**
 * The interface Navigable. You can reuse it for future implementations
 */
public interface Navigable {

    /**
     * Move the object.
     *
     * @param command the command
     */
    void move(Command command);
}