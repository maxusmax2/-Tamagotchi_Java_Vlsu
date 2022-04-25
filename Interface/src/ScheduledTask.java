import java.io.IOException;
import java.util.TimerTask;



public class ScheduledTask extends TimerTask {
    MethodForSheduledTask m;
    public ScheduledTask(MethodForSheduledTask method){
        m = method;
    }
    @Override
    public void run() {
        System.out.println(m.doSomething());

    }
}
