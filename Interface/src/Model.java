import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class Model implements ActionListener {

    CharacterState state;
    Timer timer;
    Saver saver;
    Save nowSave;

    Game gameWindow;
    MainMenu mainMenuWindow;
    ChooseCharacter chooseCharacterWindow;

    public Model() throws IOException {

        state = new CharacterState();
        timer = new Timer();
        saver = new Saver();

        mainMenuWindow = new MainMenu();

        mainMenuWindow.buttonNewGame.addActionListener(this);
        mainMenuWindow.buttonContinue.addActionListener(this);
        mainMenuWindow.buttonSave.addActionListener(this);


        chooseCharacterWindow = new ChooseCharacter();

        chooseCharacterWindow.chooseCharacterOneBtn.addActionListener(this);
        chooseCharacterWindow.chooseCharacterTwoBtn.addActionListener(this);


        gameWindow = new Game();

        gameWindow.buttonFeed.addActionListener(this);
        gameWindow.buttonPlay.addActionListener(this);
        gameWindow.buttonSleep.addActionListener(this);
        gameWindow.buttonClean.addActionListener(this);
        gameWindow.buttonMenu.addActionListener(this);

    }

    public void startGame()
    {
        mainMenuWindow.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        Object pressedButton = e.getSource();

        if (pressedButton == mainMenuWindow.buttonNewGame){
            buttonNewGameHandler();
        }
        else if(pressedButton == mainMenuWindow.buttonContinue){
            buttonContinueHandler();
        }
        else if(pressedButton == chooseCharacterWindow.chooseCharacterOneBtn){
            buttonChooseCharacterOneHandler();
        }
        else if(pressedButton == chooseCharacterWindow.chooseCharacterTwoBtn){
            buttonChooseCharacterTwoHandler();
        }
        else if(pressedButton == gameWindow.buttonFeed){
            buttonFeedHandler();
        }
        else if(pressedButton == gameWindow.buttonPlay){
            buttonPlayHandler();
        }
        else if(pressedButton == gameWindow.buttonSleep){
            buttonSleepHandler();
        }
        else if(pressedButton == gameWindow.buttonClean){
            buttonCleanHandler();
        }
        else if(pressedButton == gameWindow.buttonMenu){
            buttonMenuHandler();
        }
    }

    private void buttonNewGameHandler(){
        mainMenuWindow.setVisible(false);
        chooseCharacterWindow.setVisible(true);
    }

    private void buttonContinueHandler(){
        mainMenuWindow.setVisible(false);
        gameWindow.setVisible(true);
    }

    private void buttonChooseCharacterOneHandler(){

    }

    private void buttonChooseCharacterTwoHandler(){

    }

    private void buttonFeedHandler(){
        state.feedValue = 100;
        gameWindow.progressBarFeed.setValue(state.feedValue);
    }

    private void buttonPlayHandler(){
        state.playValue = 100;
        gameWindow.progressBarPlay.setValue(state.playValue);
    }

    private void buttonSleepHandler(){
        state.sleepValue = 100;
        gameWindow.progressBarSleep.setValue(state.sleepValue);
    }

    private void buttonCleanHandler(){
        state.cleanValue = 100;
        gameWindow.progressBarClean.setValue(state.cleanValue);
    }

    private void buttonMenuHandler(){
        gameWindow.setVisible(false);
        mainMenuWindow.setVisible(true);
    }
}
