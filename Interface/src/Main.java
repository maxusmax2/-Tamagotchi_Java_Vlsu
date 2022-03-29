import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException
    {
        Game gameWindow = new Game();
        MainMenu mainMenuWindow = new MainMenu();
        ChooseCharacter chooseCharacterWindow = new ChooseCharacter();

        gameWindow.setVisible(true);
        mainMenuWindow.setVisible(true);
        chooseCharacterWindow.setVisible(true);

    }
}
