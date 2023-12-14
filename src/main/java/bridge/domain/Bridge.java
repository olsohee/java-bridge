package bridge.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Bridge {

    private List<LocationCommand> commands;

    public Bridge(List<String> locations) {
        commands = locations.stream()
                .map(location -> LocationCommand.findCommand(location))
                .collect(Collectors.toList());

        // log
        for (LocationCommand command : commands) {
            System.out.print(command.getCommand() + " ");
        }
        System.out.println();
    }
}
