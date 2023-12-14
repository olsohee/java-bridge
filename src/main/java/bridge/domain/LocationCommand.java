package bridge.domain;

public enum LocationCommand {

    U("U"),
    D("D")
    ;

    private final String command;

    LocationCommand(String command) {
        this.command = command;
    }
}
