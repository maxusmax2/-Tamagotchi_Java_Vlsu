package test;

import main.Save;
import org.junit.jupiter.api.Assertions;
import java.io.IOException;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class SaverTest {
    main.Saver saver1 = new main.Saver();

    Save save = new main.Save(LocalDateTime.now(),LocalDateTime.now(),"name", new main.CharacterState());

    @Test
    void saveGame() throws IOException{
        saver1.saveGame(save);
        saver1.downloadGame();
        Assertions.assertNotEquals(save, saver1.infoLastSave);
    }

    @Test
    void downloadGame() throws IOException{
        saver1.saveGame(save);
        saver1.downloadGame();
        Assertions.assertNotEquals(null, saver1.infoLastSave);
    }
}