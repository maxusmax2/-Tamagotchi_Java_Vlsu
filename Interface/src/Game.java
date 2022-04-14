import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Game extends JFrame
{
    public BufferedImage characterImage = ImageIO.read(new File("../Images/CH1_funny.jpg"));
    Image image = characterImage.getScaledInstance(280, 280, Image.SCALE_DEFAULT);
    ImageIcon iconCharacter = new ImageIcon(image);

    JLabel labelImg = new JLabel(iconCharacter);
    JLabel labelNameCharacter = new JLabel("Hachapuric");
    JLabel labelDaysOfLife = new JLabel("day:");


    JProgressBar progressBarFeed = new JProgressBar();
    JProgressBar progressBarPlay = new JProgressBar();
    JProgressBar progressBarSleep = new JProgressBar();
    JProgressBar progressBarClean = new JProgressBar();

    JButton buttonFeed = new JButton("feed");
    JButton buttonPlay = new JButton("play");
    JButton buttonSleep = new JButton("sleep");
    JButton buttonClean = new JButton("clean");
    JButton buttonMenu = new JButton("menu");


    JPanel panelImage = new JPanel(new GridLayout(1,1));

    JPanel panelNameLabel = new JPanel(new FlowLayout());

    JPanel panelFeed = new JPanel(new FlowLayout());
    JPanel panelPlay = new JPanel(new FlowLayout());
    JPanel panelSleep = new JPanel(new FlowLayout());
    JPanel panelClean = new JPanel(new FlowLayout());

    JPanel panelFooter = new JPanel(new FlowLayout(FlowLayout.LEFT));

    JPanel panelCharacteristics =new JPanel(new GridLayout(5,1));

    public Game() throws IOException {
        super("Tamagochi");
        this.setBounds(100,100,400,560);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Container mainContainer = this.getContentPane();
        mainContainer.setLayout(new BorderLayout());


        mainContainer.add(panelImage, BorderLayout.NORTH);
        panelImage.setBackground(new Color(248, 252, 116));
        panelImage.add(labelImg);


        mainContainer.add(panelCharacteristics, BorderLayout.CENTER);
        panelCharacteristics.setBackground(new Color(248, 252, 116));


        panelCharacteristics.add(panelNameLabel);
        panelNameLabel.setBackground(new Color(248, 252, 116));

        panelNameLabel.add(labelNameCharacter);
        labelNameCharacter.setFont(new Font("Arial", Font.PLAIN, 25));


        panelCharacteristics.add(panelFeed);
        panelFeed.setBackground(new Color(248, 252, 116));

        panelFeed.add(progressBarFeed);
        progressBarFeed.setMinimum(0);
        progressBarFeed.setMaximum(100);
        progressBarFeed.setValue(70);
        progressBarFeed.setForeground(new Color(74, 255, 244));
        progressBarFeed.setPreferredSize(new Dimension(250,25));

        panelFeed.add(buttonFeed);
        buttonFeed.setPreferredSize(new Dimension(73,25));
        buttonFeed.setBackground(new Color(203,147,24));
        buttonFeed.setForeground(new Color(255,255,255));
        buttonFeed.setFont(new Font("Arial", Font.PLAIN, 16));


        panelCharacteristics.add(panelPlay);
        panelPlay.setBackground(new Color(248, 252, 116));

        panelPlay.add(progressBarPlay);
        progressBarPlay.setMinimum(0);
        progressBarPlay.setMaximum(100);
        progressBarPlay.setValue(70);
        progressBarPlay.setForeground(new Color(75, 255, 156));
        progressBarPlay.setPreferredSize(new Dimension(250,25));

        panelPlay.add(buttonPlay);
        buttonPlay.setPreferredSize(new Dimension(73,25));
        buttonPlay.setBackground(new Color(203,147,24));
        buttonPlay.setForeground(new Color(255,255,255));
        buttonPlay.setFont(new Font("Arial", Font.PLAIN, 16));


        panelCharacteristics.add(panelSleep);
        panelSleep.setBackground(new Color(248, 252, 116));

        panelSleep.add(progressBarSleep);
        progressBarSleep.setMinimum(0);
        progressBarSleep.setMaximum(100);
        progressBarSleep.setValue(70);
        progressBarSleep.setForeground(new Color(176, 255, 75));
        progressBarSleep.setPreferredSize(new Dimension(250,25));

        panelSleep.add(buttonSleep);
        buttonSleep.setPreferredSize(new Dimension(73,25));
        buttonSleep.setBackground(new Color(203,147,24));
        buttonSleep.setForeground(new Color(255,255,255));
        buttonSleep.setFont(new Font("Arial", Font.PLAIN, 16));


        panelCharacteristics.add(panelClean);
        panelClean.setBackground(new Color(248, 252, 116));

        panelClean.add(progressBarClean);
        progressBarClean.setMinimum(0);
        progressBarClean.setMaximum(100);
        progressBarClean.setValue(70);
        progressBarClean.setForeground(new Color(75, 202, 255));
        progressBarClean.setPreferredSize(new Dimension(250,25));

        panelClean.add(buttonClean);
        buttonClean.setPreferredSize(new Dimension(73,25));
        buttonClean.setBackground(new Color(203,147,24));
        buttonClean.setForeground(new Color(255,255,255));
        buttonClean.setFont(new Font("Arial", Font.PLAIN, 16));


        mainContainer.add(panelFooter,BorderLayout.SOUTH);
        panelFooter.setBackground(new Color(248, 252, 116));

        panelFooter.add(buttonMenu);
        buttonMenu.setPreferredSize(new Dimension(73,25));
        buttonMenu.setBackground(new Color(237,52,192));
        buttonMenu.setForeground(new Color(255,255,255));
        buttonMenu.setFont(new Font("Arial", Font.PLAIN, 16));

        panelFooter.add(labelDaysOfLife);
        labelDaysOfLife.setFont(new Font("Arial", Font.PLAIN, 16));

    }
    public void changeScreen(Save saveParameter, int day){

        this.progressBarFeed.setValue(saveParameter.saveProgressValues.feedValue);
        this.progressBarPlay.setValue(saveParameter.saveProgressValues.playValue);
        this.progressBarSleep.setValue(saveParameter.saveProgressValues.sleepValue);
        this.progressBarClean.setValue(saveParameter.saveProgressValues.cleanValue);
        this.changeCharacterName(saveParameter.characterName);
        changeDay(day);
        if(saveParameter.characterName.equals("Зелебоба")){
            this.changeOnChararacterTwo();
        }
        else{
            this.changeOnChararacterOne();
        }



    }

    public void changeOnChararacterOne(){
        try {
            panelImage.remove(labelImg);
            characterImage = ImageIO.read(new File("../Images/CH1_funny.jpg"));
            Image image = characterImage.getScaledInstance(280, 280, Image.SCALE_DEFAULT);
            iconCharacter = new ImageIcon(image);
            labelImg = new JLabel(iconCharacter);
            panelImage.add(labelImg);
        }
        catch (IOException e){

        }

    }
    public void changeOnChararacterTwo() {
        try {
            panelImage.remove(labelImg);
            characterImage = ImageIO.read(new File("../Images/CH2_funny.jpg"));
            Image image = characterImage.getScaledInstance(280, 280, Image.SCALE_DEFAULT);
            iconCharacter = new ImageIcon(image);
            labelImg = new JLabel(iconCharacter);
            panelImage.add(labelImg);
        }
        catch (IOException e){

        }
    }
    public void changeCharacterName(String name) {
        panelNameLabel.remove(labelNameCharacter);
        labelNameCharacter = new JLabel(name);
        panelNameLabel.add(labelNameCharacter);
        labelNameCharacter.setFont(new Font("Arial", Font.PLAIN, 25));
    }
    public void changeDay(int day){
        panelFooter.remove(labelDaysOfLife);
        labelDaysOfLife = new JLabel("day: " + day);
        labelDaysOfLife.setFont(new Font("Arial", Font.PLAIN, 16));
        panelFooter.add(labelDaysOfLife);
    }

}