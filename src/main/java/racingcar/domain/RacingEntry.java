package racingcar.domain;

import java.util.Map;
import java.util.Set;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.util.Constants;

public class RacingEntry {
    Map<RacingCarName, RacingCarScore> racingEntry;

    public RacingEntry(Map<RacingCarName, RacingCarScore> racingEntry) {
        this.racingEntry = racingEntry;
    }
    
    public RacingResult process(RacingResult result) {
        Set<RacingCarName> keys = racingEntry.keySet();

        for (RacingCarName name : keys) {
            countScore(name);
            result.addMessage(getResultMessage(name, racingEntry.get(name)));
            result.addNewLine();
        }

        result.addNewLine();

        return result;
    }
    
    private void countScore(RacingCarName name) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            racingEntry.get(name).addScore();
        }
    }
    
    private String getResultMessage(RacingCarName name, RacingCarScore score) {
        String str = "";
        str += name.toString() + " " + Constants.E_COLON + " "; // "pobi : "

        for (int i = 0; i < score.toInt(); i++) { // 점수만큼 하이픈 추가
            str += Constants.E_HYPHEN;
        }

        return str;
    }    
}
