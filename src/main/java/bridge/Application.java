package bridge;

import bridge.controller.GameController;
import bridge.service.BridgeGame;
import bridge.utils.InputConvertor;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {
    public static void main(String[] args) {

        GameController mainController = new GameController(InputView.getInstance(), InputConvertor.getInstance(),
                OutputView.getInstance(), new BridgeGame());
        mainController.run();
    }
}
