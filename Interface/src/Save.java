import java.util.Date;;
public class Save {
<<<<<<< Updated upstream
    public Save (Date gameStartDate, Date gameSaveDate,String characterName,CharacterState saveProgressValues){
=======

    public LocalDateTime gameStartDate;
    public LocalDateTime gameSaveDate;
    public String characterName;
    public CharacterState saveProgressValues;

    public Save (){
        saveProgressValues= new CharacterState();
    }
    public Save (LocalDateTime gameStartDate, LocalDateTime gameSaveDate,String characterName,CharacterState saveProgressValues){
>>>>>>> Stashed changes
        this.gameStartDate = gameStartDate;
        this.gameSaveDate = gameSaveDate;
        this.characterName = characterName;
        this.saveProgressValues = saveProgressValues;
    }
<<<<<<< Updated upstream
    public Date gameStartDate;
    public Date gameSaveDate;
    public String characterName;
    public CharacterState saveProgressValues;
}
=======


}
>>>>>>> Stashed changes
