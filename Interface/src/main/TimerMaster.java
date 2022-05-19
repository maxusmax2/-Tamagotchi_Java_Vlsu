package main;

import java.time.Duration;
import java.time.LocalDateTime;

public class TimerMaster {
    /** The function is used to get the minutes passed with between two dates of the start of the game and the last save*/
    public long getPeriodStartSave(LocalDateTime gameSaveDate,LocalDateTime gameStartDate) {
        LocalDateTime dateSave = gameSaveDate;
        LocalDateTime dateNow = gameStartDate;
        Duration differenceDate = Duration.between(dateNow,dateSave);
        long minutes = Math.abs(differenceDate.toMinutes());
        return minutes;
    }
    /** The function is used to get the minutes passed since the last save */
    public long getPeriodStartSave(LocalDateTime gameSaveDate) {
        LocalDateTime dateSave = gameSaveDate;
        LocalDateTime dateNow = getDate();
        Duration differenceDate = Duration.between(dateNow,dateSave);
        long minutes = Math.abs(differenceDate.toMinutes());
        return minutes;
    }
    /** The auxiliary function that returns the date is used to encapsulate the work with time in the model class*/
    public LocalDateTime getDate (){
        return LocalDateTime.now();
    }

}
