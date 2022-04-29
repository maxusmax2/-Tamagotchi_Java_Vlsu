package main;

import java.awt.event.*;
.
import java.io.IOException;
import java.util.Timer;

enum grudge  {OK, HUNGRY , DIRTY, SLEEPY, SAD, HUNGRYDIRTY, HUNGRYSLEEPY, HUNGRYSAD, HUNGRYDIRTYSLEEPY, HUNGRYDIRTYSAD, HUNGRYSLEEPYSAD, DIRTYSLEEPY, DIRTYSAD, DIRTYSLEEPYSAD,SLEEPYSAD};

interface MethodForSheduledTask{
    void doSomething();
}

public class Model implements ActionListener {

    final int GAMESTEP = 10;
    final int OKPARAMETR = 30;
    final int MINUSPROPERTYFORTICK = 8;

    final int TICKFORMILISECONDS = 1 * 4 * 60 ;
    boolean startGameFlag = true;
    boolean gameContinue = true;

    CharacterState state;
    grudge grudgeCharacter = grudge.OK;
    TimerMaster timer;
    Saver saver;
    Save  nowSave;

    Timer time = new Timer();


    Game gameWindow;
    MainMenu mainMenuWindow;
    ChooseCharacter chooseCharacterWindow;

    MethodForSheduledTask  gameStepHandler ;
    ScheduledTask shedulerTask;


    public Model() throws IOException {

        state = new CharacterState();
        timer = new TimerMaster();
        saver = new Saver();
        nowSave = new Save();

        gameStepHandler = ()->shedulerTickHandler();
        shedulerTask = new ScheduledTask(gameStepHandler);


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
        time.schedule(shedulerTask, 1000,TICKFORMILISECONDS);
    }

    public void actionPerformed(ActionEvent e) {//Функция обработчик нажатия кнопок

        Object pressedButton = e.getSource();

        if (pressedButton == mainMenuWindow.buttonNewGame){
            buttonNewGameHandler();
        }
        else if(pressedButton == mainMenuWindow.buttonContinue){
            if(gameContinue) {
                buttonContinueHandler();
            }
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
            if(gameContinue){
                buttonFeedHandler();
            }
        }
        else if(pressedButton == gameWindow.buttonPlay){
            if(gameContinue) {
                buttonPlayHandler();
            }
        }
        else if(pressedButton == gameWindow.buttonSleep){
            if(gameContinue) {
                buttonSleepHandler();
            }
        }
        else if(pressedButton == gameWindow.buttonClean){
            if(gameContinue) {
                buttonCleanHandler();
            }
        }
        else if(pressedButton == gameWindow.buttonMenu){
            buttonMenuHandler();
        }
    }
    private void shedulerTickHandler()
    {

        if(!startGameFlag && gameContinue) {
            randomMinusState();


            changeGuiWithNowInfoInTick();

            changeGuiByGrudgeState();

            if (characterIsBad()) {
                killCharacter();
            }
        }
    }

    private void buttonNewGameHandler(){
        mainMenuWindow.setVisible(false);
        chooseCharacterWindow.setVisible(true);
    }

    private void buttonContinueHandler(){

            download_save();

            reloadStateCharacter();
            saveGame();
            takeDataFromSave();

            changeGuiByGrudgeState();
            changeGuiWithNowInfo();

            if (characterIsBad()) {
                killCharacter();
            }
            startGameFlag = false;

            mainMenuWindow.setVisible(false);
            gameWindow.setVisible(true);

    }


    private void buttonChooseCharacterOneHandler(){

        fullParametrCharacter();

        makeNewSave("Хачапурик");

        saveGame();

        reloadGrudge();
        gameWindow.changeImageByState(nowSave.characterName, grudgeCharacter);



        gameWindow.changeScreen(nowSave, 0);

        chooseCharacterWindow.setVisible(false);
        gameWindow.setVisible(true);
        startGameFlag = false;
        gameContinue = true;

    }

    private void buttonChooseCharacterTwoHandler(){

        fullParametrCharacter();

        makeNewSave("Зелебоба");

        saveGame();

        if(reloadGrudge()) {
            gameWindow.changeImageByState(nowSave.characterName, grudgeCharacter);
        }
        gameWindow.changeScreen(nowSave,0);

        chooseCharacterWindow.setVisible(false);
        gameWindow.setVisible(true);

        startGameFlag = false;
        gameContinue = true;
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

        changeGuiByGrudgeState();
    }

    private void buttonPlayHandler(){
        state.playValue = 100;
        gameWindow.progressBarPlay.setValue(state.playValue);

        changeGuiByGrudgeState();
    }

    private void buttonSleepHandler(){
        state.sleepValue = 100;
        gameWindow.progressBarSleep.setValue(state.sleepValue);

        changeGuiByGrudgeState();

    }

