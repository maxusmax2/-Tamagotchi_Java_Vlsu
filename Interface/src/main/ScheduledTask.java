<<<<<<< Updated upstream
package main;

=======
<<<<<<< HEAD
import java.io.IOException;
=======
package main;

>>>>>>> 0206880624bbd77a814cfa02faeea2fea94ba32d
>>>>>>> Stashed changes
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
