package main;

import java.util.TimerTask;

public class ScheduledTask extends TimerTask {
    MethodForSheduledTask m;
    public ScheduledTask(MethodForSheduledTask method){
        m = method;
    }
    public void run() {
        m.doSomething();

    }
}