    private void buttonCleanHandler(){
        state.cleanValue = 100;
        gameWindow.progressBarClean.setValue(state.cleanValue);

        changeGuiByGrudgeState();
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
                this.state.feedValue -= MINUSPROPERTYFORTICK;
                break;
            case 2:
                this.state.playValue -= MINUSPROPERTYFORTICK;
                break;
            case 3:
                this.state.sleepValue -= MINUSPROPERTYFORTICK;
                break;
            case 4:
                this.state.cleanValue -= MINUSPROPERTYFORTICK;
                break;
        }
    }


    private boolean characterIsBad() {
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
        gameWindow.killCharacter(nowSave.characterName);
        gameContinue = false;
    }

    private void download_save() {
        try {
            saver.downloadGame();
        }
        catch (IOException e) {

        }
    }

    private void reloadStateCharacter() {
        nowSave = saver.infoLastSave;
        state = nowSave.saveProgressValues;

        int passed_minutes = (int) timer.getPeriodStartSave(nowSave.gameSaveDate);

        randomMinusState(passed_minutes);

        nowSave.saveProgressValues = state;
        nowSave.gameSaveDate = timer.getDate();
    }

    private void saveGame () {
        try
        {
            saver.saveGame(nowSave);
        }
        catch (IOException e)
        {

        }
    }
    private void takeDataFromSave(){
        nowSave = saver.infoLastSave;
        state = nowSave.saveProgressValues;
    }
    private void changeGuiWithNowInfo() {

        int passedDay = (int) timer.getPeriodStartSave(nowSave.gameSaveDate, nowSave.gameStartDate) / 24 / 60;
        gameWindow.changeScreen(nowSave, passedDay);


    }
    private void changeGuiWithNowInfoInTick(){
        int passedDay = (int) timer.getPeriodStartSave(nowSave.gameSaveDate, nowSave.gameStartDate) / 24 / 60;
        gameWindow.changeScreenInTick(nowSave, passedDay);
    }

    private void makeNewSave(String tamagochiName){

        this.nowSave.saveProgressValues = this.state;

        this.nowSave.gameStartDate = nowSave.gameSaveDate = timer.getDate();
        this.nowSave.characterName = tamagochiName;
    }

    private boolean reloadGrudge(){
        grudge pastGrudge = grudgeCharacter;
        if (state.cleanValue > OKPARAMETR && state.feedValue > OKPARAMETR && state.playValue > OKPARAMETR && state.sleepValue > OKPARAMETR) {
            grudgeCharacter = grudge.OK;
        } else if (state.cleanValue <= OKPARAMETR && state.feedValue > OKPARAMETR && state.playValue > OKPARAMETR && state.sleepValue > OKPARAMETR) {
            grudgeCharacter = grudge.DIRTY;
        } else if (state.cleanValue > OKPARAMETR && state.feedValue <= OKPARAMETR && state.playValue > OKPARAMETR && state.sleepValue > OKPARAMETR) {
            grudgeCharacter = grudge.HUNGRY;
        } else if (state.cleanValue > OKPARAMETR && state.feedValue > OKPARAMETR && state.playValue <= OKPARAMETR && state.sleepValue > OKPARAMETR) {
            grudgeCharacter = grudge.SAD;
        } else if (state.cleanValue > OKPARAMETR && state.feedValue > OKPARAMETR && state.playValue > OKPARAMETR && state.sleepValue <= OKPARAMETR) {
            grudgeCharacter = grudge.SLEEPY;
        } else if (state.cleanValue <= OKPARAMETR && state.feedValue <= OKPARAMETR && state.playValue > OKPARAMETR && state.sleepValue > OKPARAMETR) {
            grudgeCharacter = grudge.HUNGRYDIRTY;
        } else if (state.cleanValue <= OKPARAMETR && state.feedValue > OKPARAMETR && state.playValue <= OKPARAMETR && state.sleepValue > OKPARAMETR) {
            grudgeCharacter = grudge.DIRTYSAD;
        } else if (state.cleanValue <= OKPARAMETR && state.feedValue > OKPARAMETR && state.playValue > OKPARAMETR && state.sleepValue <= OKPARAMETR) {
            grudgeCharacter = grudge.DIRTYSLEEPY;
        } else if (state.cleanValue <= OKPARAMETR && state.feedValue <= OKPARAMETR && state.playValue <= OKPARAMETR && state.sleepValue > OKPARAMETR) {
            grudgeCharacter = grudge.HUNGRYDIRTYSAD;
        } else if (state.cleanValue <= OKPARAMETR && state.feedValue <= OKPARAMETR && state.playValue > OKPARAMETR && state.sleepValue <= OKPARAMETR) {
            grudgeCharacter = grudge.HUNGRYDIRTYSLEEPY;
        } else if (state.cleanValue <= OKPARAMETR && state.feedValue > OKPARAMETR && state.playValue <= OKPARAMETR && state.sleepValue <= OKPARAMETR) {
            grudgeCharacter = grudge.HUNGRYSLEEPYSAD;
        } else if (state.cleanValue > OKPARAMETR && state.feedValue <= OKPARAMETR && state.playValue <= OKPARAMETR && state.sleepValue > OKPARAMETR) {
            grudgeCharacter = grudge.HUNGRYSAD;
        } else if (state.cleanValue > OKPARAMETR && state.feedValue <= OKPARAMETR && state.playValue > OKPARAMETR && state.sleepValue <= OKPARAMETR) {
            grudgeCharacter = grudge.HUNGRYSLEEPY;
        } else if (state.cleanValue > OKPARAMETR && state.feedValue <= OKPARAMETR && state.playValue <= OKPARAMETR && state.sleepValue <= OKPARAMETR) {
            grudgeCharacter = grudge.HUNGRYSLEEPYSAD;
        } else if (state.cleanValue > OKPARAMETR && state.feedValue > OKPARAMETR && state.playValue <= OKPARAMETR && state.sleepValue <= OKPARAMETR) {
            grudgeCharacter = grudge.SLEEPYSAD;
        }
        if (grudgeCharacter != pastGrudge){
            return true;
        }
        return false;
    }
    private void changeGuiByGrudgeState(){
        if(reloadGrudge()) {
            gameWindow.changeImageByState(nowSave.characterName, grudgeCharacter);
        }
    }
}
