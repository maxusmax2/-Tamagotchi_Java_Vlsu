package test;

import main.Save;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class SaverTest {
    main.Saver saver1 = new main.Saver();

    Save save = new main.Save(LocalDateTime.now(),LocalDateTime.now(),"name",null);

    @org.junit.jupiter.api.Test
    void saveGame() {
        try {
            saver1.saveGame(save);
            saver1.downloadGame();
            Assertions.assertNotEquals(save, saver1.infoLastSave);
        }
        catch (IOException e){

        }

    }

    @org.junit.jupiter.api.Test
    void downloadGame() {
        try {
            saver1.saveGame(save);
            saver1.downloadGame();
            Assertions.assertNotEquals(null, saver1.infoLastSave);
        }
        catch (IOException e){

        }
    }
}