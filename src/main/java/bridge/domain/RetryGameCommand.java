package bridge.domain;

import bridge.message.ErrorMessage;

import java.util.Arrays;

public enum RetryGameCommand {

    R("R"),
    Q("Q")
    ;

    private final String command;

    RetryGameCommand(String command) {
        this.command = command;
    }

    public static RetryGameCommand findCommand(String command) {
        return Arrays.stream(RetryGameCommand.values())
                .filter(retryGameCommand -> retryGameCommand.getCommand().equals(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getErrorMessage()));
    }

    public String getCommand() {
        return command;
    }
}
