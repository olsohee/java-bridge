package bridge.message;

public enum OutputMessage {

    GAME_START_MESSAGE("다리 건너기 게임을 시작합니다."),
    MAP("[ %s ]"),
    MAP_DELIMITER(" | ")
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
