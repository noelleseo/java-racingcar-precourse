package racingcar.view;

import racingcar.controller.RacingController;

public class RacingView {
    RacingController controller = new RacingController();
    
    public void racing() {
        controller.initRacing();
        controller.doRacing();
        controller.endRacing();
    }
}
