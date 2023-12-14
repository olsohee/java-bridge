package bridge.service;

import bridge.domain.Location;
import bridge.domain.LocationCommand;
import bridge.dto.MapDto;
import bridge.message.ErrorMessage;
import bridge.utils.BridgeMaker;
import bridge.utils.BridgeRandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private Location bridge;
    private Location user = new Location();
    private int locationIndex = -1;

    public void generateBridge(int size) {
        validateBridgeSize(size);
        List<LocationCommand> locationCommands = bridgeMaker.makeBridge(size).stream()
                .map(location -> LocationCommand.findCommand(location))
                .collect(Collectors.toList());

        bridge = new Location(locationCommands);

        // log
        for (LocationCommand command : locationCommands) {
            System.out.print(command.getCommand() + " ");
        }
        System.out.println();
    }

    private void validateBridgeSize(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_SIZE.getErrorMessage());
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String location) {
        LocationCommand command = LocationCommand.findCommand(location);
        user.move(command);
        locationIndex++;
    }

    public boolean isSuccess() {
        return user.isSame(bridge, locationIndex);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public MapDto getMapDto(boolean success) {
        List<String> upLocations = new ArrayList<>();
        List<String> downLocations = new ArrayList<>();
        for (int index = 0; index < user.getLocationCommands().size(); index++) {
            if (index == user.getLocationCommands().size() - 1 && !success) {
                if (user.getLocationCommands().get(index) == LocationCommand.U) {
                    upLocations.add("X");
                    downLocations.add(" ");
                    break;
                }
                downLocations.add("X");
                upLocations.add(" ");
                break;
            }
            if (user.getLocationCommands().get(index) == LocationCommand.U) {
                upLocations.add("O");
                downLocations.add(" ");
                continue;
            }
            downLocations.add("O");
            upLocations.add(" ");
        }
        return new MapDto(upLocations, downLocations);
    }
}
