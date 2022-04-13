public class Saver {

<<<<<<< Updated upstream
    public Save infoLastSave;
    public void saveGame (Save parametersOfSave){

=======
    public Saver() {

    }
    public void saveGame ( Save parametersOfSave) throws IOException {

        String gameStartDate = parametersOfSave.gameStartDate.toString();
        String gameSaveDate = parametersOfSave.gameSaveDate.toString();
        FileWriter gameInfoFile = new FileWriter("gameInfo.txt");
        gameInfoFile.write(gameStartDate + "\n");
        gameInfoFile.write(gameSaveDate + "\n");
        gameInfoFile.write(parametersOfSave.characterName + "\n");
        gameInfoFile.write(parametersOfSave.saveProgressValues.feedValue +"\n");
        gameInfoFile.write(parametersOfSave.saveProgressValues.playValue +"\n");
        gameInfoFile.write(parametersOfSave.saveProgressValues.sleepValue +"\n");
        gameInfoFile.write(parametersOfSave.saveProgressValues.cleanValue +"\n");
        gameInfoFile.close();
>>>>>>> Stashed changes
    }
    public void downloadGame (){

    }
}
