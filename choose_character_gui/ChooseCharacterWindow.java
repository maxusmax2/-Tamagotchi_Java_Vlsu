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


    private GridBagConstraints constraints = new GridBagConstraints();

    private JButton chooseCharacterOneBtn = new JButton("CH. 1");
    private JButton chooseCharacterTwoBtn = new JButton("CH. 2");

    private JLabel chooseCharacterLabel = new JLabel("  CHOOSE  A  CHARACTER  ");
    private JLabel newGameLabel = new JLabel("  NEW GAME                     ");

    private BufferedImage bufImg1 =  ImageIO.read(new File("../Images/Prozrachny_Vesely_kopia.png"));
    private Image characterOneImage = bufImg1.getScaledInstance(180,180, Image.SCALE_DEFAULT);
    private ImageIcon characterOneIcon = new ImageIcon(characterOneImage);
    private JLabel  characterOneLabelImage = new JLabel(characterOneIcon);

    private BufferedImage bufImg2 =  ImageIO.read(new File("../Images/Prozrachny_Vesely_2_kopia.png"));
    private Image characterTwoImage = bufImg2.getScaledInstance(180,180, Image.SCALE_DEFAULT);
    private ImageIcon characterTwoIcon = new ImageIcon(characterTwoImage);
    private JLabel  characterTwoLabelImage = new JLabel(characterTwoIcon);

    Container mainContainer = this.getContentPane();

    private JPanel chooseCharacterBtnPanelOne = new JPanel(new BorderLayout());
    private JPanel chooseCharacterBtnPanelTwo = new JPanel(new BorderLayout());

    private JPanel topLabelPanel = new JPanel(new GridLayout(2,1));

    private JPanel newGamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

    private JPanel chooseCharacterPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

    private JPanel characterGridPanel = new JPanel(new GridLayout(2 ,1));

    private JPanel characterOnePanel =  new JPanel(new GridBagLayout());
    private JPanel characterTwoPanel =  new JPanel(new GridBagLayout());


    public ChooseCharacterWindow() throws IOException
    {
        super("Tamagochi");
        this.setBounds(200,200,400,560);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainContainer.setLayout(new BorderLayout());
        mainContainer.setBackground(new Color(248,252,116));

        newGameLabel.setOpaque(true);
        newGameLabel.setBackground(new Color(237,52,192));
        newGameLabel.setForeground(Color.WHITE);
        newGameLabel.setFont(new Font("Arial", Font.PLAIN, 24));

        chooseCharacterLabel.setOpaque(true);
        chooseCharacterLabel.setBackground(new Color(203,147,24));
        chooseCharacterLabel.setForeground(Color.WHITE);
        chooseCharacterLabel.setFont(new Font("Arial", Font.PLAIN, 24));

        chooseCharacterOneBtn.setOpaque(true);
        chooseCharacterOneBtn.setBackground(new Color(237,52,192));
        chooseCharacterOneBtn.setForeground(Color.WHITE);
        chooseCharacterOneBtn.setFont(new Font("Arial", Font.PLAIN, 20));
//        chooseCharacterOneBtn.setPreferredSize(new Dimension(205,35));

        chooseCharacterTwoBtn.setOpaque(true);
        chooseCharacterTwoBtn.setBackground(new Color(203,147,24));
        chooseCharacterTwoBtn.setForeground(Color.WHITE);
        chooseCharacterTwoBtn.setFont(new Font("Arial", Font.PLAIN, 20));
//        chooseCharacterTwoBtn.setPreferredSize(new Dimension(205,35));

        chooseCharacterBtnPanelOne.setBackground(new Color(248,252,116));
        topLabelPanel.setBackground(new Color(248,252,116));
        newGamePanel.setBackground(new Color(248,252,116));
        chooseCharacterPanel.setBackground(new Color(248,252,116));
        characterOnePanel.setBackground(new Color(248,252,116));
        characterTwoPanel.setBackground(new Color(248,252,116));


        chooseCharacterPanel.add(chooseCharacterLabel);
        newGamePanel.add(newGameLabel);

        topLabelPanel.add(newGamePanel);
        topLabelPanel.add(chooseCharacterPanel);


        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 2;
        characterOnePanel.add(characterOneLabelImage,constraints);


        chooseCharacterBtnPanelOne.add(chooseCharacterOneBtn);
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridheight = 1;
        characterOnePanel.add(chooseCharacterBtnPanelOne,constraints);



        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 2;
        characterTwoPanel.add(characterTwoLabelImage,constraints);

        chooseCharacterBtnPanelTwo.add(chooseCharacterTwoBtn);
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridheight = 1;
        characterTwoPanel.add(chooseCharacterBtnPanelTwo,constraints);


        characterGridPanel.add(characterOnePanel);
        characterGridPanel.add(characterTwoPanel);

        mainContainer.add(topLabelPanel,BorderLayout.NORTH);
        mainContainer.add(characterGridPanel,BorderLayout.WEST);

    }
}
