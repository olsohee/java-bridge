package bridge.domain;

import bridge.message.ErrorMessage;

import java.util.Arrays;

public enum LocationCommand {

    U("U"),
    D("D")
    ;

    private final String command;

    LocationCommand(String command) {
        this.command = command;
    }

    public static LocationCommand findCommand(String location) {
        return Arrays.stream(LocationCommand.values())
                .filter(locationCommand -> locationCommand.getCommand().equals(location))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getErrorMessage()));
    }

    public String getCommand() {
        return command;
    }
}
