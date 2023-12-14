package bridge.message;

public enum ErrorMessage {

    INVALID_INPUT("잘못된 입력입니다."),
    INVALID_SIZE("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INVALID_LOCATION("잘못된 다리 위치입니다.")
    ;

    private static final String ERROR_HEADER = "[ERROR]";
    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return String.format("%s %s", ERROR_HEADER, errorMessage);
    }
}
