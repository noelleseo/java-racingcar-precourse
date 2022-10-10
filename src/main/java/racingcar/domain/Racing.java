package racingcar.domain;

import java.util.HashMap;
import java.util.Map;
import racingcar.util.Constants;

public class Racing {
    private RacingEntry racingEntry;
    private RacingRound racingRound;
    private RacingResult racingResult;
    
    public void initRacing(String entryStr) throws IllegalArgumentException {
        Map<RacingCarName, RacingCarScore> racingEntryMap = new HashMap<>();
        String[] entryArr = entryStr.split(Constants.E_COMMA);
        
        if(entryArr.length == 0) {
            throw new IllegalArgumentException(Constants.ERR_NOT_NULL);
        }
        
        for(String name : entryArr) {
            RacingCarName racingCarName = new RacingCarName(name);
            RacingCarScore racingCarScore = new RacingCarScore();
            racingEntryMap.put(racingCarName, racingCarScore);
        }
        
        racingEntry = new RacingEntry(racingEntryMap);
    }
    
    public void doRacing(String round) throws IllegalArgumentException {
        racingRound = new RacingRound(round);
        racingResult = new RacingResult();
        int currentRound = 0;
        
        while(racingRound.toInt() > currentRound) {
            racingResult = racingEntry.process(racingResult);
            currentRound ++;
        }
    }
    
    public String endRacing() {
        racingEntry.getWinner(racingResult);
        
        return racingResult.toString();
    }
}
