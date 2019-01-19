package first.labs;

import javafx.application.Platform;

public class ClockThread extends ClockPane {

    public void startClock() {
        new Thread(() -> {
           while (true) {
               try {
                   Platform.runLater(super::setCurrentTime);
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        }).start();
    }

}
