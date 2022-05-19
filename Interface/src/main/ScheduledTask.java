package main;

import java.util.TimerTask;
/** Auxiliary class that implements the logic of multiple execution of a function after a certain period */
public class ScheduledTask extends TimerTask {
    MethodForSheduledTask method;
    public ScheduledTask(MethodForSheduledTask methodForSheduler) {
        method = methodForSheduler;
    }
    public void run() {
        method.doSomething();
    }
}
