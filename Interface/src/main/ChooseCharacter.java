package main;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/** This class implements a character selection menu */
public class ChooseCharacter  extends  JFrame{

    /** Character selection button 1 - HACHAPURIK */
    public JButton chooseCharacterOneBtn = new JButton("HACHAPURIK");
    /** Character selection button 2 - ZELEBOBA */
    public JButton chooseCharacterTwoBtn = new JButton("ZELEBOBA");


    /** Label with the text "Choose a character" */
    private JLabel chooseCharacterLabel = new JLabel("  CHOOSE  A  CHARACTER  ");
    /** Label with the name of the new game window */
    private JLabel newGameLabel = new JLabel("  NEW GAME                     ");


    /** This field stores an image with the character 1 */
    public BufferedImage bufImg1 =  ImageIO.read(new File("../Images/Prozrachny_Vesely_kopia.png"));
    /** This field stores a resized image with the character 1 */
    private Image characterOneImage = bufImg1.getScaledInstance(180,180, Image.SCALE_DEFAULT);
    /** This field converts the image with the character 1 (characterOneImage) into an icon */
    private ImageIcon characterOneIcon = new ImageIcon(characterOneImage);
    /** This panel for icon with character 1 */
    private JLabel  characterOneLabelImage = new JLabel(characterOneIcon);

    /** This field stores an image with the character 2 */
    private BufferedImage bufImg2 =  ImageIO.read(new File("../Images/Prozrachny_Vesely_2_kopia.png"));
    /** This field stores a resized image with the character 2 */
    private Image characterTwoImage = bufImg2.getScaledInstance(180,180, Image.SCALE_DEFAULT);
    /** This field converts the image with the character 2 (characterTwoImage) into an icon */
    private ImageIcon characterTwoIcon = new ImageIcon(characterTwoImage);
    /** This panel for icon with character 2 */
    private JLabel  characterTwoLabelImage = new JLabel(characterTwoIcon);


    /** The upper panel with the name of the new game  window and text "choose a character" */
    private JPanel topLabelPanel = new JPanel(new GridLayout(2,1));

    /** The panel with the name of the window */
    private JPanel newGamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

    /** The panel with text "Choose a character */
    private JPanel chooseCharacterPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

    /** The panel with choose character */
    private JPanel characterGridPanel = new JPanel(new GridLayout(2 ,1));

    /** The panel with character 1 */
    private JPanel characterOnePanel =  new JPanel(new BorderLayout());
    /** The panel with character 2 */
    private JPanel characterTwoPanel =  new JPanel(new BorderLayout());


    /**
     * The constructor of the character selection class adds all the elements to the window
     * @throws IOException if an error occurs when calling the new game window
     */
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
