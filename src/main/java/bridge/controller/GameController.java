package bridge.controller;

import bridge.domain.LocationCommand;
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
        move();
//        while () {
//
//        }

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
                System.out.println("실패");
                // 재시도 입력 받기
                return;
            }
            System.out.println("성공");
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            move();
        }
    }
}
