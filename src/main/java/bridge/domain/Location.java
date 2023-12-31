package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Location {

    private List<LocationCommand> locationCommands = new ArrayList<>();

    public Location() {
    }

    public Location(List<LocationCommand> locationCommands) {
        this.locationCommands = locationCommands;
    }

    public void move(LocationCommand command) {
        locationCommands.add(command);
    }

    public boolean isSame(Location bridge, int locationIndex) {
        return locationCommands.get(locationIndex).equals(bridge.locationCommands.get(locationIndex));
    }

    public List<LocationCommand> getLocationCommands() {
        return locationCommands;
    }

    public void clear() {
        locationCommands.clear();
    }

    public boolean isEnd(int locationIndex) {
        return locationCommands.size() - 1 == locationIndex;
    }
}
