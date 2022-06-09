package homework;

public enum Command {

    U("u"), D("d"), L("l"), R("r"), EXIT("exit");

    String command;

    Command(String command) {
        this.command = command;
    }

}