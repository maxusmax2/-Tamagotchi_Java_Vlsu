import java.io.*;
import java.time.LocalDateTime;

public class Saver {
    public Save infoLastSave = new Save();

    public void saveGame (Save parametersOfSave) throws IOException {

        String gameStartDate = parametersOfSave.gameStartDate.toString();
        String gameSaveDate = parametersOfSave.gameSaveDate.toString();
        FileWriter gameInfoFile = new FileWriter("gameInfo.txt");
        gameInfoFile.write(gameStartDate + "\n");
        gameInfoFile.write(gameSaveDate+ "\n");
        gameInfoFile.write(parametersOfSave.characterName+ "\n");
        gameInfoFile.write(parametersOfSave.saveProgressValues.feedValue+"\n");
        gameInfoFile.write(parametersOfSave.saveProgressValues.playValue+"\n");
        gameInfoFile.write(parametersOfSave.saveProgressValues.sleepValue+"\n");
        gameInfoFile.write(parametersOfSave.saveProgressValues.cleanValue+"\n");
        gameInfoFile.close();
    }
    public void downloadGame () throws IOException {
        FileReader gameInfoFile = new FileReader("gameInfo.txt");
        BufferedReader readFile = new BufferedReader(gameInfoFile);
        String s;
        s=readFile.readLine();
        infoLastSave.gameStartDate =  LocalDateTime.parse(s);
        s=readFile.readLine();
        infoLastSave.gameSaveDate =  LocalDateTime.parse(s);
        s=readFile.readLine();
        infoLastSave.characterName = s;
        s=readFile.readLine();
        infoLastSave.saveProgressValues.feedValue = Integer.parseInt(s);
        s=readFile.readLine();
        infoLastSave.saveProgressValues.playValue = Integer.parseInt(s);
        s=readFile.readLine();
        infoLastSave.saveProgressValues.sleepValue = Integer.parseInt(s);
        s=readFile.readLine();
        infoLastSave.saveProgressValues.cleanValue = Integer.parseInt(s);
        gameInfoFile.close();
    }
}
