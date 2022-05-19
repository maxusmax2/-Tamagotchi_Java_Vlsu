package main;

import java.io.*;
/**Auxiliary class responsible for working with files */
public class Saver {
    /** Variable storing the last uploaded save */
    public Save infoLastSave = new Save();

    /** Saves data of Save to a file gameInfo.txt *
     * @param  parametersOfSave
     * @throws IOException*/
    public void saveGame (Save parametersOfSave) throws IOException {

        FileOutputStream fos = new FileOutputStream("gameInfo.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(parametersOfSave);
        oos.flush();
    }

    /** Loads data from a file gameInfo.txt in InfoLastSave
     * @param
     * @throws IOException*/

    public void downloadGame () throws IOException {
        Object result = null;
        try {
            FileInputStream fis = new FileInputStream("gameInfo.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            infoLastSave = (Save) ois.readObject(); }
        catch(ClassNotFoundException e) {
            System.out.println("File save not found" + e);
        }
    }
}
