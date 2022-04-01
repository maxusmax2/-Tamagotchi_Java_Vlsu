import java.time.Duration;
import java.time.LocalDateTime;

public class Timer {
    public long getPeriodStartSave(String gameSaveDate){
        LocalDateTime dateSave = LocalDateTime.parse(gameSaveDate);
        LocalDateTime dateNow = getDate();
        Duration differenceDate = Duration.between(dateNow,dateSave);
        long minutes = Math.abs(differenceDate.toMinutes());
        return minutes;
    }

    public LocalDateTime getDate (){
        return LocalDateTime.now();
    }

}
