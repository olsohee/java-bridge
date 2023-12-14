package bridge.service;

import bridge.domain.Bridge;
import bridge.message.ErrorMessage;
import bridge.utils.BridgeMaker;
import bridge.utils.BridgeRandomNumberGenerator;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private Bridge bridge;

    public void generateBridge(int size) {
        validate(size);
        bridge = new Bridge(bridgeMaker.makeBridge(size));
    }

    private void validate(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_SIZE.getErrorMessage());
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

}