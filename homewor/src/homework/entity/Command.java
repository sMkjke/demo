package homework.entity;

/**
 * The enum Command.
 */
public enum Command {
    U("u"), D("d"), L("l"), R("r"), EXIT("exit");

    final String command;

    Command(final String command) {
        this.command = command;
    }

}