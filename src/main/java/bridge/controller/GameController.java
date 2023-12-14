package bridge.controller;

import bridge.domain.RetryGameCommand;
import bridge.service.BridgeGame;
import bridge.utils.InputConvertor;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final InputConvertor inputConvertor;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;
    private RetryGameCommand retryGameCommand = RetryGameCommand.R;
    private boolean isEnd = false;
    private int tryCount = 0;

    public GameController(InputView inputView, InputConvertor inputConvertor, OutputView outputView, BridgeGame bridgeGame) {
        this.inputView = inputView;
        this.inputConvertor = inputConvertor;
        this.outputView = outputView;
        this.bridgeGame = bridgeGame;
    }

    public void run() {
        outputView.printGameStartMessage();
        generateBridge();
        while (!isEnd && retryGameCommand == RetryGameCommand.R) {
            tryCount++;
            bridgeGame.retry();
            move();
        }

        printResult();
    }

    private void generateBridge() {
        try {
            int size = inputConvertor.convertStringToInt(inputView.readBridgeSize());
            bridgeGame.generateBridge(size);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            generateBridge();
        }
    }

    private void move() {
        try {
            bridgeGame.move(inputView.readMoving());
            if (!bridgeGame.isSuccess()) {
                outputView.printMap(bridgeGame.getMapDto(false));
                retryGameCommand = RetryGameCommand.findCommand(inputView.readRetryGameCommand());
                return;
            }
            outputView.printMap(bridgeGame.getMapDto(true));
            if (bridgeGame.isEnd()) {
                isEnd = true;
                return;
            }
            move();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            move();
        }
    }

    private void printResult() {
        outputView.printResultStartMessage();
        if (retryGameCommand == RetryGameCommand.R) {
            outputView.printMap(bridgeGame.getMapDto(true));
        } else {
            outputView.printMap(bridgeGame.getMapDto(false));
        }
        outputView.printResult(isEnd, tryCount);
    }
}
