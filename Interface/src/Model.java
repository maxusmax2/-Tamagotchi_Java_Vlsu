import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Timer;

interface MethodForSheduledTask{
    int doSomething();
}

public class Model implements ActionListener {

    final int GAMESTEP = 10;
    boolean startGameFlag = false;

    CharacterState state;
    MethodForSheduledTask doS = ()->state.sleepValue-=2;
    TimerMaster timer;
    Saver saver;
    Save nowSave;

    Timer time = new Timer();
    ScheduledTask st = new ScheduledTask(doS);

    Game gameWindow;
    MainMenu mainMenuWindow;
    ChooseCharacter chooseCharacterWindow;

    public Model() throws IOException {



        state = new CharacterState();
        timer = new TimerMaster();
        saver = new Saver();
        nowSave = new Save();

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

    public void startGame() {
        mainMenuWindow.setVisible(true);
        time.schedule(st, 0, 1000);
    }

    public void actionPerformed(ActionEvent e) {

        Object pressedButton = e.getSource();

        if (pressedButton == mainMenuWindow.buttonNewGame){
            buttonNewGameHandler();
        }
        else if(pressedButton == mainMenuWindow.buttonContinue){
            buttonContinueHandler();
        }
        else if (pressedButton == mainMenuWindow.buttonSave) {
            buttonSaveHandler();
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

        if(startGameFlag == false) {
            try {
                saver.downloadGame();
            } catch (IOException e) {

            }

            nowSave = saver.infoLastSave;
            state = nowSave.saveProgressValues;

            if (characterIsDeath()){
                killCharacter();
            }


            int passed_minutes = (int) timer.getPeriodStartSave(nowSave.gameSaveDate);

            randomMinusState(passed_minutes);

            nowSave.saveProgressValues = state;
            nowSave.gameSaveDate = timer.getDate();
            saveGame();

            int passedDay = (int) timer.getPeriodStartSave(nowSave.gameSaveDate, nowSave.gameStartDate) / 24 / 60;

            gameWindow.changeScreen(nowSave, passedDay);

            startGameFlag = true;
        }
        mainMenuWindow.setVisible(false);
        gameWindow.setVisible(true);
    }

    private void buttonChooseCharacterOneHandler(){

        fullParametrCharacter();

        nowSave = new Save();

        nowSave.saveProgressValues = this.state;

        nowSave.gameStartDate = nowSave.gameSaveDate = timer.getDate();
        nowSave.characterName = "Хачапурик";

        saveGame();

        gameWindow.changeScreen(nowSave,0);

        chooseCharacterWindow.setVisible(false);
        gameWindow.setVisible(true);
    }

    private void buttonChooseCharacterTwoHandler(){

        fullParametrCharacter();

        nowSave = new Save();

        nowSave.saveProgressValues = this.state;

        nowSave.gameStartDate = nowSave.gameSaveDate = timer.getDate();
        nowSave.characterName = "Зелебоба";

        saveGame();

        gameWindow.changeScreen(nowSave,0);

        chooseCharacterWindow.setVisible(false);
        gameWindow.setVisible(true);

    }

    private void buttonSaveHandler(){

        if (nowSave.characterName != null){
            try {
                nowSave.gameSaveDate = timer.getDate();
                saver.saveGame(nowSave);
            }
            catch (IOException e) {

            }
        }
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

    private void fullParametrCharacter() {
        this.state.feedValue = 100;
        this.state.playValue = 100;
        this.state.sleepValue = 100;
        this.state.cleanValue = 100;
    }
    private void randomMinusState(int passed_minutes)
    {
        for (int i = 0; i < passed_minutes / GAMESTEP; i++){
            randomMinusState();
        }
    }

    public void randomMinusState()
    {
        int randomIndicator = (int) (Math.random() * ((4 - 1) + 1)) + 1;
        switch (randomIndicator)
        {
            case 1:
                this.state.feedValue-=2;
                break;
            case 2:
                this.state.playValue-=2;
                break;
            case 3:
                this.state.sleepValue-=2;
                break;
            case 4:
                this.state.cleanValue-=2;
                break;
        }
    }
    private void saveGame ()
    {
        try
        {
            saver.saveGame(nowSave);
        }
        catch (IOException e)
        {

        }
    }

    private boolean characterIsDeath()
    {
        if (state.cleanValue <= 0 || state.sleepValue <= 0 || state.feedValue <= 0 || state.playValue <= 0 ){
            return true;
        }
        return false;
    }
    private void killCharacter (){
        state.playValue = 0;
        state.feedValue = 0;
        state.sleepValue = 0;
        state.cleanValue = 0;
        gameWindow.killCharacter();
    }
}
