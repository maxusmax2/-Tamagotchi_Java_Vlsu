package main;

import java.time.*;
import java.io.Serializable;
/** A helper class container that includes information about the saved game*/
public class Save implements Serializable {
    public Save (LocalDateTime gameStartDate, LocalDateTime gameSaveDate, String characterName, CharacterState saveProgressValues){
        this.gameStartDate = gameStartDate;
        this.gameSaveDate = gameSaveDate;
        this.characterName = characterName;
        this.saveProgressValues = saveProgressValues;
    }
    public Save (){
        saveProgressValues= new CharacterState();
    }
    public LocalDateTime gameStartDate;
    public LocalDateTime gameSaveDate;
    public String characterName;
    public CharacterState saveProgressValues;
}