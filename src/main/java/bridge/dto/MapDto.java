package bridge.dto;

import java.util.ArrayList;
import java.util.List;

public class MapDto {

    private final List<String> upLocations;
    private final List<String> downLocations;

    public MapDto(List<String> upLocations, List<String> downLocations) {
        this.upLocations = upLocations;
        this.downLocations = downLocations;
    }

    public List<String> getUpLocations() {
        return upLocations;
    }

    public List<String> getDownLocations() {
        return downLocations;
    }
}
