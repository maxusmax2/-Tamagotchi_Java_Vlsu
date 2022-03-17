import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ChooseCharacterWindow  extends  JFrame{


    private JButton chooseCharacterOneBtn = new JButton("CH. 1");
    private JButton chooseCharacterTwoBtn = new JButton("CH. 2");

    private JLabel chooseCharacterLabel = new JLabel("CHOOSE A CHARACTER");
    private JLabel newGameLabel = new JLabel("NEW GAME");

    private BufferedImage bufImg1 =  ImageIO.read(new File("../Images/Prozrachny_Vesely_2_kopia.png"));
    private Image characterOneImage = bufImg1.getScaledInstance(120,120, Image.SCALE_DEFAULT);
    private ImageIcon characterOneIcon = new ImageIcon(characterOneImage);
    private JLabel  characterOneLabelImage = new JLabel(characterOneIcon);

    private BufferedImage bufImg2 =  ImageIO.read(new File("../Images/Prozrachny_Vesely_kopia.png"));
    private Image characterTwoImage = bufImg2.getScaledInstance(120,120, Image.SCALE_DEFAULT);
    private ImageIcon characterTwoIcon = new ImageIcon(characterTwoImage);
    private JLabel  characterTwoLabelImage = new JLabel(characterTwoIcon);

    Container mainContainer = this.getContentPane();


    private JPanel topLabelPanel = new JPanel(new GridLayout(2,1));

    private JPanel newGameLabelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

    private JPanel chooseCharacterPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

    private JPanel characterGridPanel = new JPanel(new GridLayout(2 ,1));

    private JPanel characterOnePanel =  new JPanel(new FlowLayout());
    private JPanel characterTwoPanel =  new JPanel(new FlowLayout());


    public ChooseCharacterWindow() throws IOException
    {
        super("Tamagochi");
        this.getContentPane().setBackground(Color.YELLOW);
        this.setBounds(100,100,400,560);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainContainer.setLayout(new BorderLayout());

        chooseCharacterPanel.add(chooseCharacterLabel);
        newGameLabel.add(newGameLabel);

        topLabelPanel.add(newGameLabelPanel);
        topLabelPanel.add(chooseCharacterPanel);

        characterOnePanel.add(characterOneLabelImage);
        characterOnePanel.add(chooseCharacterOneBtn);

        characterOnePanel.add(characterTwoLabelImage);
        characterOnePanel.add(chooseCharacterTwoBtn);

        characterGridPanel.add(characterOnePanel);
        characterGridPanel.add(characterTwoPanel);

        mainContainer.add(topLabelPanel,BorderLayout.NORTH);
        mainContainer.add(characterGridPanel,BorderLayout.CENTER);

    }
}
