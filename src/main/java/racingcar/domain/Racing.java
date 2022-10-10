package racingcar.domain;

import java.util.HashMap;
import java.util.Map;
import racingcar.util.Constants;

public class Racing {
    private RacingEntry racingEntry;
    
    public void initRacing(String entryStr) throws IllegalArgumentException {
        Map<RacingCarName, RacingCarScore> racingEntryMap = new HashMap<>();
        
        for(String name : entryStr.split(Constants.E_COMMA)) {
            RacingCarName racingCarName = new RacingCarName(name);
            RacingCarScore racingCarScore = new RacingCarScore();
            racingEntryMap.put(racingCarName, racingCarScore);
        }
        
        racingEntry = new RacingEntry(racingEntryMap);
    }
    
    public void doRacing(String round) throws IllegalArgumentException {
        //수행 라운드를 받아 레이스 수행
    }
    
    public String endRacing() { //레이스 종료 후 결과 리턴
        String result = "";
        
        return result;
    }
}
