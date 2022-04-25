import java.time.Duration;
import java.time.LocalDateTime;

public class TimerMaster {

    public long getPeriodStartSave(LocalDateTime gameSaveDate,LocalDateTime gameStartDate){
        LocalDateTime dateSave = gameSaveDate;
        LocalDateTime dateNow = gameStartDate;
        Duration differenceDate = Duration.between(dateNow,dateSave);
        long minutes = Math.abs(differenceDate.toMinutes());
        return minutes;
    }

    public long getPeriodStartSave(LocalDateTime gameSaveDate){
        LocalDateTime dateSave = gameSaveDate;
        LocalDateTime dateNow = getDate();
        Duration differenceDate = Duration.between(dateNow,dateSave);
        long minutes = Math.abs(differenceDate.toMinutes());
        return minutes;
    }

    public LocalDateTime getDate (){
        return LocalDateTime.now();
    }

}
