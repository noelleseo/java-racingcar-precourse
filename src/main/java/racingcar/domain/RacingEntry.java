package racingcar.domain;

import java.util.Map;

public class RacingEntry {
    Map<RacingCarName, RacingCarScore> racingEntry;

    public RacingEntry(Map<RacingCarName, RacingCarScore> racingEntry) {
        this.racingEntry = racingEntry;
    }
}
