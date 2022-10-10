package racingcar.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.util.Constants;

public class RacingEntry {
    private final Map<RacingCarName, RacingCarScore> racingEntry;

    Comparator<Entry<RacingCarName, RacingCarScore>> comparator =
            new Comparator<Entry<RacingCarName, RacingCarScore>>() {
                @Override
                public int compare(Entry<RacingCarName, RacingCarScore> e1,
                        Entry<RacingCarName, RacingCarScore> e2) {
                    return e1.getValue().toInt().compareTo(e2.getValue().toInt());
                }
            };

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

    public RacingResult getWinner(RacingResult result) {
        RacingCarScore maxScore = Collections.max(racingEntry.entrySet(), comparator).getValue();
        Set<RacingCarName> keys = racingEntry.keySet();
        String winners = "";

        result.addMessage(Constants.MSG_WINNER + " " + Constants.E_COLON + " ");

        for (RacingCarName name : keys) {
            winners += getWinnerMessage(name, maxScore);
        }

        result.addMessage(winners.substring(0, winners.length() - 2));

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

    private String getWinnerMessage(RacingCarName name, RacingCarScore maxScore) {
        String str = "";

        if (racingEntry.get(name).toInt() == maxScore.toInt()) { // "pobi, "
            str = name.toString() + Constants.E_COMMA + " ";
        }

        return str;
    }
}
