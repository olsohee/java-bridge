package bridge.view;

import bridge.dto.MapDto;
import bridge.message.OutputMessage;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private OutputView() {
    }

    private static class OutputViewHolder {
        private static OutputView outputView = new OutputView();
    }

    public static OutputView getInstance() {
        return OutputViewHolder.outputView;
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printGameStartMessage() {
        System.out.println(OutputMessage.GAME_START_MESSAGE.getMessage());
        System.out.println();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(MapDto mapDto) {
        System.out.println(String.format(OutputMessage.MAP.getMessage(),
                String.join(OutputMessage.MAP_DELIMITER.getMessage(), mapDto.getUpLocations())));

        System.out.println(String.format(OutputMessage.MAP.getMessage(),
                String.join(OutputMessage.MAP_DELIMITER.getMessage(), mapDto.getDownLocations())));
        System.out.println();
    }

    public void printResultStartMessage() {
        System.out.println(OutputMessage.RESULT_START_MESSAGE.getMessage());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean isEnd, int tryCount) {
        if (isEnd) {
            System.out.println(String.format(OutputMessage.RESULT.getMessage(), OutputMessage.SUCCESS.getMessage()));
        } else {
            System.out.println(String.format(OutputMessage.RESULT.getMessage(), OutputMessage.FAIL.getMessage()));
        }
        System.out.println(String.format(OutputMessage.TRY_COUNT.getMessage(), tryCount));
    }
}
