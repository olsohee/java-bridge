package bridge.controller;

import bridge.service.BridgeGame;
import bridge.utils.InputConvertor;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final InputConvertor inputConvertor;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    public GameController(InputView inputView, InputConvertor inputConvertor, OutputView outputView, BridgeGame bridgeGame) {
        this.inputView = inputView;
        this.inputConvertor = inputConvertor;
        this.outputView = outputView;
        this.bridgeGame = bridgeGame;
    }

    public void run() {
        outputView.printGameStartMessage();
        generateBridge();
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
}
