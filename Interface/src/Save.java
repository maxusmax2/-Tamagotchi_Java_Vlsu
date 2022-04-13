import java.util.Date;;
public class Save {
    public Save (Date gameStartDate, Date gameSaveDate,String characterName,CharacterState saveProgressValues){
        this.gameStartDate = gameStartDate;
        this.gameSaveDate = gameSaveDate;
        this.characterName = characterName;
        this.saveProgressValues = saveProgressValues;
    }
    public Date gameStartDate;
    public Date gameSaveDate;
    public String characterName;
    public CharacterState saveProgressValues;
}
