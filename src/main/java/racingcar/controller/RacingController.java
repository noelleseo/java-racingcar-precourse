package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Racing;
import racingcar.util.Constants;

public class RacingController {
    private Racing racing = new Racing();
    
    public void initRacing() {
        System.out.println(Constants.MSG_GET_ENTRY);
        racing.initRacing(Console.readLine());
    }
    
    public void doRacing() {
        System.out.println(Constants.MSG_GET_ROUND);
        racing.doRacing(Console.readLine());
    }
    
    public void endRacing() {
        System.out.println(racing.endRacing());
    }
}
