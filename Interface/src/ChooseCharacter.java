import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


public class ChooseCharacter  extends  JFrame{

    public JButton chooseCharacterOneBtn = new JButton("HACHAPURIK");
    public JButton chooseCharacterTwoBtn = new JButton("ZELEBOBA");


    private JLabel chooseCharacterLabel = new JLabel("  CHOOSE  A  CHARACTER  ");
    private JLabel newGameLabel = new JLabel("  NEW GAME                     ");


    public BufferedImage bufImg1 =  ImageIO.read(new File("../Images/Prozrachny_Vesely_kopia.png"));
    private Image characterOneImage = bufImg1.getScaledInstance(180,180, Image.SCALE_DEFAULT);
    private ImageIcon characterOneIcon = new ImageIcon(characterOneImage);
    private JLabel  characterOneLabelImage = new JLabel(characterOneIcon);

    private BufferedImage bufImg2 =  ImageIO.read(new File("../Images/Prozrachny_Vesely_2_kopia.png"));
    private Image characterTwoImage = bufImg2.getScaledInstance(180,180, Image.SCALE_DEFAULT);
    private ImageIcon characterTwoIcon = new ImageIcon(characterTwoImage);
    private JLabel  characterTwoLabelImage = new JLabel(characterTwoIcon);


    private JPanel topLabelPanel = new JPanel(new GridLayout(2,1));

    private JPanel newGamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

    private JPanel chooseCharacterPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

    private JPanel characterGridPanel = new JPanel(new GridLayout(2 ,1));

    private JPanel characterOnePanel =  new JPanel(new BorderLayout());
    private JPanel characterTwoPanel =  new JPanel(new BorderLayout());


    public ChooseCharacter() throws IOException
    {
        super("Tamagochi");

        this.setBounds(200,200,400,560);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Container mainContainer = this.getContentPane();
        mainContainer.setLayout(new BorderLayout());
        mainContainer.setBackground(new Color(248,252,116));


        mainContainer.add(topLabelPanel,BorderLayout.NORTH);
        topLabelPanel.setBackground(new Color(248,252,116));


        topLabelPanel.add(newGamePanel);
        newGamePanel.setBackground(new Color(248,252,116));

        topLabelPanel.add(chooseCharacterPanel);
        chooseCharacterPanel.setBackground(new Color(248,252,116));


        newGamePanel.add(newGameLabel);
        newGameLabel.setOpaque(true);
        newGameLabel.setBackground(new Color(237,52,192));
        newGameLabel.setForeground(Color.WHITE);
        newGameLabel.setFont(new Font("Arial", Font.PLAIN, 24));

        chooseCharacterPanel.add(chooseCharacterLabel);
        chooseCharacterLabel.setOpaque(true);
        chooseCharacterLabel.setBackground(new Color(203,147,24));
        chooseCharacterLabel.setForeground(Color.WHITE);
        chooseCharacterLabel.setFont(new Font("Arial", Font.PLAIN, 24));



        mainContainer.add(characterGridPanel,BorderLayout.CENTER);
        characterGridPanel.add(characterOnePanel);
        characterGridPanel.add(characterTwoPanel);


        characterOnePanel.setBackground(new Color(248,252,116));
        characterOnePanel.add(characterOneLabelImage, BorderLayout.CENTER);

        characterTwoPanel.setBackground(new Color(248,252,116));
        characterTwoPanel.add(characterTwoLabelImage, BorderLayout.CENTER);


        characterOnePanel.add(chooseCharacterOneBtn, BorderLayout.SOUTH);
        chooseCharacterOneBtn.setOpaque(true);
        chooseCharacterOneBtn.setBackground(new Color(237,52,192));
        chooseCharacterOneBtn.setForeground(Color.WHITE);
        chooseCharacterOneBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        chooseCharacterOneBtn.setPreferredSize(new Dimension(73,25));

        characterTwoPanel.add(chooseCharacterTwoBtn, BorderLayout.SOUTH);
        chooseCharacterTwoBtn.setOpaque(true);
        chooseCharacterTwoBtn.setBackground(new Color(203,147,24));
        chooseCharacterTwoBtn.setForeground(Color.WHITE);
        chooseCharacterTwoBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        chooseCharacterTwoBtn.setPreferredSize(new Dimension(73,25));

    }
}
