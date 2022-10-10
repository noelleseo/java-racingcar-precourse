package racingcar.domain;

import racingcar.util.Constants;
import racingcar.util.RegexUtil;

public class RacingRound {
    private int round;

    public RacingRound(String round) {
        validateRound(round);
        this.round = Integer.parseInt(round);
    }
    
    public int toInt() {
        return round;
    }
    
    private void validateRound(String round) {
        if(!RegexUtil.match("^[0-9]+$", round)) {
            throw new IllegalArgumentException(Constants.ERR_NOT_NUMBER);
        }
    }
}
