import java.io.*;

public class Saver {
    public Save infoLastSave = new Save();

    public void saveGame (Save parametersOfSave) throws IOException {

        FileOutputStream fos = new FileOutputStream("gameInfo.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(parametersOfSave);
        oos.flush();
    }
    public void downloadGame () throws IOException {
        Object result = null;
        try {
            FileInputStream fis = new FileInputStream("gameInfo.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            infoLastSave = (Save) ois.readObject(); }
        catch(ClassNotFoundException e) {
        }
    }
}
