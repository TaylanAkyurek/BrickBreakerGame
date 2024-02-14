package domain;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class PlayPhantasm extends TimerTask {
    private Phantasm phantasm;

    public PlayPhantasm(Phantasm phantasm) {
        this.phantasm = phantasm;
    }
    @Override
    public void run() {
        // update ball position

    }

}
