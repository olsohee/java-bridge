package bridge.message;

public enum OutputMessage {

    GAME_START_MESSAGE("다리 건너기 게임을 시작합니다."),
    MAP("[ %s ]"),
    MAP_DELIMITER(" | "),
    RESULT_START_MESSAGE("최종 게임 결과"),
    RESULT("게임 성공 여부: %s"),
    SUCCESS("성공"),
    FAIL("실패"),
    TRY_COUNT("총 시도한 횟수: %d")
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
